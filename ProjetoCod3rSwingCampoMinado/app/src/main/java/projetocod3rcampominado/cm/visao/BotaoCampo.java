package projetocod3rcampominado.cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import projetocod3rcampominado.cm.modelo.Campo;
import projetocod3rcampominado.cm.modelo.CampoEvento;
import projetocod3rcampominado.cm.modelo.CampoObservador;

public class BotaoCampo extends JButton implements CampoObservador, MouseListener {
    private Campo campo;
    private final Color BG_PADRAO = new Color(184, 184, 184);
    private final Color BG_MARCADO = new Color(8, 179, 247);
    private final Color BG_EXPLODIR = new Color(189, 66, 68);
    private final Color TEXTO_VERDE = new Color(0, 100, 0);

    public BotaoCampo(Campo campo) {
        this.campo = campo;
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        addMouseListener(this);
        campo.registrarObservador(this);
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento) {
            case ABRIR:
                aplicarEstiloAbrir();
                break;
            case MARCAR:
                aplicarEstiloMarcar();
                break;
            case EXPLODIR:
                aplicarEstilExplodir();
                break;
            default:
                aplicarEstilPadrao();
                break;
        }
        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }

    private void aplicarEstilPadrao() {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }

    private void aplicarEstilExplodir() {
        setBackground(BG_EXPLODIR);
        setText("X");
        setForeground(Color.white);
    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCADO);
        setText("M");
        setForeground(Color.BLACK);
    }

    private void aplicarEstiloAbrir() {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if(campo.isMinado()){
            setBackground(BG_EXPLODIR);
            setText("X");
            setForeground(Color.white);
            return;
        }

        switch ((int) campo.minasNaVizinhanca()) {
            case 0:
                break;
            case 1:
                setForeground(Color.green);
                break;
            case 2:
                setForeground(TEXTO_VERDE);
                break;
            case 3:
                setForeground(Color.cyan);
                break;
            case 4:
                setForeground(Color.blue);
                break;
            case 5:
                setForeground(Color.yellow);
                break;
            case 6:
                setForeground(Color.orange);
                break;
            case 7:
                setForeground(Color.red);
                break;
            case 8:
                setForeground(Color.pink);
                break;
            default:
                throw new AssertionError();
        }
        String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
        setText(valor);
    }

    // Interface dos eventos do mouse
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getButton());
        if (e.getButton() == 1) {
            campo.abrir();
        }
        if (e.getButton() == 3) {
            campo.alternarMarcacao();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
