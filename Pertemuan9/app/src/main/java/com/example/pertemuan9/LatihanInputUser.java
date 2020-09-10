package com.example.pertemuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LatihanInputUser extends AppCompatActivity {

    private EditText bil1;
    private EditText bil2;
    private EditText hasil;
    private Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_input_user);

        initUI();
        initEvent();
    }

    //Declaration method of id
    private void initUI(){
        bil1 = (EditText) findViewById(R.id.bil1);
        bil2 = (EditText) findViewById(R.id.bil2);
        hasil = (EditText) findViewById(R.id.hasil);
        hitung = (Button) findViewById(R.id.btnHitung);
    }
    //Event method
    private void initEvent(){
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungJumlah();
            }
        });
    }
    //addition method
    private void hitungJumlah(){
        int angka1 = Integer.parseInt(bil1.getText().toString());
        int angka2 = Integer.parseInt(bil2.getText().toString());
        int jumlah = angka1 + angka2;
        hasil.setText(String.valueOf(jumlah));
    }
}