package com.lunioussky.latte.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by lunious on 2017/10/9.
 */

public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.CONFIG_READY.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    public static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATYION_CONTEXT.name());
    }
}