package com.demo.demo.demo.activity;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;

import com.demo.demo.demo.R;
import com.demo.demo.demo.base.BaseActivity;
import com.demo.demo.demo.databinding.ActivityMainBinding;
import com.demo.demo.demo.presenter.MainPresenter;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.DeleteViews;
import com.demo.demo.demo.views_interface.MainView;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    ActivityMainBinding binding;

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void getBinding() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initEvent() {
        super.initEvent();



        binding.btWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,WriteActivity.class);
                startActivity(intent);
            }
        });


        binding.btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ReadActivity.class);
                startActivity(intent);
            }
        });

        binding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
            }
        });

        binding.btNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, LineChartActivity.class);
                startActivity(intent);
            }
        });
    }

}
