package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //写三个方法
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();
    }
    //生成的方法
    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
