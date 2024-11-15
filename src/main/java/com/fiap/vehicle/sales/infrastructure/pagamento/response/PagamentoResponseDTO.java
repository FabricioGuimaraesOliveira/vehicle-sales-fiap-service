package com.fiap.vehicle.sales.infrastructure.pagamento.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.vehicle.sales.domain.entity.pagamento.enums.StatusPagamento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagamentoResponseDTO {
    @Schema(description = "Codigo do Pagamento", example = "2345677")
    private String codigo;
    @Schema(description = "Status do pagamento", example = "PAGO|NAO_PAGO")
    private StatusPagamento statusPagamento;
    @Schema(description = "Dados do QR Code para pagamento")
    private String qrCodeData;

}
