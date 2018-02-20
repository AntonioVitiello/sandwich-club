package com.udacity.sandwichclub;

import android.app.Application;

import com.util.Log;

/**
 * Created by Antonio on 20/02/2018.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.init(BuildConfig.DEBUG,
                getString(R.string.log_tag),
                getResources().getBoolean(R.bool.log_tag_concat));

//        Logger tests:
//        Log.d("MyApplication", "onCreate: my loger test");
//        android.util.Log.d("AntonioMyApplication", "onCreate: Android logger test");
    }

}
