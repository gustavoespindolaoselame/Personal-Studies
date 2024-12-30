package projetocod3rcampominado.cm.visao;

import javax.swing.JFrame;

import projetocod3rcampominado.cm.modelo.Tabuleiro;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(){
        Tabuleiro tabuleiro = new Tabuleiro(16, 16, 48);
        add(new PainelTabuleiro(tabuleiro));

        setTitle("Campo Minado");
        setSize(690,438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
