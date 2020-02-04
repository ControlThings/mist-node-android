/**
 * Copyright (C) 2020, ControlThings Oy Ab
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * @license Apache-2.0
 */
package mistNode;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import addon.AddonReceiver;
import fi.ct.mistService.reference.R;
import mist.node.Service;


// implements mist receiver
public class MainActivity extends AppCompatActivity implements AddonReceiver.Receiver {

    private final String TAG = "MainActivity";

    private Intent serviceIntent;
    FlashLight light;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Resopnse receiver for mist service (onConnected)
        AddonReceiver mistReceiver = new AddonReceiver(this);

        // Init Mist
        serviceIntent = new Intent(this, Service.class);
        serviceIntent.putExtra("receiver", mistReceiver);

        // Start Mist service
        startService(serviceIntent);
    }

    // Mist is runing and connected to wish
    @Override
    public void onConnected() {

        light = new FlashLight(getBaseContext());

    }

    @Override
    public void onDisconnected() {
        Log.d(TAG, "onDisconnected");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //light.cleanup();
        stopService(serviceIntent);
    }
}
