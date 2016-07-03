package com.example.nathan.fastforwolf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class StartMenuActivity extends AppCompatActivity {

    String inputGameId;
    Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        Button createGameButton = (Button) findViewById(R.id.CreateGameButton);
        Button joinGameButton = (Button) findViewById(R.id.JoinGameButton);
        currentPlayer = new Player();

        /**
         * Setup Firebase
         */
        Firebase.setAndroidContext(this);
        Database.db = new Firebase("https://fastforwolf-1d209.firebaseio.com/");

        createGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateGameActivity.class));
            }
        });

        /**
         * Database ID Input Dialogue
         */
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Database ID");
        // Set up the input
        final EditText input = new EditText(this);
        input.setFilters(new InputFilter[] {new InputFilter.LengthFilter(WerewolfConstants.GAME_ID_MAX_LENGTH)});
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                inputGameId = input.getText().toString();
                if (Database.isActiveGame(inputGameId)) {
                    Database.addPlayer(currentPlayer, inputGameId);
                }
            }

        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.show();
            }
        });



    }
}
