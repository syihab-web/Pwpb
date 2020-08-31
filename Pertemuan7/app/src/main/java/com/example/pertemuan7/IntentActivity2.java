package com.example.pertemuan7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity2 extends AppCompatActivity implements View.OnClickListener {
    ImageView back1;
    Button preview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);


        preview = (Button) findViewById(R.id.next2);
        preview.setOnClickListener(this);

        back1 = (ImageView) findViewById(R.id.back1);
        back1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back1 :
                finish();
                break;

            case R.id.next2 :
                Intent next = new Intent(this, IntentActivity3.class);
                startActivity(next);
                break;
        }
    }
}