package com.trybe.acc.java.sistemadevotacao;

import static java.lang.Math.round;

import java.util.ArrayList;
import java.util.List;

/**  * GerenciamentoVotacao. */
public class GerenciamentoVotacao {

  List<PessoaCandidata> candidatos = new ArrayList<>();
  List<PessoaEleitora> eleitores = new ArrayList<>();
  List<String> cpfComputado = new ArrayList<>();
  int totalVotos = 0;

  /**  * cadastrarPessoaCandidata. */
  public void cadastrarPessoaCandidata(String pessoaCandidata, int numero) {
    for (PessoaCandidata c : candidatos) {
      if (c.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    candidatos.add(new PessoaCandidata(pessoaCandidata, numero));
    System.out.println("Candidato cadastrado com sucesso!");
  }

  /**  * cadastrarPessoaEleitora. */
  public void cadastrarPessoaEleitora(String pessoaEleitora, String cpf) {
    for (PessoaEleitora e : eleitores) {
      if (e.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    eleitores.add(new PessoaEleitora(pessoaEleitora, cpf));
    System.out.println("Eleitor cadastrado com sucesso!");
  }

  /**  * votar. */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (PessoaEleitora e : eleitores) {
      if (e.getCpf().equals(cpfPessoaEleitora)) {
        if (cpfComputado.contains(cpfPessoaEleitora)) {
          System.out.println("Pessoa eleitora já votou!");
          return;
        }

        if (candidatos.isEmpty()) {
          System.out.println("Não há candidatos cadastrados.");
          return;
        }

        for (PessoaCandidata c : candidatos) {
          if (c.getNumero() == numeroPessoaCandidata) {
            c.receberVoto();
            cpfComputado.add(cpfPessoaEleitora);
            this.totalVotos++;
            System.out.println("Voto registrado.");
            return;
          }
        }

        System.out.println("Candidato não encontrado.");
        return;
      }
    }
    System.out.println("Eleitor não encontrado.");
  }

  /**  * mostrarResultado. */
  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata c : candidatos) {
        System.out.println(
            "Nome: " + c.getNome()
                + " - " + c.getVotos() + " votos"
                + "( " + calcularPorcentagemVotos(candidatos.indexOf(c)) + "% )"
        );
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }

  private double calcularPorcentagemVotos(int index) {
    return (double) (candidatos.get(index).getVotos()) / totalVotos * 100;
  }

}