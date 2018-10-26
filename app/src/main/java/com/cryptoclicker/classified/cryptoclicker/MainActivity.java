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

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    System.out.println("butts")
/*
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

    int miniClick=0;
    int countdown=0;
    TextView coolPoints;
    int ngPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        saveGame();
        loadGame();
     //   Show();
        Hide();
        Hide2();
        newGame1();
        hide1.setVisibility(View.INVISIBLE);
        hide2.setVisibility(View.INVISIBLE);

        showValue = findViewById(R.id.Counter);
        handler.postDelayed(runnable, tInterval);
        counter = getCurrency();


        coolPoints = findViewById(R.id.cPoints);
        coolPoints.setVisibility(View.INVISIBLE);

       pwrClick = upgrades.getPower();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        writeCurrency();
    }

    @Override
    protected void onStop() {
        super.onStop();
        writeCurrency();
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
                showValue.setText(formatVal(counter)+ " BTC");
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

    public Button newGame;
    public void newGame1(){
        newGame =  findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                coolPoints.setVisibility(View.VISIBLE);


                if(counter>=10000){
                    ngPoints+=1;
                    counter-=10000;
                    Toast.makeText(getApplicationContext(),"New Game Plus point added!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(),"Not enough coins!", Toast.LENGTH_SHORT).show();
                }
                if(ngPoints==1){
                    coolPoints.setText(Integer.toString((int) ngPoints) + " Cool Point!");}
                else{
                    coolPoints.setText(Integer.toString((int) ngPoints) + " Cool Points!");
                }

            }
        });
    }

    private String formatVal(double value) {
        DecimalFormat formatter = new DecimalFormat(",###");
        return formatter.format(value);
    }


    public void writeCurrency() {
        SQLiteDatabase database = db.getWritableDatabase();
        database.execSQL("UPDATE data SET currency=('" + counter + "')");
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
                hide2.setVisibility(View.VISIBLE);
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
                showValue.setText(formatVal(counter)+ " BTC");
                Toast.makeText(getApplicationContext(),"GAINED "+formatVal(temp)+" COINS", Toast.LENGTH_SHORT).show();
                hide1.setVisibility(View.INVISIBLE);
            }
        });
    }

    public Button hide2;
    public void Hide2(){
        hide2 =  findViewById(R.id.event2);
        hide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countdown=1;
                Toast.makeText(getApplicationContext(),"OMEGA EVENT ACTIVATED", Toast.LENGTH_SHORT).show();
                hide2.setVisibility(View.INVISIBLE);
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


    public void coinClick(View view){
        if(countdown==1){

            counter+=counter;
            if(miniClick>=10){
                countdown=0;

            }
            else{
                miniClick+=1;
            }

        }else {
            counter += pwrClick;
        }

        playSound();
        showValue.setText(Integer.toString((int) counter) + " BTC");

        if(random()==0){
            hide1.setVisibility(View.VISIBLE);
        }
        if(random()==10){
            hide2.setVisibility(View.VISIBLE);
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
        int i1 = r.nextInt(11 )  ;
        return i1;
    }

    public void deb(View view){
        counter+=10000;
    }

    private void increment(){
        counter += upgrades.cycle() * ((double) tInterval/1000);
        showValue.setText(formatVal(counter)+ " BTC");
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
                showValue.setText(formatVal(counter)+ " BTC");
            }

        }
        if (requestCode == 2) {
            if(resultCode == RESULT_OK) {
                achMultiplier = data.getDoubleExtra("achMultiplier", achMultiplier);
            }
        }

    }
    */
}
