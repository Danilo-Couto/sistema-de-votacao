package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**  * GerenciamentoVotacao. */
public class GerenciamentoVotacao {

  ArrayList<PessoaCandidata> candidatos = new ArrayList<>();
  ArrayList<PessoaEleitora> eleitores = new ArrayList<>();
  ArrayList<String> cpfComputado = new ArrayList<>();
  int totalVotos = 0;


  public void mostrarResultado() {
    System.out.println("Total de votos: " + totalVotos);
  }

  /**  * cadastrarPessoaCandidata. */
  public void cadastrarPessoaCandidata(String pessoaCandidata, int numero) {
    for (PessoaCandidata c : candidatos) {
      if (c.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    candidatos.add(new PessoaCandidata(pessoaCandidata, numero));
  }

  /**  * cadastrarPessoaEleitora. */
  public void cadastrarPessoaEleitora(String pessoaEleitora, String cpf) {
    for (PessoaEleitora e : eleitores) {
      if (e.getCpf().equals(cpf)) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
      eleitores.add(new PessoaEleitora(pessoaEleitora, cpf));
    }
  }

  /**  * votar. */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    for (PessoaEleitora e : eleitores) {
      if (!e.getCpf().contains(cpfPessoaEleitora)) {
        System.out.println("Eleitor não encontrado.");
        return;
      }
    }

    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata c : candidatos) {
        if (c.getNumero() == numeroPessoaCandidata) {
          c.receberVoto();
          cpfComputado.add(cpfPessoaEleitora);
        } else {
          System.out.println("Candidato não encontrado.");
        }
        return;
      }
    }
  }

}
