package com.example.kalulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView textResult;
    private EditText inputFirstOperand;
    private EditText inputSecondOperand;
    private Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        inputFirstOperand = (EditText) findViewById(R.id.inputFirstOperand);
        inputSecondOperand = (EditText) findViewById(R.id.inputSecondOperand);
        calcButton = (Button) findViewById(R.id.btnCalc);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityResult.class);
                String result = String.valueOf(calculate());
                intent.putExtra("DATA", result);
                startActivity(intent);
            }
        });
    }

    public int calculate() {
        String operatorChoice = spinner.getSelectedItem().toString();
        int firstOperand = Integer.parseInt(inputFirstOperand.getText().toString());
        int secondOperand = Integer.parseInt(inputSecondOperand.getText().toString());

        if(operatorChoice.equals("Penjumlahan")) {
            return firstOperand + secondOperand;
        } else if (operatorChoice.equals("Pengurangan")) {
            return firstOperand - secondOperand;
        } else if (operatorChoice.equals("Pembagian")) {
            return firstOperand / secondOperand;
        } else if (operatorChoice.equals("Perkalian")) {
            return firstOperand * secondOperand;
        }

        return 0;
    }
}