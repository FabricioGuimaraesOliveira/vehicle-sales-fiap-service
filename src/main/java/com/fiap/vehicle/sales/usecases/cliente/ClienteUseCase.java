//package com.fiap.vehicle.sales.usecases.cliente;
//
//
//import com.fiap.vehicle.sales.domain.entity.usuario.gateway.ClienteGateway;
//import com.fiap.vehicle.sales.domain.entity.usuario.model.Cliente;
//import com.fiap.vehicle.sales.domain.entity.usuario.validator.CpfValidator;
//import com.fiap.vehicle.sales.infrastructure.exceptions.ResourceNotFoundException;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//
//public class ClienteUseCase {
//
//    final private ClienteGateway clienteGateway;
//
//    public ClienteUseCase(ClienteGateway clienteGateway) {
//        this.clienteGateway = clienteGateway;
//    }
//
//
//    public Cliente buscar(String cpf) {
//        return clienteGateway.buscarClientePorCPF(CpfValidator.sanitizar(cpf))
//                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o cpf: " + cpf));
//    }
//
//    public Cliente cadastrar(Cliente cliente) {
//        cliente.setCpf(CpfValidator.sanitizar(cliente.getCpf()));
//        cliente.validarCadastro();
//        var clientEntity = clienteGateway.salvar(cliente);
//        return clientEntity;
//    }
//
//    public Cliente atualizar(String cpf, Cliente request) {
//        var cliente = clienteGateway.buscarClientePorCPF(CpfValidator.sanitizar(cpf))
//                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o cpf: " + cpf));
//        cliente.atualizar(request.getNome(), request.getEmail());
//        return clienteGateway.salvar(cliente);
//    }
//
//    public Page<Cliente> listarPaginado(Pageable pageable) {
//        return clienteGateway.listarPaginado(pageable);
//    }
//
//}
