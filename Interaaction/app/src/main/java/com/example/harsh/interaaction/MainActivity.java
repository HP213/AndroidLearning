package com.example.harsh.interaaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void makeInteraction(View view){
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);

        Log.i("Info", "Intraction");
        Log.i("Value", nameEditText.getText().toString());

        Toast.makeText(this, "Hi There! " + nameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
