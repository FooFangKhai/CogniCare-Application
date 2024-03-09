package com.example.cognicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerNameGoogle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name_google);

        final EditText playerNameEt = findViewById(R.id.playerName);
        final AppCompatButton startGameBtn = findViewById(R.id.startGameBtn);
        final AppCompatButton endGameBtn = findViewById(R.id.exitGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getPlayerName = playerNameEt.getText().toString();

                if(getPlayerName.isEmpty()) {
                    Toast.makeText(PlayerNameGoogle.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(PlayerNameGoogle.this, TicTacToeActivityGoogle.class);
                    intent.putExtra("playerName", getPlayerName);
                    startActivity(intent);
                    finish();
                }
            }
        });

        endGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}