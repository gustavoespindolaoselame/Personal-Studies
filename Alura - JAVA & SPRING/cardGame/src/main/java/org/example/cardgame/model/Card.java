package org.example.cardgame.model;

import java.util.Random;

public class Card {
    private int cardValue;
    private String cardName;

    public Card(int cardValue){
        this.cardValue = cardValue;
        switch (this.cardValue){
            case 1:
                this.cardName = "A";
                break;
            case 11:
                this.cardName = "J";
                break;
            case 12:
                this.cardName = "Q";
                break;
            case 13:
                this.cardName = "K";
                break;
            default:
                this.cardName = String.valueOf(this.cardValue);
        }
    }

    public Card() {
        Random random = new Random();
        this.cardValue = random.nextInt(13) + 1;
        switch (this.cardValue){
            case 1:
                this.cardName = "A";
                break;
            case 11:
                this.cardName = "J";
                break;
            case 12:
                this.cardName = "Q";
                break;
            case 13:
                this.cardName = "K";
                break;
            default:
                this.cardName = String.valueOf(this.cardValue);
        }
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
