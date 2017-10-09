package com.lunioussky.festec;

import android.app.Application;

import com.lunioussky.latte.app.Latte;

/**
 * Created by lunious on 2017/10/9.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .configure();
    }
}
