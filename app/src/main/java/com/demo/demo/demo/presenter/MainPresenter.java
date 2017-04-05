package com.demo.demo.demo.presenter;

import android.util.Log;

import com.demo.demo.demo.base.BasePresenter;
import com.demo.demo.demo.sqlite.DataDb;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/25/025.
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView baseview) {
        super(baseview);

    }

}
