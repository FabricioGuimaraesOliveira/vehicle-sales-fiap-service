package com.fiap.vehicle.sales.usecases.pagamento;

import com.fiap.vehicle.sales.domain.entity.pagamento.enums.StatusPagamento;
import com.fiap.vehicle.sales.domain.entity.pagamento.gateway.PagamentoGateway;
import com.fiap.vehicle.sales.domain.entity.pagamento.model.Pagamento;
import com.fiap.vehicle.sales.domain.entity.veiculo.gateway.VehicleGateway;
import com.fiap.vehicle.sales.domain.entity.veiculo.model.Vehicle;
import com.fiap.vehicle.sales.infrastructure.exceptions.ResourceNotFoundException;
import com.fiap.vehicle.sales.infrastructure.mercadopago.gateway.MercadoPagoGateway;

import java.util.UUID;

public class PagamentoUseCase {

    private final PagamentoGateway pagamentoGateway;
    private final VehicleGateway vehicleGateway;
    private final MercadoPagoGateway mercadoPagoGateway;

    public PagamentoUseCase(PagamentoGateway pagamentoGateway, VehicleGateway vehicleGateway, MercadoPagoGateway mercadoPagoGateway) {
        this.pagamentoGateway = pagamentoGateway;
        this.vehicleGateway = vehicleGateway;
        this.mercadoPagoGateway = mercadoPagoGateway;
    }

    public Pagamento iniciarPagamento(Long vehicleId,String cpf) {
        Vehicle vehicle = buscarVeiculoPorId(vehicleId);
        String qrCode = gerarQRCode(vehicle);
       return  atualizarStatusPagamento(vehicle,cpf,qrCode);
    }

    private Vehicle buscarVeiculoPorId(Long vehicleId) {
        return vehicleGateway.buscarVeiculoPorId(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado"));
    }

    private String gerarQRCode(Vehicle vehicle) {
        // Supondo que existe um método para obter o valor do veículo
        return mercadoPagoGateway.generateQRCodeMock(vehicle.getVehicleId(), vehicle.getPrice());
    }

    private Pagamento atualizarStatusPagamento(Vehicle vehicle,String cpf,String qrcode) {
        Pagamento pagamento = Pagamento.builder()
                .id(UUID.randomUUID().toString())
                .status(StatusPagamento.PAGAMENTO_INICIADO)
                .veiculoId(vehicle.getVehicleId())
                .cpf(cpf)
                .qrCode(qrcode)
                .build();
        pagamentoGateway.salvar(pagamento);
        return pagamento;
    }

    public void registrarPagamento(String pagamentoId, StatusPagamento statusPagamento) {
        if (statusPagamento != StatusPagamento.REJEITADO && statusPagamento != StatusPagamento.APROVADO) {
            throw new IllegalArgumentException("O status do pagamento deve ser REJEITADO ou APROVADO");
        }

        Pagamento pagamento = pagamentoGateway.buscarPorId(pagamentoId)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        pagamento.setStatus(statusPagamento);
        pagamentoGateway.salvar(pagamento);
        // Atualizar o status do veículo se o pagamento for aprovado
        vehicleGateway.buscarVeiculoPorId(pagamento.getVeiculoId())
                .ifPresent(vehicle -> {
                    if (statusPagamento == StatusPagamento.APROVADO) {
                        vehicle.setStatus("SOLD"); // Define o status do veículo como "SOLD" se o pagamento for aprovado
                        vehicleGateway.salvar(vehicle);

                    }
                });
    }
}
