package com.seuprojeto.model; // Ajuste o nome do pacote

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numeroConta, String agencia, Cliente cliente) {
        super(numeroConta, agencia, cliente);
    }

    @Override // Sobreescreve o método 'sacar' da classe pai (Polimorfismo)
    public void sacar(double valor) {
        // Lógica de saque para conta poupança (sem cheque especial)
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso na conta poupança " + numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido para conta poupança.");
        }
    }

    public void renderJuros(double taxa) {
        // Lógica para render juros na poupança
        double juros = this.saldo * taxa;
        this.saldo += juros;
        System.out.println("Juros de " + juros + " aplicados na conta poupança " + numeroConta);
    }
}