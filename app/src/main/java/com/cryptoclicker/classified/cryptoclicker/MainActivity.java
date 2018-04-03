package com.cryptoclicker.classified.cryptoclicker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    DatabaseHandler db = new DatabaseHandler (this);
    SQLiteDatabase database;
    double counter = 0;
    int pwrClick = 1;
    public Button Up;
    long tInterval = 500;
    Upgrades upgrades = new Upgrades();;
    public int rand;
    double achMultiplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        saveGame();
        loadGame();
        Show();
        Hide();
        hide1.setVisibility(View.INVISIBLE);
        showValue = findViewById(R.id.Counter);
        handler.postDelayed(runnable, tInterval);

       pwrClick = upgrades.getPower();
    }

    public Button savegame;

    public void saveGame() {
        savegame = findViewById(R.id.savegame);
        savegame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeCurrency();
                Toast.makeText(getApplicationContext(),"Game saved successfully.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Button loadgame;

    public void loadGame() {
        loadgame = findViewById(R.id.loadgame);
        loadgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = getCurrency();
                showValue.setText(Integer.toString((int) counter)+ " BTC");
                Toast.makeText(getApplicationContext(),"Game loaded successfully.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void uGrades(View view) {
        Intent why = new Intent(MainActivity.this, Upgrades.class);
        why.putExtra("coins", counter);
        startActivityForResult(why, 1);
    }

    public Button Ach;

    public void Achievements(View view){
        Intent why1 = new Intent(MainActivity.this, Achievements.class);
        why1.putExtra("coins", counter);
        startActivityForResult(why1, 2);
    }


    public void writeCurrency() {
        database = db.getWritableDatabase();
        database.execSQL("UPDATE Data SET Currency=('"+counter+"')" );
    }

    public int getCurrency() {
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = db.fetchCurrency(database);
        cursor.moveToFirst();
        int currency = cursor.getInt(0);
        return currency;
    }

    public void playSound() {
        MediaPlayer coinDropMediaPlayer = MediaPlayer.create(this, R.raw.coin_drop);
        coinDropMediaPlayer.start();
        coinDropMediaPlayer.release();

    }

    private Handler handler = new Handler();

    public Button show1;
    public void Show(){
       show1 = findViewById(R.id.show);
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
        counter += pwrClick;
        playSound();
        showValue.setText(Integer.toString((int) counter)+ " BTC");

       if(random()==0){
            hide1.setVisibility(View.VISIBLE);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            increment();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                counter = data.getDoubleExtra("coins", counter);
                pwrClick = data.getIntExtra("power", pwrClick);
                showValue.setText(Integer.toString((int) counter)+ " BTC");
            }

        }
        if (requestCode == 2) {
            if(resultCode == RESULT_OK) {
                achMultiplier = data.getDoubleExtra("achMultiplier", achMultiplier);
            }
        }
    }
}
