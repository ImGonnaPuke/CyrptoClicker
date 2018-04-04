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
import java.util.Arrays;

public class Achievements extends AppCompatActivity {

    //A double that should represent the percentage to be added to the total gains
    static double achMultiplier = 0;
    long coins = 0;
    ProgressBar bar[] = new ProgressBar[8];
    long barLevel[] = new long[] {10,100,1000,10000,100000,1000000,1000000000,1000000000000L};
    double multipliers[] = new double[] {0.05,0.05,0.1,0.1,0.1,0.1,0.2,0.2};
    Button btn[] = new Button[8];
    static Boolean clicked[] = new Boolean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background2);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        coins = (long)getIntent().getDoubleExtra("coins", 0);

        if (clicked[0] == null) Arrays.fill(clicked, false);

        bar[0] = findViewById(R.id.progressBar);
        bar[1] = findViewById(R.id.progressBar2);
        bar[2] = findViewById(R.id.progressBar3);
        bar[3] = findViewById(R.id.progressBar4);
        bar[4] = findViewById(R.id.progressBar5);
        bar[5] = findViewById(R.id.progressBar6);
        bar[6] = findViewById(R.id.progressBar7);
        bar[7] = findViewById(R.id.progressBar8);

        btn[0] = findViewById(R.id.button);
        btn[1] = findViewById(R.id.button2);
        btn[2] = findViewById(R.id.button3);
        btn[3] = findViewById(R.id.button4);
        btn[4] = findViewById(R.id.button5);
        btn[5] = findViewById(R.id.button6);
        btn[6] = findViewById(R.id.button7);
        btn[7] = findViewById(R.id.button8);

        for(int i=0; i < bar.length; i++) {
            long pMax = barLevel[i];
            long pVal = coins;
            if (barLevel[i] > 2000000000) {
                pMax = barLevel[i] / 10000000;
                pVal = coins / 10000000;
            }
            bar[i].setMax((int) pMax);
            if (pVal > pMax) pVal = pMax;
            bar[i].setProgress((int) pVal);
            if (clicked[i]) {
                btn[i].setEnabled(false);
            }
        }

        //public int getCurrency() {
            //SQLiteDatabase database = db.getReadableDatabase();
            //Cursor cursor = db.fetchCurrency(database);
            //cursor.moveToFirst();
            //int currency = cursor.getInt(0);
            //return currency;
        //}

        for (int i=0; i<btn.length; i++){
            btn[i].setEnabled(false);
            if (coins >= barLevel[i] && !clicked[i]) {
                btn[i].setEnabled(true);
            }
        }
    }

    public void btn0clk(View view) {
        achMultiplier += multipliers[0];
        clicked[0] = true;
        btn[0].setEnabled(false);
    }

    public void btn2clk(View view) {
        achMultiplier += multipliers[1];
        clicked[1] = true;
        btn[1].setEnabled(false);
    }

    public void btn3clk(View view) {
        achMultiplier += multipliers[2];
        clicked[2] = true;
        btn[2].setEnabled(false);
    }

    public void btn4clk(View view) {
        achMultiplier += multipliers[3];
        clicked[3] = true;
        btn[3].setEnabled(false);
    }

    public void btn5clk(View view) {
        achMultiplier += multipliers[4];
        clicked[4] = true;
        btn[4].setEnabled(false);
    }

    public void btn6clk(View view) {
        achMultiplier += multipliers[5];
        clicked[5] = true;
        btn[5].setEnabled(false);
    }

    public void btn7clk(View view) {
        achMultiplier += multipliers[6];
        clicked[6] = true;
        btn[6].setEnabled(false);
    }

    public void btn8clk(View view) {
        achMultiplier += multipliers[7];
        clicked[7] = true;
        btn[7].setEnabled(false);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("achMultiplier", achMultiplier);
        setResult(RESULT_OK, intent);
        finish();
    }
}

