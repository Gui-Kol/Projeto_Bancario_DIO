package com.seuprojeto; // Ajuste o nome do pacote

import com.seuprojeto.model.Cliente;
import com.seuprojeto.model.Conta;
import com.seuprojeto.model.ContaCorrente;
import com.seuprojeto.model.ContaPoupanca;
import com.seuprojeto.repository.ContaRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ContaRepository contaRepository = new ContaRepository();
    private static int proximoNumeroConta = 1001; // Contador para gerar números de conta

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        criarConta();
                        break;
                    case 2:
                        realizarDeposito();
                        break;
                    case 3:
                        realizarSaque();
                        break;
                    case 4:
                        realizarTransferencia();
                        break;
                    case 5:
                        exibirContas();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Obrigado!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
                opcao = -1; // Para continuar o loop
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                opcao = -1;
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine(); // Espera o usuário pressionar Enter
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("--- Sistema Bancário DIO ---");
        System.out.println("1. Criar Conta");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Transferir (PIX)");
        System.out.println("5. Exibir Todas as Contas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarConta() {
        System.out.println("\n--- Criar Nova Conta ---");
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();

        Cliente novoCliente = new Cliente(nomeCliente, cpfCliente);

        System.out.print("Tipo de Conta (1-Corrente, 2-Poupança): ");
        int tipoConta = scanner.nextInt();
        scanner.nextLine();

        String numeroConta = String.valueOf(proximoNumeroConta++);
        String agencia = "0001"; // Agência padrão

        Conta novaConta = null;
        if (tipoConta == 1) {
            System.out.print("Informe o limite do cheque especial para Conta Corrente: ");
            double limiteChequeEspecial = scanner.nextDouble();
            scanner.nextLine();
            novaConta = new ContaCorrente(numeroConta, agencia, novoCliente, limiteChequeEspecial);
        } else if (tipoConta == 2) {
            novaConta = new ContaPoupanca(numeroConta, agencia, novoCliente);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        if (novaConta != null) {
            contaRepository.adicionarConta(novaConta);
            System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumeroConta());
        }
    }

    private static void realizarDeposito() {
        System.out.println("\n--- Realizar Depósito ---");
        System.out.print("Número da Conta: ");
        String numConta = scanner.nextLine();
        System.out.print("Valor a Depositar: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Optional<Conta> contaOpt = contaRepository.buscarContaPorNumero(numConta);
        if (contaOpt.isPresent()) {
            contaOpt.get().depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarSaque() {
        System.out.println("\n--- Realizar Saque ---");
        System.out.print("Número da Conta: ");
        String numConta = scanner.nextLine();
        System.out.print("Valor a Sacar: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Optional<Conta> contaOpt = contaRepository.buscarContaPorNumero(numConta);
        if (contaOpt.isPresent()) {
            contaOpt.get().sacar(valor); // Polimorfismo em ação: chama o sacar específico da conta
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void realizarTransferencia() {
        System.out.println("\n--- Realizar Transferência (PIX) ---");
        System.out.print("Número da sua Conta de Origem: ");
        String numContaOrigem = scanner.nextLine();
        System.out.print("Número da Conta Destino: ");
        String numContaDestino = scanner.nextLine();
        System.out.print("Valor a Transferir: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Optional<Conta> contaOrigemOpt = contaRepository.buscarContaPorNumero(numContaOrigem);
        Optional<Conta> contaDestinoOpt = contaRepository.buscarContaPorNumero(numContaDestino);

        if (contaOrigemOpt.isPresent() && contaDestinoOpt.isPresent()) {
            contaOrigemOpt.get().transferir(contaDestinoOpt.get(), valor);
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    private static void exibirContas() {
        System.out.println("\n--- Contas Cadastradas ---");
        List<Conta> todasContas = contaRepository.listarTodasContas();
        if (todasContas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada ainda.");
        } else {
            for (Conta conta : todasContas) {
                conta.exibirInformacoes();
                System.out.println("-------------------------");
            }
        }
    }

    // Ações para investimento e histórico podem ser adicionadas aqui
    // Ex: uma classe Transacao (talvez um record) e uma List<Transacao> em Conta
}