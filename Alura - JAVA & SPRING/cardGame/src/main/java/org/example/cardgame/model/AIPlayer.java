package org.example.cardgame.model;

import org.example.cardgame.events.MainTurn;
import org.example.cardgame.events.playObserver;

import java.util.List;

public class AIPlayer extends Player{
    public AIPlayer(MainTurn mainTurn, int playerId) {
        this.startGameDraw7Cards();
        this.setMainTurn(mainTurn);
        this.setPlayerId(playerId);
    }
    @Override
    public void drawCard(){
    }
    @Override
    public void startGameDraw7Cards(){
    }
    @Override
    public void setCards(List<Card> cards) {
    }
    @Override
    public void setNumCardsInDeck(int numCardsInDeck) {
    }
    @Override
    public void setOwnsThisTurn(boolean ownsThisTurn) {
    }
    @Override
    public void endTurnOrPlayCard(){
    }
    @Override
    public void playCard(){
    }
    @Override
    public void cardsInFieldToString(){
    }
    @Override
    public void choicesToString(){
    }
    @Override
    public void cardsInHandToString(){
    }
}