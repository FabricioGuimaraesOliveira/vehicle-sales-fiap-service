package com.fiap.vehicle.sales.infrastructure.pagamento.gateway;

import com.fiap.vehicle.sales.domain.entity.pagamento.gateway.PagamentoGateway;
import com.fiap.vehicle.sales.domain.entity.pagamento.model.Pagamento;
import com.fiap.vehicle.sales.infrastructure.persistence.pagamento.PagamentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;


public class PagamentoDataBaseRepository implements PagamentoGateway {

    private final DynamoDbEnhancedClient enhancedClient;
    private final DynamoDbTable<PagamentoEntity> pagamentoTable;
    private final ModelMapper modelMapper;

    public PagamentoDataBaseRepository(DynamoDbEnhancedClient enhancedClient, ModelMapper modelMapper, String tableName) {
        this.enhancedClient = enhancedClient;
        this.modelMapper = modelMapper;
        this.pagamentoTable = enhancedClient.table(tableName, TableSchema.fromBean(PagamentoEntity.class));
    }

    @Override
    public void salvar(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = modelMapper.map(pagamento, PagamentoEntity.class);
        pagamentoTable.putItem(pagamentoEntity);
    }

    @Override
    public Optional<Pagamento> buscarPorId(String pagamentoId) {
        Key key = Key.builder().partitionValue(pagamentoId).build();
        PagamentoEntity pagamentoEntity = pagamentoTable.getItem(key);

        return Optional.ofNullable(pagamentoEntity).map(entity -> modelMapper.map(entity, Pagamento.class));
    }
}
