package com.lpq.sb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lpq.sb.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected boolean getStatusFlag() {
        return true;
    }

    @Override
    protected int getStatusBarColor() {
        return R.color.colorPrimaryDark;
    }

    public void jumpActivity(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }

}
