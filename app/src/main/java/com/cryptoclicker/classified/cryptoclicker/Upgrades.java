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

public class Upgrades extends AppCompatActivity {

    private static int upgrade[] = new int[] {0,0,0,0}; // usb stick, mining rig, server rack, supercomputer
    private static double gain[] = new double[] {0.01, 0.1, 1, 10};
    private static double price[] = new double[] {100, 250, 1000, 2500};
    private static int power = 1;
    private static TextView ug[] = new TextView[4];
    private static Button buy[] = new Button[4];
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
        ug[0] = findViewById(R.id.ug0);
        ug[1] = findViewById(R.id.ug1);
        ug[2] = findViewById(R.id.ug2);
        ug[3] = findViewById(R.id.ug3);
        buy[0] = findViewById(R.id.ug0buy);
        buy[1] = findViewById(R.id.ug1buy);
        buy[2] = findViewById(R.id.ug2buy);
        buy[3] = findViewById(R.id.ug3buy);
        init();
        funds = findViewById(R.id.ugFunds);
        funds.setText(Integer.toString((int) coins)+" \u20BF");
    }

    public Upgrades() {
    }

    public Upgrades(int items[], int pLevel) {
        for (int i=0; i < items.length; i++) {
            price[i] *= items[i] * 1.3;
            upgrade[i] = items[i];
        }
        power = (pLevel > 1) ? pLevel : 1;
    }

    private void init() {
        for (int i=0; i < upgrade.length; i++) {
            String ugText = "Owned: "+upgrade[i];
            String buyText = Integer.toString((int)price[i])+" \u20BF";
            ug[i].setText(ugText);
            buy[i].setText(buyText);
        }
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
            case R.id.ug0buy:
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
        }
        if (coins - price[item] > 0) {
            coins -= price[item];
            upgrade[item]++;
            price[item] *= 1.3;
        }
        String ugText = "Owned: "+upgrade[item];
        String buyText = Integer.toString((int)price[item])+" \u20BF";
        ug[item].setText(ugText);
        buy[item].setText(buyText);
        funds.setText(Integer.toString((int) coins)+" \u20BF");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("coins", coins);
        setResult(RESULT_OK, intent);
        finish();
    }
}
