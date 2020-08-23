package com.example.pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LatihanIntent2 extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_intent2);

        text = (TextView) findViewById(R.id.textview_data);
        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("name");
        text.setText(s);
    }
}