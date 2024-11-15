package com.fiap.vehicle.sales.infrastructure.veiculo.dto.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class VehicleResponseDTO {

    private String vehicleId;
    private String make;
    private String model;
    private String color;
    private Integer mileage;
    private BigDecimal price;
    private String status;
    private OffsetDateTime dataFabricacao;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // Getters e Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
