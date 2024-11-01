package calculadoracod3r.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import calculadoracod3r.modelo.Memoria;

public class Teclado extends JPanel implements ActionListener {
    private final Color COR_CINZA_ESCURO = new Color(138, 138, 138);
    private final Color COR_CINZA_CLARO = new Color(168, 168, 168);
    private final Color COR_LARANJA = new Color(204, 167, 0);

    public Teclado() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        // Linha 1
        gridBagConstraints.gridwidth = 2;
        adicionarBotao("AC", COR_CINZA_ESCURO, gridBagConstraints, 0, 0);
        gridBagConstraints.gridwidth = 1;
        adicionarBotao("±", COR_CINZA_ESCURO, gridBagConstraints, 2, 0);
        adicionarBotao("/", COR_LARANJA, gridBagConstraints, 3, 0);

        // Linha 2
        adicionarBotao("7", COR_CINZA_CLARO, gridBagConstraints, 0, 1);
        adicionarBotao("8", COR_CINZA_CLARO, gridBagConstraints, 1, 1);
        adicionarBotao("9", COR_CINZA_CLARO, gridBagConstraints, 2, 1);
        adicionarBotao("X", COR_LARANJA, gridBagConstraints, 3, 1);

        // Linha 3
        adicionarBotao("4", COR_CINZA_CLARO, gridBagConstraints, 0, 2);
        adicionarBotao("5", COR_CINZA_CLARO, gridBagConstraints, 1, 2);
        adicionarBotao("6", COR_CINZA_CLARO, gridBagConstraints, 2, 2);
        adicionarBotao("-", COR_LARANJA, gridBagConstraints, 3, 2);

        // Linha 4
        adicionarBotao("1", COR_CINZA_CLARO, gridBagConstraints, 0, 3);
        adicionarBotao("2", COR_CINZA_CLARO, gridBagConstraints, 1, 3);
        adicionarBotao("3", COR_CINZA_CLARO, gridBagConstraints, 2, 3);
        adicionarBotao("+", COR_LARANJA, gridBagConstraints, 3, 3);

        // Linha 5
        gridBagConstraints.gridwidth = 2;
        adicionarBotao("0", COR_CINZA_CLARO, gridBagConstraints, 0, 4);
        gridBagConstraints.gridwidth = 1;
        adicionarBotao(",", COR_CINZA_CLARO, gridBagConstraints, 2, 4);
        adicionarBotao("=", COR_LARANJA, gridBagConstraints, 3, 4);
    }

    private void adicionarBotao(String texto, Color cor, GridBagConstraints gridBagConstraints, int x,
            int y) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);
        add(botao, gridBagConstraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton botao) {
            Memoria.getInstancia().processarComando(botao.getText());
        }
    }
}
