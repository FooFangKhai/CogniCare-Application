package com.example.cognicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SingleModeGoogle extends AppCompatActivity {
    private static final int[] computerTurns = {1, 3, 2, 9, 5, 7, 4, 6, 8};
    private static final int[] computerTurns2 = {3, 7, 5, 1, 4, 9, 2, 6, 8};
    private static final int[] computerTurns3 = {1, 5, 9, 7, 5, 3, 2, 4, 6};
    private static final int[] computerTurns4 = {1, 7, 4, 3, 5, 9, 8, 6, 2};

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
    private int[] data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_google);

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

        Random random = new Random();
        int position = random.nextInt(4);

        if (position == 0) {
            data = computerTurns;
        } else if (position == 1) {
            data = computerTurns2;
        } else if (position == 2) {
            data = computerTurns3;
        } else {
            data = computerTurns4;
        }

        Log.e("klajsfkljafssaf", "asd" + Arrays.toString(data));

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
        player2TV.setText("Computer");

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("1")) {
                    selectBox(image1, 1, playerTurn);
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("2")) {
                    selectBox(image2, 2, playerTurn);
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("3")) {
                    selectBox(image3, 3, playerTurn);
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("4")) {
                    selectBox(image4, 4, playerTurn);
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("5")) {
                    selectBox(image5, 5, playerTurn);
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("6")) {
                    selectBox(image6, 6, playerTurn);
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("7")) {
                    selectBox(image7, 7, playerTurn);
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("8")) {
                    selectBox(image8, 8, playerTurn);
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerTurn == 1 && !doneBoxes.contains("9")) {
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

            if (doneBoxes.size() < 9) {
                performComputer();
            }
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

        // checking whether player has won the match
        if (checkPlayerWin(playerTurn)) {
            final WinDialogGoogle winDialogGoogle;

            if (playerTurn == 1) {

                // show win dialog
                winDialogGoogle = new WinDialogGoogle(SingleModeGoogle.this, "You won the game");
            } else {

                // show win dialog
                winDialogGoogle = new WinDialogGoogle(SingleModeGoogle.this, "Computer won the game");
            }

            winDialogGoogle.setCancelable(false);
            winDialogGoogle.show();
        } else {
            applyPlayerTurn();
        }

        // over the game if there is no box left to be selected
        if (doneBoxes.size() == 9) {

            final WinDialogGoogle winDialogGoogle = new WinDialogGoogle(SingleModeGoogle.this, "It is a Draw!");
            winDialogGoogle.setCancelable(false);
            winDialogGoogle.show();
        }
    }

    private void performComputer() {

        int[] combination = new int[0];
        int selectedToWin = 0;

        // check winning combination of computer
        for (int i = 0; i < combinationsList.size(); i++) {

            combination = combinationsList.get(i);

            selectedToWin = 0;


            if (boxesSelectedBy[combination[0]].equals(String.valueOf(2))) {
                if (!boxesSelectedBy[combination[1]].equals(String.valueOf(1)) && !boxesSelectedBy[combination[2]].equals(String.valueOf(1))) {
                    selectedToWin++;
                }
            }
            if (boxesSelectedBy[combination[1]].equals(String.valueOf(2))) {
                if (!boxesSelectedBy[combination[0]].equals(String.valueOf(1)) && !boxesSelectedBy[combination[2]].equals(String.valueOf(1))) {
                    selectedToWin++;
                }
            }
            if (boxesSelectedBy[combination[2]].equals(String.valueOf(2))) {
                if (!boxesSelectedBy[combination[1]].equals(String.valueOf(1)) && !boxesSelectedBy[combination[0]].equals(String.valueOf(1))) {
                    selectedToWin++;
                }
            }

            if (selectedToWin == 2) {
                break;
            }
        }

        if(selectedToWin != 2){

            // prevent opponent from winning
            for (int i = 0; i < combinationsList.size(); i++) {

                combination = combinationsList.get(i);

                selectedToWin = 0;

                if (boxesSelectedBy[combination[0]].equals(String.valueOf(1))) {
                    if (!boxesSelectedBy[combination[1]].equals(String.valueOf(2)) && !boxesSelectedBy[combination[2]].equals(String.valueOf(2))) {
                        selectedToWin++;
                    }
                }
                if (boxesSelectedBy[combination[1]].equals(String.valueOf(1))) {
                    if (!boxesSelectedBy[combination[0]].equals(String.valueOf(2)) && !boxesSelectedBy[combination[2]].equals(String.valueOf(2))) {
                        selectedToWin++;
                    }
                }
                if (boxesSelectedBy[combination[2]].equals(String.valueOf(1))) {
                    if (!boxesSelectedBy[combination[1]].equals(String.valueOf(2)) && !boxesSelectedBy[combination[0]].equals(String.valueOf(2))) {
                        selectedToWin++;
                    }
                }

                if (selectedToWin == 2) {
                    break;
                }
            }
        }

        if (selectedToWin != 2) {

            for (int l = 1; l <= data.length; l++) {
                if (!doneBoxes.contains(String.valueOf(data[l]))) {
                    selectBoxOfComputer(data[l]);
                    break;
                }
            }
        } else {

            for (int i : combination) {
                if (!doneBoxes.contains(String.valueOf(i + 1))) {
                    selectBoxOfComputer(i + 1);
                    break;
                }
            }
        }
    }

    private void selectBoxOfComputer(int l) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (l == 1) {
                    selectBox(image1, l, 2);
                } else if (l == 2) {
                    selectBox(image2, l, 2);
                } else if (l == 3) {
                    selectBox(image3, l, 2);
                } else if (l == 4) {
                    selectBox(image4, l, 2);
                } else if (l == 5) {
                    selectBox(image5, l, 2);
                } else if (l == 6) {
                    selectBox(image6, l, 2);
                } else if (l == 7) {
                    selectBox(image7, l, 2);
                } else if (l == 8) {
                    selectBox(image8, l, 2);
                } else {
                    selectBox(image9, l, 2);
                }
            }
        }, 2000);
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