package damas;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Peca {
    private int posX = 0;
    private int posY = 0;
    private int id;
    private boolean alive = true;
    private Image sprite;
    private BufferedImage subImage;

    public Peca(int posX, int posY, int id, BufferedImage spriteSheet, JFrame frame, Campo campo) {
        this();
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        this.subImage = spriteSheet.getSubimage(((this.id) % 4) * 16, 0, frame.getSize().width / 120,
                frame.getSize().height / 67);
        this.sprite = subImage.getScaledInstance(frame.getWidth() / campo.getColunas(),
                frame.getHeight() / campo.getLinhas(), Image.SCALE_DEFAULT);
    }

    public void Render(Campo campo, BufferedImage spriteSheet, JFrame frame) {
            this.subImage = spriteSheet.getSubimage(((this.id) % 4) * 16, 0, frame.getSize().width / 120,
                    frame.getSize().height / 67);
            this.sprite = subImage.getScaledInstance(frame.getWidth() / campo.getColunas(),
                    frame.getHeight() / campo.getLinhas(), Image.SCALE_DEFAULT);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX, int tileset[][]) {
        tileset[this.posX][this.posY] = 0;
        this.posX = posX;
        tileset[posX][this.posY] = this.id;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY, int tileset[][]) {
        tileset[this.posX][this.posY] = 0;
        this.posY = posY;
        tileset[this.posX][posY] = this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public Peca() {
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
