package com.example.pertemuan7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button explicitintent, implicitintent, latihanIntent, fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explicitintent = (Button) findViewById(R.id.explicitintent);
        explicitintent.setOnClickListener(this);

        implicitintent = (Button) findViewById(R.id.implicitintent);
        implicitintent.setOnClickListener(this);

        latihanIntent = (Button) findViewById(R.id.LatihanIntent);
        latihanIntent.setOnClickListener(this);

        fragment = (Button) findViewById(R.id.fragment);
        fragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.explicitintent :
                Intent explicit = new Intent(this, IntentActivity.class);
                startActivity(explicit);
                break;

            case R.id.implicitintent :
                openYt();
                break;

            case R.id.LatihanIntent :
                Intent latihan = new Intent(this, IntentActivity1.class);
                startActivity(latihan);
                break;

            case R.id.fragment :
                Intent f = new Intent(this, Home.class);
                startActivity(f);
                break;
        }

    }
    public void openYt(){
        String url = "https://www.youtube.com/channel/UC9Vf_ia-s9z9vpk18vhXqsw";
        Intent implicit = new Intent(Intent.ACTION_VIEW);
        implicit.setData(Uri.parse(url));
        startActivity(implicit);
    }
}