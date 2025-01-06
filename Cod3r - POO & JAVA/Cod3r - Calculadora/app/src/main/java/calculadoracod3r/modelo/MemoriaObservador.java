package calculadoracod3r.modelo;

@FunctionalInterface
public interface MemoriaObservador {
    public void valorAlterado(String novoValor);
}
