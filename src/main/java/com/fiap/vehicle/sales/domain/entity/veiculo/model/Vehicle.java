package com.fiap.vehicle.sales.domain.entity.veiculo.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Vehicle {

    private Long vehicleId;
    private String make;
    private String model;
    private String color;
    private Integer mileage;
    private BigDecimal price;
    private String status;
    private OffsetDateTime dataFabricacao;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // Construtor sem vehicleId
    public Vehicle(Long vehicleId,String make, String model, String color, Integer mileage,
                   BigDecimal price, String status, OffsetDateTime dataFabricacao, OffsetDateTime createdAt) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.dataFabricacao = dataFabricacao;
        this.createdAt = createdAt;
        this.updatedAt = OffsetDateTime.now();
    }

    // Construtor padrão
    public Vehicle() {
    }

    // Método para atualizar os atributos de preço e status do veículo
    public void atualizar(BigDecimal price, String status) {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço não pode ser nulo ou negativo");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("O status não pode ser nulo ou vazio");
        }

        this.price = price;
        this.status = status;
        this.updatedAt = OffsetDateTime.now(); // Atualiza a data de atualização
    }

    // Método de validação dos dados obrigatórios do veículo
    public void validarCadastro() {
        if (this.make == null || this.make.isEmpty()) {
            throw new IllegalArgumentException("Marca não pode ser nula ou vazia");
        }
        if (this.model == null || this.model.isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser nulo ou vazio");
        }
        if (this.dataFabricacao == null) {
            throw new IllegalArgumentException("Data de fabricação não pode ser nula");
        }
    }

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
