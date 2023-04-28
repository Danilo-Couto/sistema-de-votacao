package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.Scanner;

/**  * Principal. */
public class Principal {
  /**  * Principal. */
  public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);
    int option;
    ArrayList<PessoaCandidata> candidatos = new ArrayList<>();
    ArrayList<PessoaEleitora> eleitores = new ArrayList<>();

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.print("Entre com o nome da pessoa candidata: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o número da pessoa candidata: ");
          int numero = scanner.nextInt();
          candidatos.add(new PessoaCandidata(nome, numero));
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
      System.out.print("Entre com o número correspondente à opção desejada: ");
      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.print("Entre com o nome da pessoa eleitora: ");
          String nome = scanner.nextLine();
          System.out.print("Entre com o cpf da pessoa eleitora: ");
          String cpf = scanner.nextLine();
          eleitores.add(new PessoaEleitora(nome, cpf));
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
      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.out.print("Entre com o cpf da pessoa eleitora:");
          String cpf = scanner.nextLine();

          PessoaEleitora eleitor = null;
          for (PessoaEleitora e : eleitores) {
            if (e.getCpf().equals(cpf)) {
              eleitor = e;
              break;
            }
          }
          if (eleitor == null) {
            System.out.println("Eleitor não encontrado.");
            break;
          }

          System.out.print("Entre com o número da pessoa candidata: ");
          int numero = scanner.nextInt();
          PessoaCandidata candidato = null;
          for (PessoaCandidata c : candidatos) {
            if (c.getNumero() == numero) {
              candidato = c;
              break;
            }
          }
          if (candidato == null) {
            System.out.println("Candidato não encontrado.");
            break;
          }
          break;

        case 2:
          System.out.println("Resultado Parcial");
          break;

        case 3:
          System.out.println("Finalizar Votação");
          break;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    } while (option != 3);

  }
}
