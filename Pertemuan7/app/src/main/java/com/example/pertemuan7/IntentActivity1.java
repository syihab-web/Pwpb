package com.example.pertemuan7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity1 extends AppCompatActivity implements View.OnClickListener {
    Button next, next2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        next = (Button) findViewById(R.id.next1);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next1 :
                Intent intent = new Intent(this, IntentActivity2.class);
                startActivity(intent);
                break;

        }
    }
}