package com.example.shyam.magicbanana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Configuring Buttons

        Button btn2 = (Button) findViewById(R.id.button2);


        //Intents for the buttons on how to changes to different class page.

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainMenu.this, settings.class);
                startActivity(int1);
            }
        });


    }
}

