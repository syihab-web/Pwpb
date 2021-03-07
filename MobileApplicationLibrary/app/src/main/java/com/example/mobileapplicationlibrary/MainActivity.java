package com.example.mobileapplicationlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button barcode;
    private Button pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barcode = (Button) findViewById(R.id.barcode);
        pdf = (Button) findViewById(R.id.pdf);

        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bar = new Intent(MainActivity.this, BarcodeGeneratorActivity.class);
                startActivity(bar);
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pdf = new Intent(MainActivity.this, PdfGeneratorActivity.class);
                startActivity(pdf);
            }
        });
    }
}