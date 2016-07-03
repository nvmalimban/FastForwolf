package com.example.nathan.fastforwolf;

/**
 * Created by Nathan on 7/1/2016.
 */
public class Player {
    String playerId;

    public Player() {
        this.playerId = generatePlayerId();
    }

    public String generatePlayerId() {
        return CreateGameActivity.generateGameId();
    }
}
