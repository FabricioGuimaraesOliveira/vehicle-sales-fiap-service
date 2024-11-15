package com.fiap.vehicle.sales.infrastructure.veiculo.controller;

import com.fiap.vehicle.sales.domain.entity.veiculo.model.Vehicle;
import com.fiap.vehicle.sales.infrastructure.veiculo.dto.request.VehicleRequestDTO;
import com.fiap.vehicle.sales.infrastructure.veiculo.dto.response.VehicleResponseDTO;
import com.fiap.vehicle.sales.usecases.veiculo.VehicleSalesUseCase;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sales/vehicles")
@Tag(name = "vehicle-sales", description = "API responsável pelo inventário de veículos para venda")
public class VehicleSalesController {

    private final VehicleSalesUseCase vehicleSalesUseCase;
    private final ModelMapper modelMapper;

    public VehicleSalesController(VehicleSalesUseCase vehicleSalesUseCase, ModelMapper modelMapper) {
        this.vehicleSalesUseCase = vehicleSalesUseCase;
        this.modelMapper = modelMapper;
    }

    @Operation(summary = "Listar veículos disponíveis para venda, ordenados por preço (ascendente)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de veículos à venda",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleResponseDTO.class)) })
    })
    @GetMapping("/available")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleResponseDTO> listarVeiculosDisponiveis() {
        List<Vehicle> availableVehicles = vehicleSalesUseCase.listarDisponiveisPorPreco();
        return availableVehicles.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Listar veículos vendidos, ordenados por preço (ascendente)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de veículos vendidos",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleResponseDTO.class)) })
    })
    @GetMapping("/sold")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleResponseDTO> listarVeiculosVendidos() {
        List<Vehicle> soldVehicles = vehicleSalesUseCase.listarVendidosPorPreco();
        return soldVehicles.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Cadastrar um Veículo para Venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso ao cadastrar o Veículo para venda",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro ao cadastrar o Veículo", content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleResponseDTO cadastrarVehicle(@RequestBody @Valid VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = new Vehicle(
                vehicleRequestDTO.getVehicleId(),
                vehicleRequestDTO.getMake(),
                vehicleRequestDTO.getModel(),
                vehicleRequestDTO.getColor(),
                vehicleRequestDTO.getMileage(),
                vehicleRequestDTO.getPrice(),
                vehicleRequestDTO.getStatus(),
                vehicleRequestDTO.getDataFabricacao(),
                OffsetDateTime.now()
        );

        Vehicle savedVehicle = vehicleSalesUseCase.cadastrar(vehicle);
        return mapToResponseDTO(savedVehicle);
    }

    private VehicleResponseDTO mapToResponseDTO(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleResponseDTO.class);
    }
}
