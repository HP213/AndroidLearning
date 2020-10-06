package com.example.harsh.currencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view){
        Log.i("info", "button");

        EditText editText = (EditText) findViewById(R.id.editText2);

        String amountInDollars = editText.getText().toString();

        double amountInDollarsDouble = Double.parseDouble(amountInDollars);

        double amountInRuppesDoiuble = amountInDollarsDouble*78;

        String amountInRuppes = String.format("%.2f", amountInRuppesDoiuble);

        Toast.makeText(this, "$" + amountInDollars + " is Rs. " + amountInRuppes, Toast.LENGTH_LONG).show();

        Log.i("In Ruppess", amountInRuppes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
