package com.example.firebaselatihan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Anime;
    Button btnSubmit;
    Spinner studio;
    ListView listViewAnime;
    List<AnimeStudio> animeList;


    DatabaseReference dbAnime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAnime = FirebaseDatabase.getInstance().getReference("anime");


        Anime = (EditText) findViewById(R.id.editText);
        btnSubmit = (Button) findViewById(R.id.submit);
        studio = (Spinner) findViewById(R.id.location);
        listViewAnime = (ListView) findViewById(R.id.listViewAnime);
        animeList = new ArrayList<>();

        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        dbAnime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                animeList.clear();
                for (DataSnapshot animeSnapshot : dataSnapshot.getChildren()){
                    AnimeStudio anime = animeSnapshot.getValue(AnimeStudio.class);
                    animeList.add(anime);
                }
                AnimeList adapter = new AnimeList(MainActivity.this, animeList);
                listViewAnime.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.submit :
                addStudio();
        }
    }

    private void addStudio(){
        String animeName = Anime.getText().toString().trim();
        String studioName = studio.getSelectedItem().toString();

        if (!TextUtils.isEmpty(animeName)){
            String idstd = dbAnime.push().getKey();

            AnimeStudio animeStudio = new AnimeStudio(idstd, animeName, studioName);
            dbAnime.child(idstd).setValue(animeStudio);

            Toast.makeText(this, "Anime added", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Enter the Anime Name", Toast.LENGTH_LONG).show();
        }
    }
}