package com.cryptoclicker.classified.cryptoclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Upgrades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);
    }

    private static int upgrade[] = new int[] {0,1,1,0}; // usb stick, mining rig, server rack, supercomputer
    private static double gain[] = new double[] {0.01, 0.1, 1, 10};
    private static double price[] = new double[] {250, 5000, 50000, 1000000};
    private static int power = 1;

    public Upgrades() {

    }

    public Upgrades(int items[], int pLevel) {
        for (int i=0; i < items.length; i++) {
            price[i] *= items[i] * 1.3;
            upgrade[i] = items[i];
        }
        power = (pLevel > 1) ? pLevel : 1;
    }

    public double cycle() {
        double coins = 0.0;
        for (int i=0; i < upgrade.length; i++) {
            coins += gain[i] * upgrade[i];
        }
        return coins;
    }

    public double buy(int item, double funds) {
        if (funds - price[item] > 0) {
            funds -= price[item];
            upgrade[item]++;
            price[item] *= 1.3;
        }
        return funds;
    }
}
