package com.fiap.vehicle.sales.domain.entity.pagamento.model;

import com.fiap.vehicle.sales.domain.entity.pagamento.enums.StatusPagamento;

public class Pagamento {
    private String id;
    private String cpf;
    private Long veiculoId;
    private String qrCode;
    private StatusPagamento status;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    // Construtor privado para o builder
    private Pagamento() {
    }

    // Método para iniciar o builder
    public static PagamentoBuilder builder() {
        return new PagamentoBuilder();
    }

    // Classe Builder para Pagamento
    public static class PagamentoBuilder {
        private Pagamento instancia = new Pagamento();

        private PagamentoBuilder() {
        }

        public PagamentoBuilder id(String id) {
            instancia.id = id;
            return this;
        }

        public PagamentoBuilder cpf(String cpf) {
            instancia.cpf = cpf;
            return this;
        }

        public PagamentoBuilder veiculoId(Long veiculoId) {
            instancia.veiculoId = veiculoId;
            return this;
        }

        public PagamentoBuilder qrCode(String qrCode) {
            instancia.qrCode = qrCode;
            return this;
        }

        public PagamentoBuilder status(StatusPagamento status) {
            instancia.status = status;
            return this;
        }

        public Pagamento build() {
            return instancia;
        }
    }
}
