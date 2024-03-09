package com.example.cognicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cognicare.model.GameModelFactory;
import com.example.cognicare.model.GameType;
import com.example.cognicare.presenters.GamePresenter;
import com.example.cognicare.presenters.GameTurn;
import com.example.cognicare.views.GameFrame;
import com.example.cognicare.views.GameViewFactory;

public class Tetris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);

        GameFrame gameFrame = findViewById(R.id.game_container);
        TextView gameScoreText = findViewById(R.id.game_score);
        TextView gameStatusText = findViewById(R.id.game_status);
        Button gameCtlBtn = findViewById(R.id.game_ctl_btn);
        Button exitBtn = findViewById(R.id.game_exit_btn);

        GamePresenter gamePresenter = new GamePresenter();
        gamePresenter.setGameModel(GameModelFactory.newGameModel(GameType.TETRIS));
        gamePresenter.setGameView(GameViewFactory.newGameView(gameFrame, gameScoreText, gameStatusText, gameCtlBtn));

        Button upBtn = findViewById(R.id.up_btn);
        Button downBtn = findViewById(R.id.down_btn);
        Button leftBtn = findViewById(R.id.left_btn);
        Button rightBtn = findViewById(R.id.right_btn);
        Button fireBtn = findViewById(R.id.fire_btn);

        upBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.UP));
        downBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.DOWN));
        leftBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.LEFT));
        rightBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.RIGHT));
        fireBtn.setOnClickListener(v -> gamePresenter.turn(GameTurn.FIRE));

        gameCtlBtn.setOnClickListener(v -> gamePresenter.changeStatus());

        gamePresenter.init();

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tetris.this, TetrisLauncher.class);
                startActivity(intent);
            }
        });
    }
}