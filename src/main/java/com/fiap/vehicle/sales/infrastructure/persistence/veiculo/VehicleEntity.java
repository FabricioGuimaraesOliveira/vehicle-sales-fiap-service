package com.fiap.vehicle.sales.infrastructure.persistence.veiculo;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@DynamoDbBean
public class VehicleEntity {

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

    public VehicleEntity() {}

    public VehicleEntity(String vehicleId, String make, String model, String color, Integer mileage, BigDecimal price,
                         String status, OffsetDateTime dataFabricacao, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
        this.dataFabricacao = dataFabricacao;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("vehicleId")
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @DynamoDbAttribute("make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @DynamoDbAttribute("model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @DynamoDbAttribute("color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @DynamoDbAttribute("mileage")
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @DynamoDbAttribute("price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @DynamoDbAttribute("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDbAttribute("dataFabricacao")
    public OffsetDateTime getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(OffsetDateTime dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @DynamoDbAttribute("createdAt")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @DynamoDbAttribute("updatedAt")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleEntity that)) return false;
        return Objects.equals(getVehicleId(), that.getVehicleId()) &&
                Objects.equals(getMake(), that.getMake()) &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getColor(), that.getColor()) &&
                Objects.equals(getMileage(), that.getMileage()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getDataFabricacao(), that.getDataFabricacao()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleId(), getMake(), getModel(), getColor(), getMileage(), getPrice(), getStatus(),
                getDataFabricacao(), getCreatedAt(), getUpdatedAt());
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "vehicleId='" + vehicleId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
