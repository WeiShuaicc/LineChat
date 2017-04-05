package com.demo.demo.demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/2/24/024.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity  {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBinding();
        presenter =getPresenter();
        initView(savedInstanceState);
        initData();
        initEvent();
    }

    protected void initData() {
    }

    protected void initEvent() {
    }

    protected void initView(Bundle savedInstanceState) {
    }


    protected abstract P getPresenter();

    protected abstract void getBinding();


}
