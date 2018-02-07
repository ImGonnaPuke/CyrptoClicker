package com.cryptoclicker.classified.cryptoclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Achievements extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
    }
    Achieve one = new Achieve(10, 0, "Collected 10 coins");
    Achieve two = new Achieve(100, 0, "Collected 100 coins");
    Achieve three = new Achieve(1000, 0, "Collected 1000 coins");

    Achieve upOne = new Achieve(0, "Bought your first upgrade");

}
