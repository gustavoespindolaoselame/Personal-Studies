package damas;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Turno {
    private Peca peca;
    private int turn = 0;

    public Turno(Campo campo, ArrayList<Peca> arPecas, int[][] tileset, BufferedImage spriteSheet, JPanel jcampo,
            JPanel fundo, JFrame frame) {
        this.peca = campo.peca;
        while (true) {
            System.err.println(campo.click1);
            System.err.println(campo.click2);
            if (campo.click1 && campo.click2) {
                System.err.println("aaa");
                if ((campo.click2x == peca.getPosX() + 1
                        &&
                        campo.click2y == peca.getPosY() + 1) ||
                        (campo.click2x == peca.getPosX() - 1
                                &&
                                campo.click2y == peca.getPosY() - 1)
                        ||
                        (campo.click2x == peca.getPosX() + 1
                                &&
                                campo.click2y == peca.getPosY() - 1)
                        ||
                        (campo.click2x == peca.getPosX() - 1
                                &&
                                campo.click2y == peca.getPosY() + 1)) {
                    System.err.println("bbb");
                    peca.setPosX(campo.click2x, tileset);
                    peca.setPosY(campo.click2y, tileset);
                }
                if (campo.click2x == peca.getPosX() + 2
                        &&
                        campo.click2y == peca.getPosY() + 2) {
                    for (Peca targetPeca : arPecas) {
                        if (targetPeca.getPosX() == peca.getPosX() + 1
                                && targetPeca.getPosY() == peca.getPosY() + 1) {
                            targetPeca.setAlive(false);

                            peca.setPosX(campo.click2x, tileset);
                            peca.setPosY(campo.click2y, tileset);
                            targetPeca.Render(campo, spriteSheet, frame);
                            System.err.println("ccc");
                            break;
                        }
                    }
                }
                if ((campo.click2x == peca.getPosX() + 2
                        &&
                        campo.click2y == peca.getPosY() - 2)) {
                    for (Peca targetPeca : arPecas) {
                        if (targetPeca.getPosX() == peca.getPosX() + 1
                                && targetPeca.getPosY() == peca.getPosY() - 1) {
                            targetPeca.setAlive(false);

                            peca.setPosX(campo.click2x, tileset);
                            peca.setPosY(campo.click2y, tileset);
                            targetPeca.Render(campo, spriteSheet, frame);
                            break;
                        }
                    }
                }
                if (campo.click2x == peca.getPosX() - 2
                        &&
                        campo.click2y == peca.getPosY() + 2) {
                    for (Peca targetPeca : arPecas) {
                        if (targetPeca.getPosX() == peca.getPosX() - 1
                                && targetPeca.getPosY() == peca.getPosY() + 1) {
                            targetPeca.setAlive(false);

                            peca.setPosX(campo.click2x, tileset);
                            peca.setPosY(campo.click2y, tileset);
                            targetPeca.Render(campo, spriteSheet, frame);
                            break;
                        }
                    }
                }
                if (campo.click2x == peca.getPosX() - 2
                        &&
                        campo.click2y == peca.getPosY() - 2) {
                    for (Peca targetPeca : arPecas) {
                        if (targetPeca.getPosX() == peca.getPosX() - 1
                                && targetPeca.getPosY() == peca.getPosY() - 1) {
                            targetPeca.setAlive(false);

                            peca.setPosX(campo.click2x, tileset);
                            peca.setPosY(campo.click2y, tileset);
                            targetPeca.Render(campo, spriteSheet, frame);
                            break;
                        }
                    }
                    jcampo.removeAll();
                    peca.Render(campo, spriteSheet, frame);
                    Campo.CriarCampo(tileset, spriteSheet, jcampo, campo, frame, arPecas);
                    frame.setVisible(true);
                    campo.click1 = false;
                    campo.click2 = false;
                }
            }
        }
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

}