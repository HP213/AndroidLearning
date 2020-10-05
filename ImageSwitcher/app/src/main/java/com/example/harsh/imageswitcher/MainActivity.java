package com.example.harsh.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void switchImage(View view){
        Log.i("Message", "Clicked");

        ImageView image = (ImageView) findViewById(R.id.MSImage1);

        image.setImageResource(R.drawable.ms2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
