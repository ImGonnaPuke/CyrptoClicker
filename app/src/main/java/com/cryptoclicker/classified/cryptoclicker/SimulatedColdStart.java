package com.cryptoclicker.classified.cryptoclicker;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by ollux on 2/6/2018.
 */

public class SimulatedColdStart extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
