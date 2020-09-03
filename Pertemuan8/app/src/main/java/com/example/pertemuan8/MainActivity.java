package com.example.pertemuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisiaiisasi ListView
        listView = (ListView) findViewById(R.id.listView);

        //Penerapan ListView pada tampilan
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);


        //Item yang akan ditampilkan dalam ListView
        list.add("RPL");
        list.add("TKJ");
        list.add("MM");
        list.add("AVI");
        list.add("TOI");
        list.add("TITL");
    }
}