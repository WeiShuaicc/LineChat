package com.demo.demo.demo.activity;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.demo.demo.demo.R;
import com.demo.demo.demo.adapter.ListAdapter;
import com.demo.demo.demo.base.BaseActivity;
import com.demo.demo.demo.databinding.ActivityReadBinding;
import com.demo.demo.demo.presenter.ReadPresenter;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.ReadViews;

import java.util.List;

public class ReadActivity extends BaseActivity<ReadPresenter> implements ReadViews {

    ActivityReadBinding binding;

    ListAdapter adapter;

    List<SQData> list;

    @Override
    protected ReadPresenter getPresenter() {
        return new ReadPresenter(this);
    }



    @Override
    protected void getBinding() {
        binding= DataBindingUtil.setContentView(this,R.layout.activity_read);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        binding.lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(ReadActivity.this,"当前postition"+position,Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.dia_log_read,
                        (ViewGroup) findViewById(R.id.ll_dia));

                TextView tv_num,tv_str,tv_date;
                tv_date= (TextView) layout.findViewById(R.id.tv_date_logs);
                tv_num= (TextView) layout.findViewById(R.id.tv_num_logs);
                tv_str= (TextView) layout.findViewById(R.id.tv_str_logs);
                tv_date.setText(list.get(position).getData_time());
                tv_num.setText(""+list.get(position).getNum());
                tv_str.setText(list.get(position).getStr());
                new AlertDialog.Builder(ReadActivity.this).setView(layout)
                       .show();
            }
        });


    }

    @Override
    protected void initData() {
        super.initData();
        presenter.getData();

    }

    @Override
    public void resultData(List<SQData> list) {
        this.list=list;
        adapter=new ListAdapter(ReadActivity.this,list);
        binding.lvData.setAdapter(adapter);
    }
}
