package com.example.harsh.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView2 = findViewById(R.id.myListView2);

        final ArrayList<String> friends= new ArrayList<String>();

        friends.add("Tota");
        friends.add("Gulu");
        friends.add("Adi");
        friends.add("Kuku");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, friends);

        myListView2.setAdapter(arrayAdapter);

        myListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hello " + friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });

//        ListView myListView = findViewById(R.id.myListView);

//        ArrayList<String> friends = new ArrayList<String>();
//
//        friends.add("Gurpreet");
//        friends.add("Adi");
//        friends.add("Gulu");
//        friends.add("Kuku");
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, friends);
//
//        myListView.setAdapter(arrayAdapter);
//
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                String name = view.
//
//            }
//        });
    }
}
