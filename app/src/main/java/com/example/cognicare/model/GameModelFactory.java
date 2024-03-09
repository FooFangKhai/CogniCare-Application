package com.example.cognicare.model;

import com.example.cognicare.presenters.GameModel;

public class GameModelFactory {

    private GameModelFactory() {

    }

    public static GameModel newGameModel(GameType type) {
        switch (type) {
            case TETRIS:
                return new TetrisGameModel();
            default:
                return null;
        }
    }
}
