package com.trybe.acc.java.sistemadevotacao;

/**  * PessoaCandidata. */

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**  * PessoaCandidata. */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos++;
  }
}
