package com.example.nathan.fastforwolf;

import com.firebase.client.Firebase;

/**
 * Created by Nathan on 7/1/2016.
 */
public class Database {
    public static String gameId;
    public static Firebase db;

    public static void createGame(String gameId) {
        Database.gameId = gameId;
    }

    public static void addPlayer(Player p, String gameId) {
        db.child("message").setValue(p.playerId);
    }

    public static boolean isActiveGame(String gameId) {
        return true;
    }

}
