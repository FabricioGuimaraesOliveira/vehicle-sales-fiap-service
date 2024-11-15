package com.fiap.vehicle.sales.domain.entity.pagamento.gateway;


import com.fiap.vehicle.sales.domain.entity.pagamento.model.Pagamento;

import java.util.Optional;

public interface PagamentoGateway {
    void salvar(Pagamento pagamento);
    Optional<Pagamento> buscarPorId(String pagamentoId);

}
