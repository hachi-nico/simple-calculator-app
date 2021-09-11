package com.example.kalulator;

import androidx.appcompat.app.AppCompatActivity;

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
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        textResult = (TextView) findViewById(R.id.textResult);
        inputFirstOperand = (EditText) findViewById(R.id.inputFirstOperand);
        inputSecondOperand = (EditText) findViewById(R.id.inputSecondOperand);
        button = (Button) findViewById(R.id.btnCalc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = String.valueOf(calculate());
                textResult.setText(result);
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