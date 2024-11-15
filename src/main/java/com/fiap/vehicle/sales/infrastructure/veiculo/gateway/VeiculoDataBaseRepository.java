package com.fiap.vehicle.sales.infrastructure.veiculo.gateway;

import com.fiap.vehicle.sales.domain.entity.veiculo.gateway.VehicleGateway;
import com.fiap.vehicle.sales.domain.entity.veiculo.model.Vehicle;
import com.fiap.vehicle.sales.infrastructure.persistence.veiculo.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


public class VeiculoDataBaseRepository implements VehicleGateway {

    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<VehicleEntity> vehicleTable;
    private final ModelMapper modelMapper;

    public VeiculoDataBaseRepository(DynamoDbEnhancedClient enhancedClient, ModelMapper modelMapper, String tableName) {
        this.enhancedClient = enhancedClient;
        this.modelMapper = modelMapper;
        this.vehicleTable = enhancedClient.table(tableName, TableSchema.fromBean(VehicleEntity.class));
    }

    @Override
    public Vehicle salvar(Vehicle vehicle) {
        VehicleEntity vehicleEntity = modelMapper.map(vehicle, VehicleEntity.class);
        vehicleTable.putItem(vehicleEntity);
        return modelMapper.map(vehicleEntity, Vehicle.class);
    }

    @Override
    public List<Vehicle> listarDisponiveisOrdenadosPorPreco() {
        return vehicleTable.scan()
                .items()
                .stream()
                .filter(vehicleEntity -> "AVAILABLE".equals(vehicleEntity.getStatus())) // Filtra veículos disponíveis
                .sorted((v1, v2) -> v1.getPrice().compareTo(v2.getPrice())) // Ordena por preço
                .map(vehicleEntity -> modelMapper.map(vehicleEntity, Vehicle.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> listarVendidosOrdenadosPorPreco() {
        return vehicleTable.scan()
                .items()
                .stream()
                .filter(vehicleEntity -> "SOLD".equals(vehicleEntity.getStatus())) // Filtra veículos vendidos
                .sorted((v1, v2) -> v1.getPrice().compareTo(v2.getPrice())) // Ordena por preço
                .map(vehicleEntity -> modelMapper.map(vehicleEntity, Vehicle.class))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Vehicle> buscarVeiculoPorId(Long vehicleId) {
        Key key = Key.builder()
                .partitionValue(String.valueOf(vehicleId))
                .build();

        VehicleEntity vehicleEntity = vehicleTable.getItem(r -> r.key(key));

        return Optional.ofNullable(vehicleEntity)
                .map(entity -> modelMapper.map(entity, Vehicle.class));
    }

}
