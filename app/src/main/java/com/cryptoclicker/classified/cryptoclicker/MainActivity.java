package com.cryptoclicker.classified.cryptoclicker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import android.os.Handler;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView showValue;


    double counter = 0;
    public Button Up;
    long tInterval = 500;
    Upgrades upgrades = new Upgrades();
    public int rand;

    public void uGrades(){
        Up =  findViewById(R.id.upgrades);
        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent why = new Intent(MainActivity.this, Upgrades.class);
                startActivity(why);
            }
        });
    }

    public Button Ach;

    public void Achievements(){
        Ach =  findViewById(R.id.achi);
        Ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent why1 = new Intent(MainActivity.this, Achievements.class);
                startActivity(why1);
            }
        });
    }

    public void playSound() {
        MediaPlayer coinDropMediaPlayer = MediaPlayer.create(this, R.raw.coin_drop);
        coinDropMediaPlayer.start();
    }

    private Handler handler = new Handler();

    public Button show1;
    public void Show(){
        show1 =  findViewById(R.id.show);
       show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide1.setVisibility(View.VISIBLE);
            }
        });
    }

    public Button hide1;
    public void Hide(){
        hide1 =  findViewById(R.id.hide);
        hide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double temp;
                temp=counter/4;
                counter=counter*1.25;
                showValue.setText(Integer.toString((int) counter)+ " BTC");
                Toast.makeText(getApplicationContext(),"GAINED "+(int)temp+" COINS", Toast.LENGTH_SHORT).show();
                hide1.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        uGrades();
        Achievements();
        Show();
        Hide();


        hide1.setVisibility(View.INVISIBLE);



        showValue = findViewById(R.id.Counter);

        handler.postDelayed(runnable, tInterval);







    }


        /*
        Button main1 =  findViewById(R.id.magic);

        main1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyApp", "yes");
                Toast.makeText(getApplicationContext(),"its magic", Toast.LENGTH_SHORT).show();
                int clicks =0;
                clicks = clicks+1;
            }
        });
        */

    public void test(View view){
        counter ++;
        playSound();
        showValue.setText(Integer.toString((int) counter)+ " BTC");

       if(random()==0){
            hide1.setVisibility(View.VISIBLE);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
        //    increment();

            handler.postDelayed(this, tInterval);

        }
    };

    public int random(){

        //SystemClock.sleep(5000);
        Random r = new Random();
        int i1 = r.nextInt(10 )  ;
        return i1;
    }

    private void increment(){
        counter += upgrades.cycle() * ((double) tInterval/1000);
        showValue.setText(Integer.toString((int) counter)+ " BTC");
    }

    //Miguel: I put this method in to allow achievements to compare the score to unlock values, but I don't know if it works at runtime
    public double getScore() {
        return counter;
    }
}
