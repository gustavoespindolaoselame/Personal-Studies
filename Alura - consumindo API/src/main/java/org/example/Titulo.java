package org.example;

import com.google.gson.annotations.SerializedName;

public class Titulo {

    @SerializedName("Title")
    private String nome;

    @SerializedName("Year")
    private int anoDeLancamento;

    private boolean incluidoNoPlano;

    private double somaDasAvaliacoes;

    private int totalDasAvaliacoes;

    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento, boolean incluidoNoPlano, double somaDasAvaliacoes, int totalDasAvaliacoes, int duracaoEmMinutos) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.incluidoNoPlano = incluidoNoPlano;
        this.somaDasAvaliacoes = somaDasAvaliacoes;
        this.totalDasAvaliacoes = totalDasAvaliacoes;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Titulo(TituloOmdb meuTituloOmdb){
        this.nome = meuTituloOmdb.title();
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year().substring(0, 4));
        try {
            try {
                this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, Integer.valueOf(meuTituloOmdb.runtime().indexOf(' '))));
            } catch (Exception e) {
            }

            try {
                this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
            } catch (Exception e) {
            }

        } catch (NumberFormatException e) {
            this.duracaoEmMinutos = 0;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public int getTotalDasAvaliacoes() {
        return totalDasAvaliacoes;
    }

    public void setTotalDasAvaliacoes(int totalDasAvaliacoes) {
        this.totalDasAvaliacoes = totalDasAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    @Override
    public String toString() {
        return  "Nome: '" + nome + "\nanoDeLancamento: " + anoDeLancamento + "\nDuração: " + duracaoEmMinutos + "\n";
    }
}
