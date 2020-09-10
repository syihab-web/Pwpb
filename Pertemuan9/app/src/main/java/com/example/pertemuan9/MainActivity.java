package com.example.pertemuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button next;
    private Button list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);

        list = (Button) findViewById(R.id.btnList);
        list.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNext :
                Intent next = new Intent(this, LatihanInputUser.class);
                startActivity(next);
                break;

            case R.id.btnList :
                Intent intent = new Intent(this, LatihanList.class);
                startActivity(intent);
                break;
        }
    }
}