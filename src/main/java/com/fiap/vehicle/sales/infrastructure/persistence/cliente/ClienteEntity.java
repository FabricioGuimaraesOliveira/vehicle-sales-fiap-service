//package com.fiap.vehicle.sales.infrastructure.persistence.cliente;//package com.fiap.greentracefood.adapters.persistence.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.validator.constraints.br.CPF;
//
//import java.time.OffsetDateTime;
//
//@Entity
//@Data
//@Table(name = "clientes")
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//public class ClienteEntity {
//
//    @Id
//    @Size(max=11, min=11)
//    @CPF
//    private String cpf;
//
//    @Column(nullable = false)
//    private String nome;
//
//    @Column(nullable = false)
//    private String email;
//
//    @CreationTimestamp
//    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
//    private OffsetDateTime datacadastro;
//
//}