package com.demo.demo.demo.presenter;

import android.util.Log;

import com.demo.demo.demo.base.BasePresenter;
import com.demo.demo.demo.sqlite.DataDb;
import com.demo.demo.demo.units.SQData;
import com.demo.demo.demo.views_interface.DeleteViews;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28/028.
 */
public class DeletePresenter extends BasePresenter<DeleteViews> {
    public DeletePresenter(DeleteViews baseview) {
        super(baseview);
    }

    public void getData() {
        List<SQData> list= DataDb.instance().query();
        getView().resultData(list);
    }

    public void getEvent(int list) {
        String right="";
        Log.e("DeletePresenter",list+"");
       int i= DataDb.instance().delete(list);
        Log.e("DeletePresenter",i+"");
        if (i==0){
            right="删除失败";
        }else{
            right="删除成功";
        }
        getView().setRefresh(right);
    }
}
