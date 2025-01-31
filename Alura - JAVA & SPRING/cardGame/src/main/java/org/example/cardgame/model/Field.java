package org.example.cardgame.model;

public class Field {
    private Card cardInField;

    public Field(Card cardInField) {
        this.cardInField = cardInField;
    }

    public Card getCardInField() {
        return cardInField;
    }

    public void setCardInField(Card cardInField) {
        this.cardInField = cardInField;
    }
}
