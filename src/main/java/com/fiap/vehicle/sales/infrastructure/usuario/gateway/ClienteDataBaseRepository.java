// package com.fiap.vehicle.sales.infrastructure.usuario.gateway;
//
//
//import com.fiap.vehicle.sales.domain.entity.usuario.gateway.ClienteGateway;
//import com.fiap.vehicle.sales.domain.entity.usuario.model.Cliente;
//import com.fiap.vehicle.sales.infrastructure.persistence.cliente.ClienteEntity;
//import com.fiap.vehicle.sales.infrastructure.persistence.cliente.SpringClienteRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//public class ClienteDataBaseRepository implements ClienteGateway {
//private final SpringClienteRepository clienteRepository;
//private final ModelMapper modelMapper ;
//    public ClienteDataBaseRepository(SpringClienteRepository clienteRepository, ModelMapper modelMapper) {
//        this.clienteRepository = clienteRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    @Transactional()
//    public Cliente salvar(Cliente cliente) {
//        var clienteEntity = clienteRepository.saveAndFlush(modelMapper.map(cliente, ClienteEntity.class));
//        return modelMapper.map(clienteEntity, Cliente.class);
//    }
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<Cliente> buscarClientePorCPF(String cpf) {
//        var clienteEntity = clienteRepository.findById(cpf);
//        return clienteEntity.map(entity -> modelMapper.map(entity, Cliente.class));
//
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Page<Cliente> listarPaginado(Pageable pageable) {
//        Page<ClienteEntity> clienteEntitiesPage = clienteRepository.findAll(pageable);
//        return clienteEntitiesPage.map(entity -> modelMapper.map(entity, Cliente.class));
//    }
//
//}
