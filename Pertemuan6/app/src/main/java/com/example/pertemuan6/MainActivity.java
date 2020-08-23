package com.example.pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btngrid_layout, btnconstraint_layout, btnIntent, btnlatihanintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btngrid_layout = (Button) findViewById(R.id.grid_layout);
        btngrid_layout.setOnClickListener(this);

        btnconstraint_layout = (Button) findViewById(R.id.constraint_layout);
        btnconstraint_layout.setOnClickListener(this);

        btnlatihanintent = (Button) findViewById(R.id.latihan_intent);
        btnlatihanintent.setOnClickListener(this);

        btnIntent = (Button) findViewById(R.id.intent_main);
        btnIntent.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.grid_layout :
                Intent grid = new Intent(this, GridLayout.class);
                startActivity(grid);
                break;

            case R.id.constraint_layout :
                Intent constraint = new Intent(this, ConstraintLayout.class);
                startActivity(constraint);
                break;

            case R.id.intent_main :
                Intent intent = new Intent(this, MainActivityIntent.class);
                startActivity(intent);
                break;

            case R.id.latihan_intent :
                Intent latihanintent = new Intent(this, LatihanIntent.class);
                startActivity(latihanintent);
                break;
        }
    }
}