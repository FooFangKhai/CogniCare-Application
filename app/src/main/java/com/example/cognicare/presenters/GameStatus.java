package com.example.cognicare.presenters;

public enum GameStatus {
    START("START"),
    PLAYING("PLAYING"),
    OVER("GAME OVER"),
    PAUSED("PAUSED");

    private final String mValue;

    GameStatus(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
