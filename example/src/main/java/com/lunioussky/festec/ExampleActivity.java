package com.lunioussky.festec;


import com.lunioussky.latte.activities.ProxyActivity;
import com.lunioussky.latte.delegates.LatteDelegate;


public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
