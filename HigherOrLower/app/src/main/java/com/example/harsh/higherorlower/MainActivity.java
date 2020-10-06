package com.example.harsh.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandom(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void makeGuess(View view){

        EditText editText = (EditText) findViewById(R.id.editText2);

        int guessValue = Integer.parseInt(editText.getText().toString());

        String message;

        if(guessValue > randomNumber){
            message = "Lower!";
        }else if(guessValue < randomNumber){
            message = "Higher!";
        }else{
            message = "You Got it Right!";
            generateRandom();
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandom();
    }
}
