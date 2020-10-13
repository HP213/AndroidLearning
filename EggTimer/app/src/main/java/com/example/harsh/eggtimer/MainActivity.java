package com.example.harsh.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView textView;
    Boolean counterIsActive = false;
    Button goButton;
    CountDownTimer countDownTimer;
    int currProgress = 30;


    public void update(){
        int mins = currProgress/60;
        int secs = currProgress%60;


        String secsTostring = Integer.toString(secs);
        if(secsTostring.length() == 1){
            secsTostring = '0' + secsTostring;
        }

        textView.setText(Integer.toString(mins) + ":" + secsTostring);
    }

    public void buttonClicked(View view){

        if(counterIsActive){

            int mins = currProgress/60;
            int secs = currProgress%60;


            String secsTostring = Integer.toString(secs);
            if(secsTostring.length() == 1){
                secsTostring = '0' + secsTostring;
            }

            textView.setText(Integer.toString(mins) + ":" + secsTostring);

//            textView.setText("00:30");
            timerSeekBar.setProgress(currProgress);
            counterIsActive = false;
            timerSeekBar.setEnabled(true);
            countDownTimer.cancel();
            goButton.setText("GO");

        }else {
            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            goButton.setText("STOP!");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                public void onTick(long l) {
                    if(currProgress > 0) {
                        currProgress = currProgress - 1;
                        update();
                    }
                }

                public void onFinish() {
                    Log.i("Finished", "Done");
                    MediaPlayer mpPlayer = MediaPlayer.create(getApplicationContext(), R.raw.horn);
                    mpPlayer.start();
                    counterIsActive = false;
                    timerSeekBar.setEnabled(true);
                    goButton.setText("GO");
                }
            }.start();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timeSeekBar);
        textView = findViewById(R.id.timeView);
        goButton = findViewById(R.id.timeStart);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currProgress = progress;
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
