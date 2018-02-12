package com.cryptoclicker.classified.cryptoclicker;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    TextView showValue;
    double counter = 0;
    public Button Up;
    long tInterval = 500;
    Upgrades upgrades = new Upgrades();

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

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        uGrades();
        Achievements();

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
        showValue.setText(Integer.toString((int) counter));
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            increment();
            handler.postDelayed(this, tInterval);
        }
    };

    private void increment(){
        counter += upgrades.cycle() * ((double) tInterval/1000);
        showValue.setText(Integer.toString((int) counter));
    }
}
