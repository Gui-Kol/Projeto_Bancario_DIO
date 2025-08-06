# Sistema Bancário Básico em Java

Este projeto é uma implementação de um sistema bancário simples, desenvolvido em Java, com o objetivo de consolidar os conceitos fundamentais da Programação Orientada a Objetos (POO). Ele simula operações bancárias básicas através de uma interface de console, permitindo ao usuário interagir com diferentes tipos de contas e realizar transações.

## Funcionalidades Implementadas

O sistema bancário atual permite as seguintes operações:

*   **Criação de Contas:** Possibilita a abertura de novos tipos de contas, como Conta Corrente e Conta Poupança, associadas a um cliente.
*   **Depósitos:** Realiza o depósito de valores em qualquer conta existente, aumentando seu saldo.
*   **Saques:** Permite o saque de valores das contas, respeitando as regras específicas de cada tipo de conta (ex: Conta Corrente com cheque especial, Conta Poupança sem).
*   **Transferências (PIX):** Simula a transferência de valores entre duas contas diferentes dentro do sistema.
*   **Exibição de Contas:** Lista todas as contas cadastradas com suas informações atuais (número, agência, saldo, cliente).

## Conceitos de Programação Orientada a Objetos (POO) Aplicados

Este projeto foi construído aplicando os pilares da POO para criar um código modular, reutilizável e de fácil manutenção. Isso demonstra o entendimento e a aplicação prática dos conceitos fundamentais da programação orientada a objetos:

*   ### **Abstração**
    *   A classe `Conta` serve como uma representação **abstrata** de uma conta bancária. Ela define as características e comportamentos gerais que toda conta possui (como saldo, número, agência, e as ações de depositar e transferir). Por ser abstrata, não é possível criar uma `Conta` genérica, apenas seus tipos especializados (Corrente, Poupança), focando no conceito essencial de "conta".

*   ### **Herança**
    *   As classes `ContaCorrente` e `ContaPoupanca` **herdam** da classe `Conta`. Isso significa que elas automaticamente recebem todos os atributos (como `saldo`) e métodos (como `depositar` e `transferir`) da classe `Conta`. A herança promove o reuso de código, evitando a necessidade de reescrever as funcionalidades básicas em cada tipo de conta.

*   ### **Polimorfismo**
    *   O método `sacar` é um exemplo claro de **polimorfismo**. Ele é declarado na classe `Conta` (de forma abstrata) e é implementado de maneiras diferentes em `ContaCorrente` e `ContaPoupanca`. Ao chamar `conta.sacar(valor)`, o sistema executa a versão correta do método de acordo com o tipo real da `conta` (seja ela corrente ou poupança), demonstrando "muitas formas" para uma mesma operação.

*   ### **Encapsulamento**
    *   Os atributos das classes (por exemplo, `saldo` na `Conta`, `nome` no `Cliente`) são protegidos usando modificadores de acesso (`protected` ou `private`). O acesso e a modificação desses atributos são feitos exclusivamente através de métodos públicos (`getters` e `setters`). Isso garante a segurança e a integridade dos dados, controlando como eles podem ser acessados e alterados pelo restante do programa.

## Estrutura do Projeto

A organização do código segue uma estrutura de pacotes para melhor modularização e clareza:

MeuProjetoBancario/ ├── src/ │ └── main/ │ └── java/ │ └── com/ │ └── seuprojeto/ │ ├── model/ (Contém as classes que representam as entidades do sistema: Cliente, Conta, ContaCorrente, ContaPoupanca) │ ├── repository/ (Contém a classe ContaRepository, que simula o armazenamento de dados em memória) │ └── Main.java (É o ponto de entrada principal do programa, onde o menu interativo é exibido e a lógica de interação acontece) └── README.md


## Como Executar o Projeto

Para testar este sistema bancário, você pode usar um Ambiente de Desenvolvimento Integrado (IDE) ou executar diretamente pela linha de comando.

### Via IDE (IntelliJ IDEA, VS Code, Eclipse)

1.  **Abra o Projeto:** Importe a pasta `MeuProjetoBancario` como um projeto Java no seu IDE.
2.  **Localize a Classe Principal:** Navegue até o arquivo `Main.java` (geralmente em `src/main/java/com/seuprojeto/Main.java`).
3.  **Execute:** Clique com o botão direito do mouse no arquivo `Main.java` e selecione a opção para "Run" (Executar) a classe `Main` (geralmente "Run 'Main.main()'" ou similar).
4.  **Interaja:** O menu interativo do sistema bancário será exibido no console do seu IDE. Siga as instruções para criar contas, depositar, sacar, transferir, etc.

### Via Linha de Comando (Terminal)

1.  **Pré-requisitos:** Certifique-se de ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) instalado e configurado nas variáveis de ambiente do seu sistema para poder usar os comandos `javac` e `java`.
2.  **Navegue até a Pasta de Origem:** Abra o terminal (Prompt de Comando no Windows, Terminal no macOS/Linux) e navegue até a pasta onde estão os arquivos `.java` do seu projeto. Se a estrutura for a recomendada, será:
    ```bash
    cd /caminho/para/MeuProjetoBancario/src/main/java
    ```
    (Substitua `/caminho/para/MeuProjetoBancario` pelo caminho real da pasta do seu projeto).
3.  **Compile o Código:** Compile todos os arquivos `.java` do projeto. Este comando compilará os arquivos da pasta atual e de suas subpastas:
    ```bash
    javac com/seuprojeto/*.java com/seuprojeto/model/*.java com/seuprojeto/repository/*.java
    ```
    Após a compilação, você verá arquivos `.class` gerados nas respectivas pastas.
4.  **Execute o Programa:** Execute a classe principal `Main`, informando o nome completo do pacote:
    ```bash
    java com.seuprojeto.Main
    ```
5.  **Interaja:** O menu interativo do sistema bancário será exibido diretamente no seu terminal.

## Tecnologias Utilizadas

*   **Java:** Linguagem de programação utilizada para todo o desenvolvimento do projeto.

## Aprendizados e Reflexões

Durante o desenvolvimento deste projeto, tive a oportunidade de aprofundar meus conhecimentos em:

*   **Estruturação de Projetos Java:** Compreendi melhor como organizar classes em pacotes de forma lógica e a importância da modularização para manter o código limpo e organizado.
*   **Interação via Console:** Ganhei prática na construção de menus interativos, na leitura de entradas do usuário e no tratamento básico de diferentes tipos de dados.
*   **Tratamento de Exceções:** Implementei o uso de `try-catch` para lidar com entradas inválidas, tornando o programa mais robusto.

Este desafio foi fundamental para solidificar a teoria da Programação Orientada a Objetos na prática, permitindo-me aplicar conceitos como abstração, herança, polimorfismo e encapsulamento em um cenário real. Pude ver como esses pilares tornam o código mais compreensível, extensível e fácil de manter.

## Próximos Passos (Possíveis Melhorias Futuras)

Para expandir este projeto, algumas melhorias poderiam incluir:

*   Implementar a funcionalidade de **investimentos** para os clientes.
*   Adicionar um **histórico detalhado de transações** que registre cada operação realizada em uma conta.
*   Aprimorar a persistência de dados, atualmente em memória, para armazenar as informações de forma mais permanente (ex: em arquivos CSV, JSON ou em um banco de dados real).
*   Adicionar validações de entrada de dados mais robustas para garantir a integridade das informações.

## Autor

Guilherme Kolndorfer
Linkedin:  www.linkedin.com/in/guilherme-kolndorfer-b6836122b
