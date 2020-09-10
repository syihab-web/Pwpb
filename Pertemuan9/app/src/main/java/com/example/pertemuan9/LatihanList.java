package com.example.pertemuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pertemuan9.Adapter.MyListAdapter;
import com.example.pertemuan9.Model.Hero;

import java.util.ArrayList;
import java.util.List;

public class LatihanList extends AppCompatActivity {

    private List<Hero> heroList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_list);

        heroList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.heroList);

        heroList.add(new Hero(R.drawable.spiderman, "Spiderman", "Avengers"));
        heroList.add(new Hero(R.drawable.joker, "Joker", "Injustice Gang"));
        heroList.add(new Hero(R.drawable.ironman, "Iron Man", "Avengers"));
        heroList.add(new Hero(R.drawable.doctorstrange, "Doctor Strange", "Avengers"));
        heroList.add(new Hero(R.drawable.captainamerica, "Captain America", "Avengers"));
        heroList.add(new Hero(R.drawable.batman, "Batman", "Justice League"));

        MyListAdapter adapter = new MyListAdapter(this, R.layout.my_custom_list, heroList);
        listView.setAdapter(adapter);

    }

}