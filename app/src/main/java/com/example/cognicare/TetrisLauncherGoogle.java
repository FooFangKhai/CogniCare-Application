package com.example.cognicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TetrisLauncherGoogle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris_launcher_google);

        final AppCompatButton startGame = findViewById(R.id.startGameBtnTetris);
        final AppCompatButton exitGame = findViewById(R.id.exitGameBtnTetris);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TetrisLauncherGoogle.this, TetrisGoogle.class);
                startActivity(intent);
            }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TetrisLauncherGoogle.this, BrainGamesActivityGoogle.class);
                startActivity(intent);
            }
        });
    }
}