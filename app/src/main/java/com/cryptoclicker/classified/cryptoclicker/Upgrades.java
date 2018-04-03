package com.cryptoclicker.classified.cryptoclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;

public class Upgrades extends AppCompatActivity {

    private static int upgrade[] = new int[] {0,0,0,0}; // usb stick, mining rig, server rack, supercomputer
    private static double gain[] = new double[] {0.03125, 0.25, 2, 16};
    private static double price[] = new double[] {32, 65, 500, 4000, 32000};
    private static int power = 1;
    private static TextView ug[] = new TextView[5];
    private static Button buy[] = new Button[5];
    private static TextView funds;

    private double coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);
        ImageView backgroundimage = (ImageView) findViewById(R.id.background2);
        Animation backgroundrotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        backgroundimage.startAnimation(backgroundrotate);
        ImageView imageView = (ImageView) findViewById(R.id.pi);
        ImageView imageView2 = (ImageView) findViewById(R.id.rig);
        ImageView imageView3 = (ImageView) findViewById(R.id.server);
        ImageView imageView4 = (ImageView) findViewById(R.id.supercomp);
        Animation pulse = AnimationUtils.loadAnimation(this, R.anim.breathe);
        imageView.startAnimation(pulse);
        imageView2.startAnimation(pulse);
        imageView3.startAnimation(pulse);
        imageView4.startAnimation(pulse);
        coins = getIntent().getDoubleExtra("coins",0);
        ug[0] = findViewById(R.id.ugP);
        ug[1] = findViewById(R.id.ug1);
        ug[2] = findViewById(R.id.ug2);
        ug[3] = findViewById(R.id.ug3);
        ug[4] = findViewById(R.id.ug4);
        buy[0] = findViewById(R.id.ugPbuy);
        buy[1] = findViewById(R.id.ug1buy);
        buy[2] = findViewById(R.id.ug2buy);
        buy[3] = findViewById(R.id.ug3buy);
        buy[4] = findViewById(R.id.ug4buy);
        init();
        funds = findViewById(R.id.ugFunds);
        funds.setText(formatVal(coins));
    }

    public Upgrades() {
    }

    public Upgrades(int items[], int pLevel) {
        for (int i=0; i < items.length; i++) {
            price[i+1] *= items[i] * 1.5;
            upgrade[i] = items[i];
        }
        if (pLevel > 1) {
            power = pLevel;
            price[0] *= (power-1) * 1.75;
        }
    }

    private void init() {
        for (int i=0; i < upgrade.length;) {
            String ugText = "Owned: "+upgrade[i];
            i++;
            ug[i].setText(ugText);
            buy[i].setText(formatVal(price[i]));
        }
        ug[0].setText("Current: "+power);
        buy[0].setText(formatVal(price[0]));
    }

    private String formatVal(double value) {
        DecimalFormat formatter = new DecimalFormat(",###");
        return formatter.format(value)+ " \u20BF";
    }

    public double cycle() {
        double coins = 0.0;
        for (int i=0; i < upgrade.length; i++) {
            coins += gain[i] * upgrade[i];
        }
        return coins;
    }

    public void buyUpgrade(View view) {
        int item = 0;
        switch (view.getId()) {
            case R.id.ugPbuy:
                item = 0;
                break;
            case R.id.ug1buy:
                item = 1;
                break;
            case R.id.ug2buy:
                item = 2;
                break;
            case R.id.ug3buy:
                item = 3;
                break;
            case R.id.ug4buy:
                item = 4;
                break;
        }
        if (coins - price[item] > 0) {
            coins -= price[item];
            if (item == 0) {
                power++;
            } else {
                upgrade[item - 1]++;
            }
            price[item] *= (item == 0) ? 1.75 : 1.5;
        }
        String ugText = (item == 0) ? "Current: "+power : "Owned: "+upgrade[item-1];
        ug[item].setText(ugText);
        buy[item].setText(formatVal(price[item]));
        funds.setText(formatVal(coins));
    }

   public int getPower() {
        return power;
    }

    public void button4(View view){
        coins+=coins+10000;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("coins", coins);
        intent.putExtra("power", power);
        setResult(RESULT_OK, intent);
        finish();
    }
}
