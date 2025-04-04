package projetocod3rcampominado.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Tabuleiro implements CampoObservador{
    private final int linhas;
    private final int colunas;
    private final int minas;

    private final List<Campo> campos = new ArrayList<>();
    private final List<Consumer<ResultadoEvento>> observadores = new ArrayList<>();

    public void paraCadaCampo(Consumer<Campo> funcao){
        campos.forEach(funcao);
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void registrarObservador(Consumer<ResultadoEvento> observador){
        observadores.add(observador);
    }

    private void notificarObservadores(boolean resultado) {
        observadores.stream().forEach(o -> o.accept(new ResultadoEvento(resultado)));
    }

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
        } catch (Exception e) {
            // FIXME ajustar a implementação do método abrir
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    private void mostrarMinas(){
        campos.stream().
        filter(c -> c.isMinado()).
        filter(c -> !c.isMarcado()).
        forEach(c -> c.setAberto(true));
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
                Campo campo = new Campo(linha, coluna);
                campo.registrarObservador(this);
                campos.add(campo);
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
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        if(evento == CampoEvento.EXPLODIR){
            mostrarMinas();
            notificarObservadores(false);
        } else if(objetivoAlcancado()){
            notificarObservadores(true);
        }
    }
}
