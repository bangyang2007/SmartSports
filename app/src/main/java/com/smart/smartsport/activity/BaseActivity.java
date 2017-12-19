package com.smart.smartsport.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yb on 17-12-7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        configViews();
        initData();
    }

    public abstract int getLayoutId();

    public abstract void configViews();

    public abstract void initData();
}
