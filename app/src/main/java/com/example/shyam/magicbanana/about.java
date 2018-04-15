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

public class about extends AppCompatActivity {

    private static final String TAG = "about";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Log.d(TAG, "OnCreate: Starting.");

        Button btn6 = (Button) findViewById(R.id.button6);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "OnClick: clicked button6.");

                Intent intent = new Intent(about.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }


}

