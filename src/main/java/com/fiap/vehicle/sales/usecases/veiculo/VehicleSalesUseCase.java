package com.fiap.vehicle.sales.usecases.veiculo;

import com.fiap.vehicle.sales.domain.entity.veiculo.gateway.VehicleGateway;
import com.fiap.vehicle.sales.domain.entity.veiculo.model.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleSalesUseCase {
    @Qualifier("customVehicleGateway")
    private final VehicleGateway vehicleGateway;

    public VehicleSalesUseCase(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    public Vehicle cadastrar(Vehicle vehicle) {
        return vehicleGateway.salvar(vehicle);
    }



    public List<Vehicle> listarDisponiveisPorPreco() {
        return vehicleGateway.listarDisponiveisOrdenadosPorPreco();
    }

    public List<Vehicle> listarVendidosPorPreco() {
        return vehicleGateway.listarVendidosOrdenadosPorPreco();
    }
}
