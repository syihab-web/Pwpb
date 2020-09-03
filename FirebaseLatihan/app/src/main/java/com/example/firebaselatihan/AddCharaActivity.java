package com.example.firebaselatihan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AddCharaActivity extends AppCompatActivity {

    TextView textViewAnimeName;
    EditText chara;
    SeekBar rating;
    ListView listViewChara;
    Button addChara;
    List<Characters> charactersList;

    DatabaseReference dbChara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chara);

        textViewAnimeName = (TextView) findViewById(R.id.textViewAnimeName);
        chara = (EditText) findViewById(R.id.characters);
        rating = (SeekBar) findViewById(R.id.rating);
        listViewChara = (ListView) findViewById(R.id.listViewChara);
        addChara = (Button) findViewById(R.id.submitChara);

        Intent intent = getIntent();

        charactersList = new ArrayList<>();

        String id = intent.getStringExtra(MainActivity.ANIME_ID);
        String name = intent.getStringExtra(MainActivity.ANIME_NAME);

        textViewAnimeName.setText(name);

        dbChara = FirebaseDatabase.getInstance().getReference("chara").child(id);
        addChara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveChara();
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

        dbChara.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                charactersList.clear();
                for (DataSnapshot charaSnapshot : dataSnapshot.getChildren()){
                    Characters characters = charaSnapshot.getValue(Characters.class);
                    charactersList.add(characters);
                }
                CharaList adapter = new CharaList(AddCharaActivity.this, charactersList);
                listViewChara.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void saveChara(){
        String charaname = chara.getText().toString().trim();
        int chararating = rating.getProgress();

        if (!TextUtils.isEmpty(charaname)){
            String id = dbChara.push().getKey();
            Characters characters = new Characters(id, charaname, chararating);

            dbChara.child(id).setValue(characters);

            Toast.makeText(this, "Characters saved successfully", Toast.LENGTH_LONG).show();
            finish();
        }
        else{
            Toast.makeText(this, "Characters Name Should not be Empty!", Toast.LENGTH_LONG).show();
        }
    }
}