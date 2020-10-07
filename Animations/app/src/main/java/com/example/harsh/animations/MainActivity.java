package com.example.harsh.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean bart1Show = true;

    public void fade(View view){
        Log.i("Info", "Image clicked");

        ImageView bart1Image = (ImageView) findViewById(R.id.bart1imageView);

        ImageView bart2Image = (ImageView) findViewById(R.id.bart2imageView);

        if(bart1Show){
            bart1Show = false;

            bart1Image.animate().alpha(0).setDuration(2000);
            bart2Image.animate().alpha(1).setDuration(2000);
        }else{
            bart1Show = true;

            bart1Image.animate().alpha(1).setDuration(2000);
            bart2Image.animate().alpha(0).setDuration(2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
