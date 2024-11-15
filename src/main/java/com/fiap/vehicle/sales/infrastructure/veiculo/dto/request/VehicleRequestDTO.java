package com.fiap.vehicle.sales.infrastructure.veiculo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class VehicleRequestDTO {

    @Schema(description = "ID do veículo", example = "12345")
    @NotNull(message = "ID do veículo é obrigatório")
    private Long vehicleId;

    @Schema(description = "Marca do veículo", example = "Toyota")
    @NotNull(message = "Marca é obrigatória")
    @Size(min = 1, max = 50, message = "Marca deve ter entre 1 e 50 caracteres")
    private String make;

    @Schema(description = "Modelo do veículo", example = "Corolla")
    @NotNull(message = "Modelo é obrigatório")
    @Size(min = 1, max = 50, message = "Modelo deve ter entre 1 e 50 caracteres")
    private String model;

    @Schema(description = "Cor do veículo", example = "Preto")
    private String color;

    @Schema(description = "Quilometragem do veículo", example = "15000")
    @Positive(message = "Quilometragem deve ser positiva")
    private Integer mileage;

    @Schema(description = "Preço do veículo", example = "85000.00")
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private BigDecimal price;

    @Schema(description = "Status do veículo", example = "AVAILABLE")
    @NotNull(message = "Status é obrigatório")
    private String status;

    @Schema(description = "Data de fabricação do veículo", example = "2022-05-15T10:15:30Z")
    @NotNull(message = "Data de fabricação é obrigatória")
    private OffsetDateTime dataFabricacao;

    // Getters e Setters
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(OffsetDateTime dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}
