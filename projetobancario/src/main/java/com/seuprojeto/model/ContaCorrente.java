package com.seuprojeto.model; // Ajuste o nome do pacote

public class ContaCorrente extends Conta { // 'extends' para herança
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String agencia, Cliente cliente, double limiteChequeEspecial) {
        super(numeroConta, agencia, cliente); // Chama o construtor da classe pai (Conta)
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override // Sobreescreve o método 'sacar' da classe pai (Polimorfismo)
    public void sacar(double valor) {
        // Lógica de saque para conta corrente (considerando cheque especial)
        if (valor > 0 && (this.saldo + this.limiteChequeEspecial) >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso na conta corrente " + numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido para conta corrente.");
        }
    }

    // Getter específico para ContaCorrente
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}