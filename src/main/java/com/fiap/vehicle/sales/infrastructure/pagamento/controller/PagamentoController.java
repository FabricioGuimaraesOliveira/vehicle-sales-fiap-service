package com.fiap.vehicle.sales.infrastructure.pagamento.controller;

import com.fiap.vehicle.sales.domain.entity.pagamento.enums.StatusPagamento;
import com.fiap.vehicle.sales.infrastructure.authorization.JwtDecoder;
import com.fiap.vehicle.sales.infrastructure.pagamento.response.PagamentoResponseDTO;
import com.fiap.vehicle.sales.usecases.pagamento.PagamentoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@Tag(name = "sales", description = "API responsável pelo gerenciamento de vendas de veículos.")

public class PagamentoController {

    private final ModelMapper modelMapper;
    private final PagamentoUseCase pagamentoUseCase;
    private final JwtDecoder jwtDecoder;


    public PagamentoController(ModelMapper modelMapper, PagamentoUseCase pagamentoUseCase,JwtDecoder jwtDecoder) {
        this.modelMapper = modelMapper;
        this.pagamentoUseCase = pagamentoUseCase;
        this.jwtDecoder = jwtDecoder;
    }


    @Operation(summary = "Iniciar pagamento por ID do veículo e CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento iniciado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagamentoResponseDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Veículo não encontrado",
                    content = @Content) })
    @PostMapping("/iniciar/{vehicleId}")
    public PagamentoResponseDTO iniciarPagamento(@PathVariable Long vehicleId, @RequestHeader(value = "Authorization", required = false) String authorization) {
        var cpf = (authorization != null) ? jwtDecoder.decodeAndExtractCPF(authorization) : null;

        var pagamento = pagamentoUseCase.iniciarPagamento(vehicleId, cpf);
        return PagamentoResponseDTO.builder().codigo(pagamento.getId())
                        .qrCodeData(pagamento.getQrCode())
                .build();
    }

    @Operation(summary = "Endpoint para aprovar/rejeitar o pagamento da venda solicitada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento registrado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagamentoResponseDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado",
                    content = @Content) })
    @PostMapping("webhook/{pagamentoId}")
    @ResponseStatus(HttpStatus.OK)
    public void registrarPagamentoPorPedido(
            @PathVariable String pagamentoId,
            @RequestParam(name = "statusPagamento") StatusPagamento statusPagamento) {
        pagamentoUseCase.registrarPagamento(pagamentoId, statusPagamento);
    }
}
