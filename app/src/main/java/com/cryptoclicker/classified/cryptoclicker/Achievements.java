package com.cryptoclicker.classified.cryptoclicker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.content.Intent;

public class Achievements extends AppCompatActivity {

    //A double that should represent the percentage to be added to the total gains
    public double achMultiplier = 0;
    public int coins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background2);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        coins = (int)getIntent().getDoubleExtra("coins", 0);

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(coins);

        final ProgressBar progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
        progressBar2.setProgress(coins);

        final ProgressBar progressBar3 = (ProgressBar)findViewById(R.id.progressBar3);
        progressBar3.setProgress(coins);

        final ProgressBar progressBar4 = (ProgressBar)findViewById(R.id.progressBar4);
        progressBar4.setProgress(coins);

        final ProgressBar progressBar5 = (ProgressBar)findViewById(R.id.progressBar5);
        progressBar5.setProgress(coins);

        final ProgressBar progressBar6 = (ProgressBar)findViewById(R.id.progressBar6);
        progressBar6.setProgress(coins);

        final ProgressBar progressBar7 = (ProgressBar)findViewById(R.id.progressBar7);
        progressBar7.setProgress(coins);

        final ProgressBar progressBar8 = (ProgressBar)findViewById(R.id.progressBar8);
        progressBar8.setProgress(coins);

        //public int getCurrency() {
            //SQLiteDatabase database = db.getReadableDatabase();
            //Cursor cursor = db.fetchCurrency(database);
            //cursor.moveToFirst();
            //int currency = cursor.getInt(0);
            //return currency;
        //}

        //Test Achievements
        final Achieve one = new Achieve(10);
        final Achieve two = new Achieve(100);
        final Achieve three = new Achieve(1000);
        final Achieve four = new Achieve(10000);
        final Achieve five = new Achieve(100000);
        final Achieve six = new Achieve(1000000);
        final Achieve seven = new Achieve(1000000000);
        //Achieve eight = new Achieve(1 trillion); number too large


        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //one.checkCount();

                if (coins > one.getUnlockCount()) {
                    one.unlocked();
                }
                if (one.getUn()) {
                    achMultiplier += .05;
                    button.setEnabled(false);
                }

            }
        });

        final Button button2 = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (coins > two.getUnlockCount()) {
                    two.unlocked();
                }
                if (two.getUn()) {
                    achMultiplier += .05;
                    button2.setEnabled(false);
                }

            }
        });

        final Button button3 = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (coins > three.getUnlockCount()) {
                    three.unlocked();
                }
                if (three.getUn()) {
                    achMultiplier += .1;
                    button3.setEnabled(false);
                }

            }
        });

        final Button button4 = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (coins > four.getUnlockCount()) {
                    four.unlocked();
                }
                if (four.getUn()) {
                    achMultiplier += .1;
                    button4.setEnabled(false);
                }

            }
        });

        final Button button5 = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (coins > five.getUnlockCount()) {
                    five.unlocked();
                }
                if (five.getUn()) {
                    achMultiplier += .1;
                    button5.setEnabled(false);
                }

            }
        });

        final Button button6 = findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (coins > six.getUnlockCount()) {
                    six.unlocked();
                }
                if (six.getUn()) {
                    achMultiplier += .1;
                    button6.setEnabled(false);
                }

            }
        });

        final Button button7 = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (coins > seven.getUnlockCount()) {
                    seven.unlocked();
                }
                if (seven.getUn()) {
                    achMultiplier += .2;
                    button7.setEnabled(false);
                }

            }
        });
        /**
        public void onBackPressed() {
            Intent intent = new Intent();
            intent.putExtra("multiplier", achM);
            setResult(RESULT_OK, intent);
            finish()
        }
         **/


    }


    /**
     * The following are the commands when any button on the achievements page is pressed, I planned
     * to add something for the progress bars, but I don't know how to continually update the information
     * for the progress bars.
     */

    /**final Button button8 = findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            eight.checkCount();
            if (eight.getUn()) {
                achMultiplier += .2;
                button8.setEnabled(false);
            }

        }
    });
     **/
}

