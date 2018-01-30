package com.cryptoclicker.classified.cryptoclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showValue;
    int counter = 0;

    public Button Up;

    public void uGrades(){
        Up =  findViewById(R.id.upgrades);
        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent why = new Intent(MainActivity.this, Upgrades.class);
                startActivity(why);
            }
        });
    }

    public Button Ach;

    public void Achievements(){
        Ach =  findViewById(R.id.achi);
        Ach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent why1 = new Intent(MainActivity.this, Achievements.class);
                startActivity(why1);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uGrades();
        Achievements();

        showValue = (TextView) findViewById(R.id.Counter);
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
            counter ++;
            showValue.setText(Integer.toString(counter));

    }
}
