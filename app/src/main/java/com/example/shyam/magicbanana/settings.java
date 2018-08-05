package com.example.shyam.magicbanana;

import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shyam on 15/4/18.
 */

public class settings extends AppCompatActivity {

    MediaPlayer mdx;
    Button son, soff;

    private static final String TAG = "settings";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Log.d(TAG, "OnCreate: Starting.");




        Button btn5 = (Button) findViewById(R.id.button5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "OnClick: clicked button5.");

                Intent intent = new Intent(settings.this, MainMenu.class);
                startActivity(intent);
            }
        });

        son = (Button) findViewById(R.id.musicon);
        soff = (Button) findViewById(R.id.musicoff);


        mdx = MediaPlayer.create(settings.this, R.raw.main);
    }

    public void son(View v) {
        mdx.start();
    }

    public void soff(View v) {
        mdx.stop();
    }

    }


