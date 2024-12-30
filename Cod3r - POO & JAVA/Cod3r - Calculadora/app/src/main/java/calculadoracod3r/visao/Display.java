package calculadoracod3r.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import calculadoracod3r.modelo.Memoria;
import calculadoracod3r.modelo.MemoriaObservador;

public class Display extends JPanel implements MemoriaObservador{
    private final JLabel label;
    public Display(){

        Memoria.getInstancia().adicionarObservador(this);
        
        setBackground(new Color(54, 54, 54));
        label = new JLabel(Memoria.getInstancia().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 25));
        add(label);
    }

    @Override
    public void valorAlterado(String novoValor){
    label.setText(novoValor);
    }
}
