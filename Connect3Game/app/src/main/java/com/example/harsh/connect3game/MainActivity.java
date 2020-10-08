package com.example.harsh.connect3game;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    //0 : yellow, 1 : red;

    //2 : inital no state;

    int[] gameStates = {2,2,2,2,2,2,2,2,2};

    int[][] winningState = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0, 4,8}, {2,4,6}};

    boolean activeGame = true;

    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameStates[tappedCounter] != 2 || !activeGame){
            return;
        }

        counter.setTranslationY(-1500);

        gameStates[tappedCounter] = activePlayer;

        if(activePlayer == 0){
            activePlayer = 1;
            counter.setImageResource(R.drawable.yellow);
        }else{
            activePlayer = 0;
            counter.setImageResource(R.drawable.red);
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(500);

        for(int[] winningPos : winningState){
            if(gameStates[winningPos[0]] == gameStates[winningPos[1]] && gameStates[winningPos[1]] == gameStates[winningPos[2]] && gameStates[winningPos[1]] != 2){
                Button playAgainButton = (Button) findViewById(R.id.button);

                String message;

                if(activePlayer == 0){
                    message = "Red Won!";
//                    Toast.makeText(this, "Winner :  Red", Toast.LENGTH_SHORT).show();
                }else{
                    message = "Yellow Won!";
//                    Toast.makeText(this, "Winner :  Yellow", Toast.LENGTH_SHORT).show();
                }

                message = message + " Play Again!";

                playAgainButton.setText(message);

                activeGame = false;
            }
        }
    }

    public void playAgain(View view){
        Button playAgainButton = (Button) findViewById(R.id.button);

        playAgainButton.setText("Play Again");

        GridLayout grids = (GridLayout) findViewById(R.id.gridLayout);

        for(int i = 0; i < grids.getChildCount(); i++){
            ImageView counter = (ImageView) grids.getChildAt(i);

            counter.setImageDrawable(null);
        }

        for(int i = 0; i < gameStates.length; i++){
            gameStates[i] = 2;
        }

        activePlayer = 0;

        activeGame = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
