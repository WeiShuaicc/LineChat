package com.demo.demo.demo.presenter;

import com.demo.demo.demo.base.BasePresenter;
import com.demo.demo.demo.sqlite.DataDb;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.LinesViews;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/7/007.
 */
public class LinesPresenter extends BasePresenter<LinesViews> {


    public LinesPresenter(LinesViews baseview) {
        super(baseview);
    }

    public void getData() {
        List<SQData> list= DataDb.instance().query();
        initData(list);
    }

    private void initData(List<SQData> list) {
        String[] date=new String[list.size()+1];
        int[] num=new int[list.size()+1];
        date[0]="0";
        num[0]=0;
        for (int i=0;i<list.size();i++){
            date[i+1]=list.get(i).getData_time();
            num[i+1]=list.get(i).getNum();
        }
        getView().resultData(date,num);
    }
}
