package projetocod3rcampominado.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import projetocod3rcampominado.cm.excecao.ExplosaoException;

public class Tabuleiro {
    private final int linhas;
    private final int colunas;
    private final int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int colunas, int linhas, int minas) {
        this.colunas = colunas;
        this.linhas = linhas;
        this.minas = minas;

        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }

    public void abrir(int linha, int coluna) {
        try {
            campos.parallelStream().
            filter(c -> c.getLinha() == linha && c.getColuna() == coluna).
            findFirst().
            ifPresent(c -> c.abrir());
        } catch (ExplosaoException e) {
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    public void alternarMarcacao(int linha, int coluna) {
        campos.parallelStream().
        filter(c -> c.getLinha() == linha && c.getColuna() == coluna).
        findFirst().
        ifPresent(c -> c.alternarMarcacao());
    }

    private void gerarCampos(){
        for(int linha=0;linha<linhas;linha++){
            for(int coluna=0;coluna<colunas;coluna++){
                campos.add(new Campo(linha,coluna));
            }
        }
    }

    private void associarVizinhos(){
        for(Campo c1: campos){
            for(Campo c2: campos){
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        do { 
            int aleatorio = (int) (Math.random()* campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(a -> a.isMinado()).count();
        } while (minasArmadas < minas);
    }

    public boolean objetivoAlcancado(){
        return campos.stream().allMatch(c -> c.objetivoAlcancado());
    }

    public void reiniciarJogo(){
        campos.stream().forEach(c -> c.reiniciar());
        sortearMinas();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append("  ");
        for(int coluna = 0; coluna < colunas; coluna++){
            stringBuilder.append("");
            stringBuilder.append(coluna + " ");
            stringBuilder.append("");
        }
        stringBuilder.append("\n");
        for(int linha = 0; linha < linhas; linha++){
            stringBuilder.append(linha + " ");
            for (int coluna = 0; coluna < colunas; coluna++){
                stringBuilder.append("");
                stringBuilder.append(campos.get(i).toString());
                stringBuilder.append("");
                i++;
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
