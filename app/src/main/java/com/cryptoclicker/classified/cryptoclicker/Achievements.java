package com.cryptoclicker.classified.cryptoclicker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Achievements extends AppCompatActivity {

    //A double that should represent the percentage to be added to the total gains
    public double achMultiplier = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
        //progressBar.setProgress();

        final ProgressBar progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
        final ProgressBar progressBar3 = (ProgressBar)findViewById(R.id.progressBar3);
        final ProgressBar progressBar4 = (ProgressBar)findViewById(R.id.progressBar4);
        final ProgressBar progressBar5 = (ProgressBar)findViewById(R.id.progressBar5);
        final ProgressBar progressBar6 = (ProgressBar)findViewById(R.id.progressBar6);
        final ProgressBar progressBar7 = (ProgressBar)findViewById(R.id.progressBar7);
        final ProgressBar progressBar8 = (ProgressBar)findViewById(R.id.progressBar8);

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

                if (one.getCurrency() > one.getUnlockCount()) {
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
                two.checkCount();
                if (two.getUn()) {
                    achMultiplier += .05;
                    button2.setEnabled(false);
                }

            }
        });

        final Button button3 = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                three.checkCount();
                if (three.getUn()) {
                    achMultiplier += .1;
                    button3.setEnabled(false);
                }

            }
        });

        final Button button4 = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                four.checkCount();
                if (four.getUn()) {
                    achMultiplier += .1;
                    button4.setEnabled(false);
                }

            }
        });

        final Button button5 = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                five.checkCount();
                if (five.getUn()) {
                    achMultiplier += .1;
                    button5.setEnabled(false);
                }

            }
        });

        final Button button6 = findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                six.checkCount();
                if (six.getUn()) {
                    achMultiplier += .1;
                    button6.setEnabled(false);
                }

            }
        });

        final Button button7 = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                seven.checkCount();
                if (seven.getUn()) {
                    achMultiplier += .2;
                    button7.setEnabled(false);
                }

            }
        });


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

