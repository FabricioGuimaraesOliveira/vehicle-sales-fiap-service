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
public class ClienteRequestDTO {

    @Schema(description = "CPF do Cliente", example = "34511780013")
    @NotNull(message = "CPF do Cliente não pode ser nullo")
    @CPF(message = "CPF Invalido")
    private String cpf;

    @Schema(description = "Nome do Cliente", example = "Cliente da Silva")
    @NotNull(message = "O nome do Cliente não pode ser nullo")
    private String nome;

    @Schema(description = "Email do Cliente", example = "cliente@gmail.com")
    private String email;
}
