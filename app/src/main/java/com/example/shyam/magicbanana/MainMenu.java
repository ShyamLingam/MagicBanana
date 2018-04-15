package com.example.shyam.magicbanana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        //Configuring Buttons

        Button btn1 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);


        //Intents for the buttons on how to changes to different class page.

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainMenu.this, settings.class);
                startActivity(int1);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2= new Intent(MainMenu.this, about.class);
                startActivity(int2);
            }
        });

    }
    // This method closes the application
    public void clickexit(View v) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
