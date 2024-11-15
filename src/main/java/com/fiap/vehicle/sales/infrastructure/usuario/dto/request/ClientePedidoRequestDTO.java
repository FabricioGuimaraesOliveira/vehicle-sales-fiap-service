package com.fiap.vehicle.sales.infrastructure.usuario.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

@Data
@EqualsAndHashCode
@ToString
public class ClientePedidoRequestDTO {
    @Schema(description = "CPF do Cliente", example = "34511780013")
    @NotNull(message = "CPF do Cliente não pode ser nullo")
    @CPF(message = "CPF do Cliente inválido")
    private String cpf;
}
