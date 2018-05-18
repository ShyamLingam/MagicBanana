package com.example.shyam.magicbanana;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Shyam on 29/4/18.
 */


public class game2 extends AppCompatActivity {

    private static final String TAG = "game2";

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView monkey;
    private ImageView banana;
    private ImageView poison;
    private ImageView magic;

    //Size of Monkey
    private int frameHeight;
    private int monkeySize;
    private int screenWidth;
    private int screenHeight;



    //Position of Monkey

    private int monkeyY;
    private int bananaX;
    private int bananaY;
    private int poisonX;
    private int poisonY;
    private int magicX;
    private int magicY;


    //score
    private int score = 0;



    //Int Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();


    // Status Check

    private boolean action_flg = false;
    private boolean start_flg = false;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2);

        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);
        monkey = (ImageView) findViewById(R.id.monkey);
        banana = (ImageView) findViewById(R.id.banana);
        poison = (ImageView) findViewById(R.id.poison);
        magic = (ImageView) findViewById(R.id.magic);


        //Screen Size

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;


        //move away from screen

        banana.setX(-80);
        banana.setY(-80);
        poison.setX(-80);
        poison.setY(-80);
        magic.setX(-80);
        magic.setY(-80);


        scoreLabel.setText("Score : 0");




    }

    public void changePos(){

        hitCheck();


        // banana

        bananaX -= 20;
        if (bananaX <0) {
            bananaX = screenWidth + 20;
            bananaY = (int) Math.floor(Math.random() * (frameHeight - banana.getHeight()));
        }
        banana.setX(bananaX);
        banana.setY(bananaY);

        //poison attack
        poisonX -= 25;
        if (poisonX < 0) {
            poisonX = screenWidth +10;
            poisonY = (int) Math.floor(Math.random() * (frameHeight - poison.getHeight()));
        }
        poison.setX(poisonX);
        poison.setY(poisonY);

        //Magic Banana for bonus points
        magicX -= 30;
        if (magicX <0) {
            magicX = screenWidth + 5000;
            magicY = (int) Math.floor(Math.random() * (frameHeight - magic.getHeight()));
        }
        magic.setX(magicX);
        magic.setY(magicY);

        //Moving the monkey
        if (action_flg == true){
            //Touching
            monkeyY -= 20;

        } else {
            //Release
            monkeyY += 20;
        }


        //monkey position

        if (monkeyY < 0) monkeyY = 0;

        if (monkeyY > frameHeight - monkeySize) monkeyY = frameHeight - monkeySize;

        monkey.setY(monkeyY);

        scoreLabel.setText("Score : " + score);

    }

    public void hitCheck() {

        // if the banana hits the monkey

        int bananaCenterX = bananaX + banana.getWidth() / 2;
        int bananaCenterY = bananaY + banana.getHeight() / 2;

        if (0 <= bananaCenterX && bananaCenterX <= monkeySize &&
                monkeyY <= bananaCenterY && bananaCenterY <= monkeyY + monkeySize) {

            score += 5;
            bananaX = -10;

        }

        //pink
        int magicCenterX = magicX + magic.getWidth() / 2;
        int magicCenterY = magicY + magic.getHeight() / 2;

        if (0 <= magicCenterX && magicCenterX <= monkeySize &&
                monkeyY <= magicCenterY && magicCenterY <= monkeyY + monkeySize) {

            score += 10;
            magicX = -10;


        }

        // Poison attack
        int poisonCenterX = poisonX + poison.getWidth() / 2;
        int poisonCenterY = poisonY + poison.getHeight() / 2;

        if (0 <= poisonCenterX && poisonCenterX <= monkeySize &&
                monkeyY <= poisonCenterY && poisonCenterY <= monkeyY + monkeySize) {

            // Stop Timer
            timer.cancel();



            //Show Result
            Intent intent = new Intent(getApplicationContext(), result.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);

        }

    }
    public boolean onTouchEvent(MotionEvent me) {

        if (start_flg == false) {

            start_flg = true;

            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();

            monkeyY = (int)monkey.getY();

            monkeySize = monkey.getHeight();


            startLabel.setVisibility(View.GONE);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 20);

        } else {
            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;

            } else if (me.getAction() == MotionEvent.ACTION_UP){
                action_flg = false;
        }


        }

        return true;
    }

}


