package projetocod3rcampominado.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import projetocod3rcampominado.cm.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel {
    public PainelTabuleiro(Tabuleiro tabuleiro) {
        setLayout(new GridLayout(
                tabuleiro.getLinhas(), tabuleiro.getColunas()));
        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        SwingUtilities.invokeLater(() -> {
            tabuleiro.registrarObservador(e -> {
                if (e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "Ganhou :)");
                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu :(");
                }

                tabuleiro.reiniciarJogo();
            });
        });
    }
}
