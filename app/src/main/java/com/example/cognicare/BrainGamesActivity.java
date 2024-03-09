package com.example.cognicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BrainGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_games);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Brain Stimulation Games");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout tictactoe = findViewById(R.id.tictactoe);
        LinearLayout tetris = findViewById(R.id.tetris);

        tictactoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BrainGamesActivity.this, GameTypeActivity.class);
                startActivity(intent);
            }
        });

        tetris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BrainGamesActivity.this, TetrisLauncher.class);
                startActivity(intent);
            }
        });
    }
}