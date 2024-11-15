package com.fiap.vehicle.sales.domain.entity.veiculo.gateway;



import com.fiap.vehicle.sales.domain.entity.veiculo.model.Vehicle;


import java.util.List;
import java.util.Optional;


public interface VehicleGateway {

    Vehicle salvar(Vehicle vehicle);

    List<Vehicle> listarDisponiveisOrdenadosPorPreco();

    List<Vehicle> listarVendidosOrdenadosPorPreco();
    Optional<Vehicle> buscarVeiculoPorId(Long vehicleId);

}
