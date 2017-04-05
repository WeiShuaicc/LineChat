package com.demo.demo.demo.presenter;

import android.content.Context;
import android.util.Log;

import com.demo.demo.demo.base.BasePresenter;
import com.demo.demo.demo.sqlite.DataDb;
import com.demo.demo.demo.views_interface.WriteViews;

/**
 * Created by Administrator on 2017/2/25/025.
 */
public class WritePresenter extends BasePresenter<WriteViews> {

    public WritePresenter(WriteViews baseview) {
        super(baseview);

    }

    public void writer(String str, int num, String date_time) {
//        Log.e("Write",str);
//        Log.e("Write",""+num);
//        Log.e("Write",date_time);
        DataDb.instance().insert(date_time,str,num);
        getView().result();

    }
}
