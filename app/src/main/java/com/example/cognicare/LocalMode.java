package com.example.cognicare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LocalMode extends AppCompatActivity {
    // winning combinations
    private final List<int[]> combinationsList = new ArrayList<>();
    // done boxes positions by users so users won't select the box again
    private final List<String> doneBoxes = new ArrayList<>();
    // selected boxes by players. empty fields will be replaced by player ids
    private final String[] boxesSelectedBy = {"", "", "", "", "", "", "", "", ""};
    // layouts
    private LinearLayout player1Layout, player2Layout;
    // ImageViews consist of cross and zero icon
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    private int playerTurn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        // getting Layouts, TextViews, ImageViews from xml layout file to perform actions on them
        player1Layout = findViewById(R.id.player1Layout);
        player2Layout = findViewById(R.id.player2Layout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        // player names TextViews
        final TextView player1TV = findViewById(R.id.player1TV);
        final TextView player2TV = findViewById(R.id.player2TV);

        // generating winning combinations
        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{2, 4, 6});
        combinationsList.add(new int[]{0, 4, 8});

        // setting player name to the TextView
        player1TV.setText(MyConstents.playerName);
        player2TV.setText("Opponent");

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("1")){
                    selectBox(image1, 1, playerTurn);
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("2")){
                    selectBox(image2, 2, playerTurn);
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("3")){
                    selectBox(image3, 3, playerTurn);
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("4")){
                    selectBox(image4, 4, playerTurn);
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("5")){
                    selectBox(image5, 5, playerTurn);
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("6")){
                    selectBox(image6, 6, playerTurn);
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("7")){
                    selectBox(image7, 7, playerTurn);
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("8")){
                    selectBox(image8, 8, playerTurn);
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!doneBoxes.contains("9")){
                    selectBox(image9, 9, playerTurn);
                }
            }
        });

    }

    private void applyPlayerTurn() {

        if (playerTurn == 1) {
            player1Layout.setBackgroundResource(R.drawable.round_black_dark_blue_stroke);
            player2Layout.setBackgroundResource(R.drawable.round_black_dark_blue_20);
        } else {
            player2Layout.setBackgroundResource(R.drawable.round_black_dark_blue_stroke);
            player1Layout.setBackgroundResource(R.drawable.round_black_dark_blue_20);
        }
    }

    private void selectBox(ImageView imageView, int selectedBoxPosition, int playerTurn) {

        boxesSelectedBy[selectedBoxPosition - 1] = String.valueOf(playerTurn);
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.cross_icon);
            this.playerTurn = 0;
        } else {
            imageView.setImageResource(R.drawable.zero_icon);
            this.playerTurn = 1;
        }

        doneBoxes.add(String.valueOf(selectedBoxPosition));

        applyPlayerTurn();

        // checking whether player has won the match
        if (checkPlayerWin(playerTurn)) {
            final WinDialog winDialog;

            if (playerTurn == 1) {

                // show win dialog
                winDialog = new WinDialog(LocalMode.this, "You won the game");
            } else {

                // show win dialog
                winDialog = new WinDialog(LocalMode.this, "Opponent won the game");
            }

            winDialog.setCancelable(false);
            winDialog.show();
        }

        // over the game if there is no box left to be selected
        if (doneBoxes.size() == 9) {

            final WinDialog winDialog = new WinDialog(LocalMode.this, "It is a Draw!");
            winDialog.setCancelable(false);
            winDialog.show();
        }
    }

    private boolean checkPlayerWin(int playerTurn) {

        boolean isPlayerWon = false;

        // compare player turns with every wining combination
        for (int i = 0; i < combinationsList.size(); i++) {

            final int[] combination = combinationsList.get(i);

            // checking last three turn of user
            if (boxesSelectedBy[combination[0]].equals(String.valueOf(playerTurn)) &&
                    boxesSelectedBy[combination[1]].equals(String.valueOf(playerTurn)) &&
                    boxesSelectedBy[combination[2]].equals(String.valueOf(playerTurn))) {
                isPlayerWon = true;
            }
        }

        return isPlayerWon;
    }
}