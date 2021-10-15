package com.example.kalulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    TextView textViewResult;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        buttonBack = (Button) findViewById(R.id.button);
        getData();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityResult.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getData() {
        String data = getIntent().getStringExtra("DATA");
        textViewResult.setText(data);
    }
}