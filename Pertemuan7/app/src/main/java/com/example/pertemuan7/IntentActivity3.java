package com.example.pertemuan7;


import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity3 extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private MediaController mediaController;
    private Button playVideo;
    private ImageView back;
    private DisplayMetrics dm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);

        videoView = findViewById(R.id.video);
        playVideo = findViewById(R.id.play);
        mediaController = new MediaController(this);
        back = (ImageView) findViewById(R.id.back2);
        back.setOnClickListener(this);
        playVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.play :
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.babylon);
                videoView.setVideoURI(uri);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                videoView.start();
                break;

            case R.id.back2 :
                finish();
        }
    }
}