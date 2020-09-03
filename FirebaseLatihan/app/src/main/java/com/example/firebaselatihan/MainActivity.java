package com.example.firebaselatihan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ANIME_NAME = "animename";
    public static final String ANIME_ID = "animeid";

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

        listViewAnime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AnimeStudio anime = animeList.get(i);

                Intent intent = new Intent(getApplicationContext(), AddCharaActivity.class);
                intent.putExtra(ANIME_ID, anime.getIdStudio());
                intent.putExtra(ANIME_NAME, anime.getAnimeName());

                startActivity(intent);
            }
        });

        listViewAnime.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AnimeStudio anime = animeList.get(i);
                showUpdateDialog(anime.getIdStudio(), anime.getAnimeName());
                return false;
            }
        });
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

    private void showUpdateDialog(final String animeId, String animeName){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final Button update = (Button) dialogView.findViewById(R.id.btnupdate);
        final Spinner spinnerStudio = (Spinner) dialogView.findViewById(R.id.spinnerStudio);
        final Button delete = (Button) dialogView.findViewById(R.id.btndelete);

        dialogBuilder.setTitle("Updating Anime " + animeName);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = editTextName.getText().toString().trim();
               String studio = spinnerStudio.getSelectedItem().toString();

               if (TextUtils.isEmpty(name)){
                   editTextName.setError("Name Required!");
                   return;
               }
               updateAnime(animeId, name, studio);
               alertDialog.dismiss();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAnime(animeId);
            }
        });
    }

    private void deleteAnime(String animeId) {
        DatabaseReference dbAnime = FirebaseDatabase.getInstance().getReference("anime").child(animeId);
        DatabaseReference dbChara = FirebaseDatabase.getInstance().getReference("chara").child(animeId);

        dbAnime.removeValue();
        dbChara.removeValue();

        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_LONG).show();

    }

    private boolean updateAnime(String id, String name, String studio){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("anime").child(id);
        AnimeStudio anime = new AnimeStudio(id, name, studio);
        databaseReference.setValue(anime);
        Toast.makeText(this, "Anime Updated Successfully", Toast.LENGTH_LONG).show();
        return true;
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