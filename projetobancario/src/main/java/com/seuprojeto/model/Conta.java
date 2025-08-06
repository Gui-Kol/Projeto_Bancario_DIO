package com.seuprojeto.model; // Ajuste o nome do pacote conforme sua estrutura

public abstract class Conta { // 'abstract' indica que é uma classe abstrata

    // Atributos (características)
    protected String numeroConta; // 'protected' para subclasses poderem acessar
    protected String agencia;
    protected double saldo;
    protected Cliente cliente; // Associa a conta a um cliente

    // Construtor: como criar um objeto Conta
    public Conta(String numeroConta, String agencia, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = 0.0; // Saldo inicial é 0
        this.cliente = cliente;
    }

    // Métodos (comportamentos)
    // Métodos abstratos que TODA conta deve ter, mas cada uma implementa do seu jeito
    public abstract void sacar(double valor); // Polimorfismo entra aqui!

    // Métodos concretos (implementação padrão para todas as contas)
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (this.saldo >= valor) {
            this.sacar(valor); // Usa o método sacar da conta de origem
            destino.depositar(valor); // Usa o método depositar da conta de destino
            System.out.println("Transferência de " + valor + " da conta " + numeroConta + " para " + destino.getNumeroConta() + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("--- Informações da Conta ---");
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
        System.out.println("Cliente: " + cliente.getNome()); // Exibe o nome do cliente
    }

    // Getters para acessar os atributos (Encapsulamento)
    // Se estiver usando Lombok, você pode adicionar @Getter aqui
    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}