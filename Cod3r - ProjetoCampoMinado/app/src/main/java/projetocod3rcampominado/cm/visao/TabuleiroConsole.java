package projetocod3rcampominado.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import projetocod3rcampominado.cm.excecao.ExplosaoException;
import projetocod3rcampominado.cm.excecao.SairException;
import projetocod3rcampominado.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    private Scanner scanner = new Scanner(System.in);
    
    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo(){
        try{
            boolean continuar = true;
            while(continuar){
                cicloDojogo();
                
                System.err.println("Outra partida? (S/n)");
                String resposta = scanner.nextLine();
                if("n".equalsIgnoreCase(resposta)){
                    continuar = false;
                }
            }
        } catch(SairException e){
            System.out.println("tchau");
        } finally {
            scanner.close();
        }
    }

    private void cicloDojogo() {
        try {
            while(!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);
                String digitado = caputarValorDigitado("Digite (x,y): ");
                Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();
                digitado = caputarValorDigitado("1 - Abrir ou\n2 - (Des)marcar: ");
                if("1".equals(digitado)){
                    tabuleiro.abrir(xy.next(), xy.next());
                } else if("2".equals(digitado)){
                    tabuleiro.alternarMarcacao(xy.next(), xy.next());
                }
            }
            System.out.println(tabuleiro);
            System.err.println("Você ganhou");
        } catch (ExplosaoException e) {
            System.out.println(tabuleiro);
            System.out.println("Você perdeu");
        }
    }

    private String caputarValorDigitado(String texto){
        System.out.println(texto);
        String digitado = scanner.nextLine();

        if("sair".equalsIgnoreCase(digitado)){
        throw new SairException();
        }
        return digitado;
    }
}
