package projetocod3rcampominado.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import projetocod3rcampominado.cm.excecao.ExplosaoException;

public class Campo {
    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;

    public List<Campo> vizinhos = new ArrayList<>();

    public Campo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public boolean adicionarVizinho(Campo vizinho){
        boolean linhaDiferente = linha != vizinho.linha;
        boolean colunaDiferente = coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha-vizinho.getLinha());
        int deltaColuna = Math.abs(coluna-vizinho.getColuna());
        int deltaGeral = deltaColuna + deltaLinha;

        if(deltaGeral == 1 && !diagonal){
            vizinhos.add(vizinho);
        } else if (deltaGeral == 2 && diagonal){
            vizinhos.add(vizinho);
        } else {
            return false;
        }
        return true;
    }

    public void alternarMarcacao(){
        if(!aberto){
            marcado = !marcado;
        }
    }

    public boolean abrir(){
        if(!aberto && !marcado){
            aberto = true;

            if(minado){
                throw new ExplosaoException();
            }

            if(vizinhancaSegura()){
                vizinhos.forEach(v -> v.abrir());
            }

            return true;
        } else {
        return false;
        }
    }

    private boolean vizinhancaSegura(){
        return vizinhos.stream().noneMatch(a -> a.minado);
    }

    public boolean objetivoAlcancado(){
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    public long minasNaVizinhanca(){
        return vizinhos.stream().filter(a -> a.minado).count();
    }

    public void reiniciar(){
        aberto=false;
        minado=false;
        marcado=false;
    }

    @Override
    public String toString(){
        if(marcado){
            return "x ";
        } else if(aberto && minado){
            return "* ";
        } else if(aberto && minasNaVizinhanca()>0){
            return Long.toString(minasNaVizinhanca()) + " ";
        } else if(aberto){
            return "0 ";
        } else {
            return "? ";
        }
    }

    public void minar(){
        minado = true;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isFechado() {
        return !aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public boolean isMinado() {
        return minado;
    }

    public void setMinado(boolean minado) {
        this.minado = minado;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public List<Campo> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Campo> vizinhos) {
        this.vizinhos = vizinhos;
    }
}