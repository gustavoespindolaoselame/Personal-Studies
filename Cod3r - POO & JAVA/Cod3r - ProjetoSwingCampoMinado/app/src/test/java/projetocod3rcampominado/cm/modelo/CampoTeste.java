package projetocod3rcampominado.cm.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
    private Campo campo;

    @BeforeEach void inicializarCampo(){
        campo = new Campo(3, 3);
    }

    @Test void testeVizinhoHorizontal(){
        List<Campo> vizinhosTeste = new ArrayList<>(Arrays.asList(
        new Campo(3, 2),
        new Campo(3, 4)
        ));
        assertTrue(vizinhosTeste.stream().allMatch(a -> campo.adicionarVizinho(a)));
    }

    @Test void testeVizinhoVertical(){
        List<Campo> vizinhosTeste = new ArrayList<>(Arrays.asList(
        new Campo(4, 3),
        new Campo(2, 3)
        ));
        assertTrue(vizinhosTeste.stream().allMatch(a -> campo.adicionarVizinho(a)));
    }

    @Test void testeVizinhoDiagonais(){
        List<Campo> vizinhosTeste = new ArrayList<>(Arrays.asList(
        new Campo(2, 2),
        new Campo(2, 4),
        new Campo(4,2),
        new Campo(4, 4)
        ));
        assertTrue(vizinhosTeste.stream().allMatch(a -> campo.adicionarVizinho(a)));
    }

    @Test void testeVizinhoDistantes(){
        List<Campo> vizinhosTeste = new ArrayList<>(Arrays.asList(
        new Campo(1, 2),
        new Campo(1, 3),
        new Campo(1, 4),
        new Campo(1, 5)
        ));
        assertFalse(vizinhosTeste.stream().allMatch(a -> campo.adicionarVizinho(a)));
    }

    @Test void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }

    @Test void testeAlternarMarcacao(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test void testeAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());
    }

    @Test void testeAbrirNaoMinadoEMarcado(){
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test void testeAbrirMinadoEMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test void testeAbrirComVizinhos(){
        Campo vizinho11 = new Campo(1,1);
        Campo vizinho22 = new Campo(2,2);
        vizinho22.adicionarVizinho(vizinho11);
        campo.adicionarVizinho(vizinho22);
        campo.abrir();
        assertTrue(vizinho22.isAberto() && vizinho11.isAberto());
    }

    @Test void testeAbrirComVizinhosComVizinhoMinado(){
        Campo vizinho11 = new Campo(1,1);
        Campo vizinho12 = new Campo(1,1);
        vizinho12.minar();

        Campo vizinho22 = new Campo(2,2);
        vizinho22.adicionarVizinho(vizinho11);
        vizinho22.adicionarVizinho(vizinho12);
        campo.adicionarVizinho(vizinho22);
        campo.abrir();
        assertTrue(vizinho22.isAberto() && vizinho11.isFechado());
    }
}