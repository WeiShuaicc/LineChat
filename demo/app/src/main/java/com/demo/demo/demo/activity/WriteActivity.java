package com.demo.demo.demo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.demo.demo.demo.R;
import com.demo.demo.demo.base.BaseActivity;
import com.demo.demo.demo.databinding.ActivityWriteBinding;
import com.demo.demo.demo.presenter.WritePresenter;
import com.demo.demo.demo.views_interface.WriteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends BaseActivity<WritePresenter> implements  WriteViews{

    ActivityWriteBinding binding;

    int num=0;
    String date_time;
    @Override
    protected WritePresenter getPresenter() {
        return new WritePresenter(this);
    }

    @Override
    protected void getBinding() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_write);
    }

    @Override
    protected void initData() {
        super.initData();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        date_time=df.format(new Date()).toString();
        binding.tvDate.setText(date_time);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        binding.etWrite.addTextChangedListener(new TextWatcher() {

            private CharSequence s;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                s=charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                    num=s.length();
                    binding.tvNum.setText(""+num);
            }
        });

        binding.btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=binding.etWrite.getText().toString();
                Log.e("Write",str);
                Log.e("Write",""+num);
                Log.e("Write",date_time);
                presenter.writer(str,num,date_time);
            }
        });


    }

    @Override
    public void result() {
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        finish();
    }
}
