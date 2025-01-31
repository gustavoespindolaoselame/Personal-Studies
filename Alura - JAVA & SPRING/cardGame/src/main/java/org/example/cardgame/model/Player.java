package org.example.cardgame.model;

import org.example.cardgame.events.MainTurn;
import org.example.cardgame.events.playObserver;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerId;
    private List<Card> cards = new ArrayList();
    private int numCardsInDeck;
    private boolean ownsThisTurn;
    private boolean hasWon;
    private MainTurn mainTurn;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public MainTurn getMainTurn() {
        return mainTurn;
    }

    public void setMainTurn(MainTurn mainTurn) {
        this.mainTurn = mainTurn;
    }

    public void drawCard(){
        this.cards.add(new Card());
        this.numCardsInDeck -= 1;
    }

    public void startGameDraw7Cards(){
        for(int i=0;i<7;i++){
            this.drawCard();
        }
    }

    public Player(){
        startGameDraw7Cards();
    }

    public Player(MainTurn mainTurn, int playerId) {
        super();
        startGameDraw7Cards();
        this.mainTurn = mainTurn;
        this.playerId = playerId;
    }

    public Player(List<Card> cards, int numCardsInDeck, boolean isPlayable, boolean hasWon) {
        super();
        startGameDraw7Cards();
        this.cards = cards;
        this.numCardsInDeck = numCardsInDeck;
        this.ownsThisTurn = isPlayable;
        this.hasWon = hasWon;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getNumCardsInDeck() {
        return numCardsInDeck;
    }

    public void setNumCardsInDeck(int numCardsInDeck) {
        this.numCardsInDeck = numCardsInDeck;
    }

    public boolean isOwnsThisTurn() {
        return ownsThisTurn;
    }

    public void setOwnsThisTurn(boolean ownsThisTurn) {
        this.ownsThisTurn = ownsThisTurn;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public void endTurn(){
        this.ownsThisTurn = false;
    }

    public void endTurnOrPlayCard(){
        choicesToString();
        cardsInFieldToString();
        String choice = playObserver.playObserverGetInstance().getScanner().next();
        switch (choice){
            case "1": this.playCard(); break;
            case "2": this.endTurn(); break;
            case "3": mainTurn.endGame(); break;
            default:
                choice = playObserver.playObserverGetInstance().getScanner().next();
        }
    }


    public void playCard(){
        cardsInHandToString();
        cardsInFieldToString();
        boolean control=true;
        while(control) {
            int chosenCard = playObserver.playObserverGetInstance().getScanner().nextInt() - 1;
            for (int i = 0; i < cards.size(); i++) {
                if (chosenCard == i && isCardPlayable(cards.get(i))) {
                    mainTurn.getField().
                            setCardInField(
                                    cards.get(chosenCard));
                    cards.remove(i);
                    drawCard();
                    control=false;
                    break;
                }
                if (chosenCard == i && !isCardPlayable(cards.get(i))) {
                    mainTurn.getField().
                            setCardInField(
                                    cards.get(chosenCard));
                    cards.remove(i);
                    if(this.playerId==0){
                        mainTurn.getPlayers()[1].drawCard();
                    } else {
                        mainTurn.getPlayers()[0].drawCard();
                    }
                    control=false;
                    break;
                }
            }
        }
    }

    public boolean isCardPlayable(Card cardInQuestion) {
        Card fieldCard = mainTurn.getField().getCardInField();
        return cardInQuestion.getCardValue() == fieldCard.getCardValue() ||
                cardInQuestion.getCardValue() == fieldCard.getCardValue() + 1 ||
                cardInQuestion.getCardValue() == fieldCard.getCardValue() - 1 ||
                (cardInQuestion.getCardValue() == 12 && fieldCard.getCardValue() == 1) ||
                (cardInQuestion.getCardValue() == 1 && fieldCard.getCardValue() == 12);
    }

    public void cardsInFieldToString(){
        System.out.print("Card in field: " + mainTurn.getField().getCardInField().getCardName() + "\n");
    }

    public void choicesToString(){
        System.out.println("Do you want to:\n(1) - Play\n(2) - End Turn\n(3) - Quit");
    }

    public void cardsInHandToString(){
        System.out.println("Cards in hand: ");
        for(int i = 0; i<cards.size(); i++){
            System.out.println("(" + (i+1) + ") - " + cards.get(i).getCardName());
        }
    }
}
