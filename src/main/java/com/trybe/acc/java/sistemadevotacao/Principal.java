package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**  * Principal. */
public class Principal {

  /**  * main. */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    registerCandidates(scanner, votacao);
    registerVoter(scanner, votacao);
    handleVotes(scanner, votacao);

    scanner.close();
  }

  private static void registerCandidates(Scanner scanner, GerenciamentoVotacao votacao) {
    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada:");

      short option = scanner.nextShort();

      switch (option) {
        case 1:
          scanner.nextLine();
          System.out.print("Entre com o nome da pessoa candidata: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o número da pessoa candidata: ");
          int numero = scanner.nextInt();
          scanner.nextLine();

          votacao.cadastrarPessoaCandidata(nome, numero);
          break;

        case 2:
          System.out.println("Finalizando cadastro de canditatos.");
          return;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    }
  }

  private static void registerVoter(Scanner scanner, GerenciamentoVotacao votacao) {
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada:");

      short option = scanner.nextShort();

      switch (option) {
        case 1:
          scanner.nextLine();
          System.out.print("Entre com o nome da pessoa eleitora: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o cpf da pessoa eleitora: ");
          String cpf = scanner.nextLine();

          votacao.cadastrarPessoaEleitora(nome, cpf);
          break;

        case 2:
          System.out.println("Finalizando cadastro de eleitores.");
          return;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    }
  }

  private static void handleVotes(Scanner scanner, GerenciamentoVotacao votacao) {
    while (true) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");

      short option = scanner.nextShort();

      switch (option) {
        case 1:
          scanner.nextLine();
          System.out.print("Entre com o cpf da pessoa eleitora:");
          String cpfPessoaEleitora = scanner.nextLine();
          System.out.print("Entre com o número da pessoa candidata: ");
          int numeroPessoaCandidata = scanner.nextInt();
          scanner.nextLine();

          votacao.votar(cpfPessoaEleitora, numeroPessoaCandidata);
          break;

        case 2:
          System.out.println("Resultado Parcial");
          votacao.mostrarResultado();
          break;

        case 3:
          System.out.println("Finalizando Votação");
          votacao.mostrarResultado();
          return;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    }
  }

}
