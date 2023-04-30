package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {
    short option;
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada:");
      option = scanner.nextShort();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.print("Entre com o nome da pessoa candidata: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o número da pessoa candidata: ");
          int numero = scanner.nextInt();

          votacao.cadastrarPessoaCandidata(nome, numero);
          break;

        case 2:
          break;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    } while (option != 2);


    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada:");
      option = scanner.nextShort();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.print("Entre com o nome da pessoa eleitora: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o cpf da pessoa eleitora: ");
          String cpf = scanner.nextLine();

          votacao.cadastrarPessoaEleitora(nome, cpf);
          break;

        case 2:
          break;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    } while (option != 2);


    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      option = scanner.nextShort();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.print("Entre com o cpf da pessoa eleitora:");
          String cpfPessoaEleitora = scanner.nextLine();
          System.out.print("Entre com o número da pessoa candidata: ");
          int numeroPessoaCandidata = scanner.nextInt();

          votacao.votar(cpfPessoaEleitora, numeroPessoaCandidata);
          break;

        case 2:
          System.out.println("Resultado Parcial");
          break;

        case 3:
          System.out.println("Finalizando Votação");
          break;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    } while (option != 3);

  }
}
