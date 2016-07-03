package com.example.nathan.fastforwolf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Nathan on 7/1/2016.
 */
public class CreateGameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        Database.createGame(generateGameId());
        Button nextButton = (Button) findViewById(R.id.NextButton);
        TextView gameIdText = (TextView) findViewById(R.id.GameIdText);

        gameIdText.setText(Database.gameId);
    }

    public static String generateGameId() {
        StringBuilder sb = new StringBuilder(WerewolfConstants.GAME_ID_MAX_LENGTH);
        Random rnd = new Random();
        final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < WerewolfConstants.GAME_ID_MAX_LENGTH; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
