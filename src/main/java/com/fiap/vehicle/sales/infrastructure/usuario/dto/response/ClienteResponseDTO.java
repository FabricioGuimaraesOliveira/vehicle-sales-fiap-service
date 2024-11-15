package com.fiap.vehicle.sales.infrastructure.usuario.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode
@ToString
public class ClienteResponseDTO {

    @Schema(description = "Nome do Cliente",example = "Cliente da Silva")
    private String nome;
    @Schema(description = "CPF do Cliente",example = "123.456.789-00")
    private String cpf;
    @Schema(description = "Email do Cliente",example = "cliente@gmail.com")
    private String email;
    @Schema(description = "Data de cadastro do  Cliente",example = "")
    private OffsetDateTime datacadastro;

}
