package com.example.announce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{
    EditText inpTitle, inpDesc;
    Context context;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        inpTitle = findViewById(R.id.inp_title);
        inpDesc = findViewById(R.id.inp_desc);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnSubmit.setOnClickListener(this);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        String oldTitle = (String) extras.get("TITLE");
        inpTitle.setText(oldTitle);
        String oldDesc = (String) extras.get("DESC");
        inpDesc.setText(oldDesc);


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        if (inpTitle.getText().toString().length() == 0 || inpDesc.getText().toString().length() == 0) {
            inpTitle.setError("Title is required!");
            inpDesc.setError("Description is required!");
        } else {
            if (v.getId() == R.id.btnsubmit) {
                DatabaseHelper db = new DatabaseHelper(this);
                Post currentPost = new Post();
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    Date date = new Date();
                    currentPost.setTitle(inpTitle.getText().toString());
                    currentPost.setDesc(inpDesc.getText().toString());
                    currentPost.setDatetime(dateFormat.format(date));
                    db.update(currentPost);
                    Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
            }
        }

    }
}