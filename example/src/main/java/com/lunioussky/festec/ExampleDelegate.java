package com.lunioussky.festec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lunioussky.latte.delegates.LatteDelegate;

/**
 * Created by lunious on 2017/10/9.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
