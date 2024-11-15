//package com.fiap.vehicle.sales.infrastructure.controller;
//
//
//import com.fiap.vehicle.sales.domain.entity.pagamento.enums.StatusPagamento;
//import com.fiap.vehicle.sales.infrastructure.pagamento.response.PagamentoResponseDTO;
//import com.fiap.vehicle.sales.usecases.pagamento.PagamentoUseCase;
//import io.swagger.v3.oas.annotations.Hidden;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/pagamentos")
//@Tag(name = "pagamento", description = "API responsável pelo gerenciamento de pagamentos.")
//@Hidden
//public class PagamentoController {
//
//    private final PagamentoUseCase pagamentoUseCase;
//
//    public PagamentoController(PagamentoUseCase pagamentoUseCase) {
//        this.pagamentoUseCase = pagamentoUseCase;
//    }
//
//
//
//    @Operation(summary = "Iniciar pagamento")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Pagamento iniciado com sucesso",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = PagamentoResponseDTO.class)) }),
//            @ApiResponse(responseCode = "404", description = "Veículo não encontrado",
//                    content = @Content) })
//    @PostMapping("/iniciar/{vehicleId}")
//    public PagamentoResponseDTO iniciarPagamento(@PathVariable Long vehicleId, @RequestParam String cpf) {
//        var qrCode = pagamentoUseCase.iniciarPagamento(vehicleId, cpf);
//        return PagamentoResponseDTO.builder().qrCodeData(qrCode).build();
//    }
//
//    @Operation(summary = "Endpoint para aprovar/rejeitar o pagamento do pedido solicitado")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Pagamento registrado com sucesso",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = PagamentoResponseDTO.class)) }),
//            @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
//                    content = @Content) })
//    @PostMapping("webhook/{pagamentoId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void registrarPagamentoPorPedido(
//            @PathVariable Long pagamentoId,
//            @RequestParam(name = "statusPagamento") StatusPagamento statusPagamento) {
//        pagamentoUseCase.registrarPagamento(pagamentoId, statusPagamento);
//    }
//}