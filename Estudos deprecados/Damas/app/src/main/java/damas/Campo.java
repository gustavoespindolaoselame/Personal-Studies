package damas;

import java.awt.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.event.*;

public class Campo {
    private int linhas = 0;
    private int colunas = 0;
    private int width = 500;
    private int height = 500;
    public Peca peca;
    public Boolean click1 = false;
    public Boolean click2 = false;
    public int click2x = 0;
    public int click2y = 0;

    public static void CriarTileSet(int tileset[][], Campo campo, ArrayList<Peca> arPecas) {
        for (int i = 0; i < campo.getLinhas(); i++) {
            for (int j = 0; j < campo.getColunas(); j++) {
                boolean cont = true;
                for (int m = 0; m < arPecas.size(); m++) {
                    if (arPecas.get(m).isAlive()&&(arPecas.get(m).getPosX() == i && arPecas.get(m).getPosY() == j)) {
                        tileset[i][j] = arPecas.get(m).getId();
                        cont = false;
                    }
                }
                if (cont == true) {
                    if (i % 2 == 0 && campo.getColunas() % 2 == 0) { // se o número de colunas é par ao trocar de linha
                        if ((j + (i * campo.getColunas())) % 2 == 0) { // se o valor atual é par
                            tileset[i][j] = 1;
                        } else {
                            tileset[i][j] = 0;
                        }
                    } else {
                        if ((j + (i * campo.getColunas())) % 2 == 0) {// se o valor atual é par
                            tileset[i][j] = 0;
                        } else {
                            tileset[i][j] = 1;
                        }
                    }
                }
            }
        }
    }

    public static void CriarCampo(int tileset[][], BufferedImage spriteSheet, JPanel jcampo, Campo campo,
            JFrame frame,
            ArrayList<Peca> arPecas) {
                Campo.CriarTileSet(tileset, campo, arPecas);
        for (int i = 0; i < campo.getLinhas(); i++) {
            for (int j = 0; j < campo.getColunas(); j++) {
                boolean cont = true;

                    for (int m = 0; m < arPecas.size(); m++) {
                        if (arPecas.get(m).isAlive()&&(arPecas.get(m).getPosX() == i && arPecas.get(m).getPosY() == j)) {
                            placePeca(campo, jcampo, m, frame, arPecas);
                            cont = false;
                        }
                    }
                
                if (cont == true) {
                    placeTile(spriteSheet, jcampo, campo, tileset[i][j], i, j, frame);
                }
            }
        }
        frame.add(jcampo);
    }

    public static void placePeca(Campo campo, JPanel jcampo, int textureid, JFrame frame,
            ArrayList<Peca> arPecas) {
        ImageIcon icon = new ImageIcon(arPecas.get(textureid).getSprite());
        JButton botao = new JButton(icon);
        //botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        //botao.setFocusPainted(false);
        botao.setMargin(new Insets(0, 0, 0, 0));
        botao.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campo.click1 = true;
                campo.peca = arPecas.get(textureid);
                
                //System.out.print("campo.peca.getPosX()"+ campo.peca.getPosX());
                //System.out.println("campo.peca.getPosY()"+ campo.peca.getPosY());
            }
        });
        jcampo.add(botao);
    }

    public static void placeTile(BufferedImage spriteSheet, JPanel jcampo, Campo campo,
            int textureid, int posX, int posY, JFrame frame) {
        BufferedImage subImage = spriteSheet.getSubimage(textureid * 16, 0, 16, 16);
        Image sprite = subImage.getScaledInstance(frame.getWidth() / campo.getColunas(),
                frame.getHeight() / campo.getLinhas(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(sprite);
        JButton botao = new JButton(icon);
        //botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        //botao.setFocusPainted(false);
        botao.setMargin(new Insets(0, 0, 0, 0));
        botao.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campo.click2 = true;
                campo.click2x = posX;
                campo.click2y = posY;
                //System.out.print("campo.click2x;"+ campo.click2x);
                //System.out.println("campo.click2y;"+ campo.click2y);
            }
        });
        jcampo.add(botao);

    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Campo(int linhas, int colunas, int width, int height) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.width = width;
        this.height = height;
    }
}
