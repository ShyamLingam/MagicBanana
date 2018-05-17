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
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Shyam on 15/4/18.
 */

public class about extends AppCompatActivity {


    ArrayList<String> numberlist = new ArrayList<>();
    private static final String TAG = "about";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Log.d(TAG, "OnCreate: Starting.");
        get_json();
    }
        public void get_json()
    {
        String json;
        try
        {
            InputStream is = getAssets() .open("score.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.getString("first_name").equals("Sean"))
                {
                    numberlist.add(obj.getString("hscore"));
                }
            }

            Toast.makeText(getApplicationContext(),numberlist.toString(),Toast.LENGTH_LONG) .show();

        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


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

