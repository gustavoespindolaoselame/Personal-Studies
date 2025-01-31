package org.example.cardgame.events;

import org.example.cardgame.model.AIPlayer;
import org.example.cardgame.model.Card;
import org.example.cardgame.model.Field;
import org.example.cardgame.model.Player;

public class MainTurn {
    private Player[] players;
    private Field field;
    private Boolean gameOn;

    public MainTurn(){
        gameOn = true;
        field = new Field(new Card());
        players = new Player[]{new Player(this, 0), new AIPlayer(this, 1)};
        while(gameOn) {
            players[0].endTurnOrPlayCard();
        }
    }

    public void endGame(){
        this.gameOn=false;
        throw new RuntimeException("Game Ended");
    }

    public void flipTurns(){
        if(players[0].isOwnsThisTurn()){
            players[0].setOwnsThisTurn(false);
            players[1].setOwnsThisTurn(true);
        } else {
            players[1].setOwnsThisTurn(false);
            players[0].setOwnsThisTurn(true);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
