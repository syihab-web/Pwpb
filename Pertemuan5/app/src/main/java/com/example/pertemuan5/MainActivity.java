package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next, next2;
        next = (Button) findViewById(R.id.next);
        next2 = (Button) findViewById(R.id.next2);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Framelayout();
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Framelayout2();
            }
        });
    }


    //Method Pindah Halaman
    public void Framelayout(){
        Intent next = new Intent(this, Framelayout.class);
        startActivity(next);
    }
    public void Framelayout2(){
        Intent next2 = new Intent(this, FrameLayout2.class);
        startActivity(next2);
    }
}