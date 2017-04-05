package com.demo.demo.demo.activity;

import android.app.Dialog;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.demo.demo.demo.R;
import com.demo.demo.demo.adapter.ListAdapter;
import com.demo.demo.demo.base.BaseActivity;
import com.demo.demo.demo.databinding.ActivityDeleteBinding;
import com.demo.demo.demo.databinding.ActivityReadBinding;
import com.demo.demo.demo.presenter.DeletePresenter;
import com.demo.demo.demo.presenter.ReadPresenter;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.DeleteViews;

import java.util.List;

public class DeleteActivity extends BaseActivity<DeletePresenter> implements DeleteViews {

    ActivityDeleteBinding binding;

    private List<SQData> list;

    ListAdapter adapter;

    @Override
    protected DeletePresenter getPresenter() {
        return new DeletePresenter(this);
    }

    @Override
    protected void getBinding() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_delete);
    }

    @Override
    protected void initData() {
        super.initData();
       presenter.getData();

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        binding.lvDelete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    presenter.getEvent(list.get(position).getKey());
            }
        });

    }

    @Override
    public void resultData(List<SQData> list) {
        this.list=list;
        adapter=new ListAdapter(DeleteActivity.this,list);
        binding.lvDelete.setAdapter(adapter);
    }

    @Override
    public void setRefresh(String right) {
        Toast.makeText(this,right,Toast.LENGTH_LONG ).show();
        finish();

    }



}
