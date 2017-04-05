package com.demo.demo.demo.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.demo.demo.demo.sqlite.DatabaseHelper;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/2/24/024.
 */
public class BasePresenter<V extends BaseView> {

    protected Reference<V> view;

    protected SQLiteDatabase db;

    DatabaseHelper hp;

    public BasePresenter(V baseview){
        view=new WeakReference<V>(baseview);
    }

    public V getView(){
        return view.get();
    }
}
