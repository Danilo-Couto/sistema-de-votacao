package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoVotacao {
  Scanner scanner = new Scanner(System.in);
  int option;
  ArrayList<PessoaCandidata> candidatos = new ArrayList<>();
  ArrayList<PessoaEleitora> eleitores = new ArrayList<>();
  ArrayList<String> cpfComputado = new ArrayList();
  int totalVotos = 0;

  public void mostrarResultado() {
    System.out.println("Total de votos: " + totalVotos);
  }

  public void run() {
    cadastrarPessoaCandidata();
    cadastrarPessoaEleitora();
    votar();
  }

  public void cadastrarPessoaCandidata() {
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
          if (candidatos.contains((numero))) {
            System.out.println("Número pessoa candidata já utilizado!");
            return;
          }
          candidatos.add(new PessoaCandidata(nome, numero));

        case 2:
          break;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    } while (option != 2);
  }

  public void cadastrarPessoaEleitora() {
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

          if (eleitores.contains((cpf))) {
            System.out.println("Pessoa eleitora já cadastrada!");
            return;
          }
          eleitores.add(new PessoaEleitora(nome, cpf));
          break;

        case 2:
          break;

        default:
          System.out.println("Entre com uma opção válida.");
          break;
      }
    } while (option != 2);


  }

  public void votar() {
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
          String cpfPessoaEleitora = scanner.nextLine();

          if (cpfComputado.contains((cpfPessoaEleitora))) {
            System.out.println("Pessoa eleitora já votou!");
            return;
          } else if (!eleitores.contains((cpfPessoaEleitora))) {
            System.out.println("Eleitor não encontrado.");
            return;
          }
//          else {
//            PessoaEleitora eleitor = null;
//            for (PessoaEleitora e : eleitores) {
//              if (e.getCpf().equals(cpfPessoaEleitora)) {
//                eleitor = e;
//                cpfComputado.add(e.getCpf());
//                break;
//              }
//            }
//            if (eleitor == null) {
//              System.out.println("Eleitor não encontrado.");
//              break;
//            }
//          }
          System.out.print("Entre com o número da pessoa candidata: ");
          int numeroPessoaCandidata = scanner.nextInt();
          PessoaCandidata candidato = null;
          for (PessoaCandidata c : candidatos) {
            if (c.getNumero() == numeroPessoaCandidata) {
              c.receberVoto();
              cpfComputado.add(cpfPessoaEleitora);
              return;
            } else {
              System.out.println("Candidato não encontrado.");
              break;
            }
          }
          // if (candidato == null) {}

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
