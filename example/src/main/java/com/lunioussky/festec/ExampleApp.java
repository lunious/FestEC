package com.lunioussky.festec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.lunioussky.latte.app.Latte;
import com.lunioussky.latte.ec.icon.FontEcModule;

/**
 * Created by lunious on 2017/10/9.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcons(new FontAwesomeModule())
                .withIcons(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
