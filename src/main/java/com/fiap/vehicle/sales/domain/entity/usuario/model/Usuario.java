package com.fiap.vehicle.sales.domain.entity.usuario.model;

import java.time.OffsetDateTime;

public class Usuario {
    private String cpf;
    private String nome;
    private String email;
    private OffsetDateTime datacadastro;

    public Usuario(String cpf, String nome, String email, OffsetDateTime datacadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.datacadastro = datacadastro;
    }

    public Usuario() {
    }

    public void atualizar(String nome,String email) {
        if ( nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        this.nome = nome;
        this.email = email;
    }

    public void validarCadastro() {
        if (this.cpf == null || this.cpf.isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (this.nome == null || this.nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (this.email == null || this.email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDatacadastro(OffsetDateTime datacadastro) {
        this.datacadastro = datacadastro;
    }
    public OffsetDateTime getDatacadastro() {
        return datacadastro;
    }
}
