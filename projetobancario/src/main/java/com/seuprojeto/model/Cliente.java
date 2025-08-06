package com.seuprojeto.model; // Ajuste o nome do pacote

public class Cliente {
    private String nome;
    private String cpf;
    // ... outros atributos como endereco, telefone, etc.

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e Setters (Encapsulamento)
    // Se estiver usando Lombok, adicione @Getter e @Setter aqui
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}