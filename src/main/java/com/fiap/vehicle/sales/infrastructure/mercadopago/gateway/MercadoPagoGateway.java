package com.fiap.vehicle.sales.infrastructure.mercadopago.gateway;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class MercadoPagoGateway {
    public String generateQRCodeMock(Long id, BigDecimal transactionAmount) {
        String  identification= String.format("%020d", id);
        String requestIdentification = UUID.randomUUID().toString();
        String amount = transactionAmount.toString();

        return identification +
                "COM.MERCADOLIBRE02013063638f1192a-5fd1-4180-a180-8bcae3556bc3" +
                requestIdentification + "5204" + amount +
                "53039865802BR5925IZABEL AAAA DE MELO6007BARUERI62070503***63040B6D";
    }
}