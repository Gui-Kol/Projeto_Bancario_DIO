package com.seuprojeto.repository; // Ajuste o nome do pacote

import com.seuprojeto.model.Conta;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Usado para lidar com a possibilidade de não encontrar uma conta

public class ContaRepository {
    private List<Conta> contas; // Lista para armazenar as contas

    public ContaRepository() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
        System.out.println("Conta " + conta.getNumeroConta() + " adicionada ao repositório.");
    }

    public Optional<Conta> buscarContaPorNumero(String numero) {
        // Retorna um Optional<Conta> para indicar que a conta pode não ser encontrada
        return contas.stream()
                     .filter(c -> c.getNumeroConta().equals(numero))
                     .findFirst();
    }

    public List<Conta> listarTodasContas() {
        return new ArrayList<>(contas); // Retorna uma cópia para evitar modificações externas
    }

    // Adicione outros métodos se precisar remover ou atualizar contas
}