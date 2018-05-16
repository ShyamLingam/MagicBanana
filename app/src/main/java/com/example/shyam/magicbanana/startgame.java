package com.example.shyam.magicbanana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startgame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);


    Button btn10 = (Button) findViewById(R.id.button10);
        Button btn11 = (Button) findViewById(R.id.button11);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(startgame.this, game.class);
                startActivity(int1);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(startgame.this, MainMenu.class);
                startActivity(int2);
            }
        });

    }

}




