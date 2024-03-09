package com.example.cognicare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class GameTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);

        final AppCompatButton singlePlayerBtn = findViewById(R.id.singlePlayerBtn);
        final AppCompatButton multiplayerBtn = findViewById(R.id.multiPlayerBtn);
        final AppCompatButton localModeBtn = findViewById(R.id.localModeBtn);
        final AppCompatButton exitBtn = findViewById(R.id.exitTTCGameBtn);

        singlePlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameTypeActivity.this, SingleMode.class));
            }
        });

        multiplayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameTypeActivity.this, PlayerName.class));
            }
        });

        localModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameTypeActivity.this, LocalMode.class));
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameTypeActivity.this, BrainGamesActivity.class));
            }
        });
    }
}