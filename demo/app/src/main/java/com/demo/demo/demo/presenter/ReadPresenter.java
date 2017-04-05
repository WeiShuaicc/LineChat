package com.demo.demo.demo.presenter;

import com.demo.demo.demo.base.BasePresenter;
import com.demo.demo.demo.sqlite.DataDb;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.ReadViews;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27/027.
 */
public class ReadPresenter extends BasePresenter<ReadViews>{
    public ReadPresenter(ReadViews baseview) {
        super(baseview);
    }

    public void getData() {
        List<SQData> list= DataDb.instance().query();
        getView().resultData(list);

    }
}
