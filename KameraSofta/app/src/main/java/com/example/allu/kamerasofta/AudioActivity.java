package com.example.allu.kamerasofta;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class AudioActivity extends AppCompatActivity {
    public MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);



        mp = MediaPlayer.create(AudioActivity.this, R.raw.crow);
        mp.start();

        Button lopeta = (Button) findViewById(R.id.buttonLopeta);
        assert lopeta != null;
        lopeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
    }
}
