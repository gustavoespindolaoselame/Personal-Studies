package calculadoracod3r.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando {
        ZERAR, NUMERO, DIVISAO, MULTIPLICACAO, SUBTRACAO, SOMA, IGUAL, VIRGULA, SINAL;
    };

    private static final Memoria instancia = new Memoria();

    private final List<MemoriaObservador> observadores = new ArrayList<>();

    private TipoComando ultimaOperacao = null;
    private boolean substituir = false;
    private String textoAtual = "";
    private String textoBuffer = "";

    private Memoria() {
    }

    public static Memoria getInstancia() {
        return instancia;
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void adicionarObservador(MemoriaObservador observador) {
        observadores.add(observador);
    }

    public void processarComando(String texto) {

        TipoComando tipoComando = detectarTipoComando(texto);
        if (tipoComando == null) {
            return;
        } else if (tipoComando == TipoComando.ZERAR) {
            textoAtual = "0";
            textoBuffer = "";
            substituir = false;
            ultimaOperacao = null;
        } else if (tipoComando == TipoComando.SINAL && textoAtual.contains("-")){
            textoAtual = textoAtual.substring(1);
        } else if(tipoComando == TipoComando.SINAL && !textoAtual.contains("-")){
            textoAtual = "-" + textoAtual;
        } else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
            textoAtual = substituir ? texto : textoAtual + texto;
            substituir = false;
        } else {
            substituir = true;
            textoAtual = obterResultadoOperacao();
            textoBuffer = textoAtual;
            ultimaOperacao = tipoComando;
        }
        observadores.forEach(o -> o.valorAlterado(textoAtual));
    }

    private String obterResultadoOperacao() {
        if(ultimaOperacao == null || ultimaOperacao == TipoComando.IGUAL){
            return textoAtual;
        }
        double numeroBuffer = Double.parseDouble(textoBuffer.replace(',', '.'));
        double numeroAtual = Double.parseDouble(textoAtual.replace(',', '.'));

        double resultado = 0;

        if(ultimaOperacao == TipoComando.SOMA){
            resultado = numeroBuffer + numeroAtual;
        }
        if(ultimaOperacao == TipoComando.MULTIPLICACAO){
            resultado =  numeroBuffer * numeroAtual;
        }
        if(ultimaOperacao == TipoComando.DIVISAO){
            resultado =  numeroBuffer / numeroAtual;
        }
        if(ultimaOperacao == TipoComando.SUBTRACAO){
            resultado = numeroBuffer - numeroAtual;
        }

        String resultadoString = Double.toString(resultado).replace('.', '.');
        boolean inteiro = resultadoString.endsWith(",0");
        if(inteiro){
            resultadoString = resultadoString.replace(",0", "");
        }
        return resultadoString;
    }

    private TipoComando detectarTipoComando(String texto) {
        if (textoAtual.isEmpty() && texto == "0") {
            return null;
        }

        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        } catch (NumberFormatException e) {
            if ("AC".equals(texto)) {
                return TipoComando.ZERAR;
            } else if ("+".equals(texto)) {
                return TipoComando.SOMA;
            } else if ("X".equals(texto)) {
                return TipoComando.MULTIPLICACAO;
            } else if ("/".equals(texto)) {
                return TipoComando.DIVISAO;
            } else if ("-".equals(texto)) {
                return TipoComando.SUBTRACAO;
            } else if ("=".equals(texto)) {
                return TipoComando.IGUAL;
            } else if ("±".equals(texto)) {
                return TipoComando.SINAL;
            }else if (",".equals(texto) && !textoAtual.contains(",")) {
                return TipoComando.VIRGULA;
            }
        }

        return null;
    }
}
