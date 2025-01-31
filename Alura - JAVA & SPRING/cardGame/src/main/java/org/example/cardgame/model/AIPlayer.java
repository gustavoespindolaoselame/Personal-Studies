package org.example.cardgame.model;

import org.example.cardgame.events.MainTurn;

public class AIPlayer extends Player{
    public AIPlayer(MainTurn mainTurn, int playerId) {
        super();
        startGameDraw7Cards();
        this.setMainTurn(mainTurn);
        this.setPlayerId(playerId);
    }
}