package com.cryptoclicker.classified.cryptoclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Upgrades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrades);
    }

    private int upgrade[] = new int[]; // usb stick, mining rig, server rack, supercomputer
    private double gain[] = new double[];
    private double price[] = new double[];
    private int power = 1;

    public Upgrades() {

    }

    public Upgrades(int items[]) {
        for (int i=0; i < items.length; i++) {
            price[i] *= items[i] * 1.3;
            upgrade[i] = items[i];
        }
    }

    public double cycle() {
        double coins = 0.0;
        for (int i=0; i < upgrade.length; i++) {
            coins += gain[i] * upgrade[i];
        }
        return coins;
    }

    public void buy(int item, double funds) {
        if (funds - price[item] > 0) {
            funds -= price[item];
            upgrade[item]++;
            price[item] *= 1.3;
        }
    }
}
