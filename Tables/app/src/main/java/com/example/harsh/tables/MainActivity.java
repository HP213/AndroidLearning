package com.example.harsh.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tableListView;

    public void generateTables(int tableNumber){

        ArrayList<String> tableContent = new ArrayList<String>();

        for(int i = 1; i <= 10; i++){
            tableContent.add(Integer.toString(i) + " * " + Integer.toString(tableNumber) + " = " + Integer.toString(i*tableNumber));
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableContent);
        tableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tableSeekBar = findViewById(R.id.tableSeekBar);
        tableListView = findViewById(R.id.tableListVIew);

        tableSeekBar.setMax(30);
        tableSeekBar.setProgress(5);

        generateTables(5);

        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int tableNumber  = min;

                if(progress < min) {
                    tableNumber = min;
                    tableSeekBar.setProgress(min);
                }else{
                    tableNumber = progress;
                }

                Log.i("Seek : ", Integer.toString(tableNumber));

                generateTables(tableNumber);
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
