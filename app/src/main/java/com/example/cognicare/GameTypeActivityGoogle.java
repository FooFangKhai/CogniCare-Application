package com.example.cognicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameTypeActivityGoogle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type_google);

        final AppCompatButton singlePlayerBtn = findViewById(R.id.singlePlayerBtn);
        final AppCompatButton multiplayerBtn = findViewById(R.id.multiPlayerBtn);
        final AppCompatButton localModeBtn = findViewById(R.id.localModeBtn);
        final AppCompatButton exitBtn = findViewById(R.id.exitTTCGameBtn);

        singlePlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameTypeActivityGoogle.this, SingleModeGoogle.class));
            }
        });

        multiplayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameTypeActivityGoogle.this, PlayerNameGoogle.class));
            }
        });

        localModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameTypeActivityGoogle.this, LocalModeGoogle.class));
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameTypeActivityGoogle.this, BrainGamesActivityGoogle.class));
            }
        });
    }
}