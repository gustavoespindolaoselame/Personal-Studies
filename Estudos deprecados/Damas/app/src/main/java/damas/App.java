package damas;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing");
        frame.setSize(960, 720);
        frame.setBackground(Color.WHITE);

        BufferedImage spriteSheet = null;
        try {
            spriteSheet = ImageIO.read(new File("app\\src\\main\\java\\damas\\spritesheet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Campo campo = new Campo(8, 8, frame.getWidth(), frame.getHeight());
        int campoX = (frame.getWidth() - campo.getWidth()) / 2;
        int campoY = (frame.getHeight() - campo.getHeight()) / 2;

        JPanel fundo = new JPanel();

        JPanel jcampo = new JPanel(new GridLayout(campo.getLinhas(), campo.getColunas(), 0, 0));
        jcampo.setBackground(Color.GREEN);
        jcampo.setBounds(campoX, campoY, campo.getWidth(), campo.getHeight() - (frame.getHeight() / 9));
 
        int[][] tileset = new int[campo.getLinhas()][campo.getColunas()];

        ArrayList<Peca> arPecas = new ArrayList<>();

        int h = 0;

        for (int i = 0; i < campo.getLinhas(); i++) {
            for (int j = 0; j < campo.getColunas(); j++) {
                if (((j + (i * (campo.getColunas()+1))) % 2 != 0)) {
                    if(i<2){
                    arPecas.add(h++, new Peca(i, j, 2, spriteSheet, frame, campo));
                    }
                    if(i>5){
                        arPecas.add(h++, new Peca(i, j, 3, spriteSheet, frame, campo));
                    }
                }
            }
        }

        frame.getContentPane().add(fundo);
        Campo.CriarCampo(tileset, spriteSheet, jcampo, campo, frame, arPecas);
        frame.setVisible(true);

        new Turno(campo, arPecas, tileset, spriteSheet, jcampo, fundo, frame);
    }
}
