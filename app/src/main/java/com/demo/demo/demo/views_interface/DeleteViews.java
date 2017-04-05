package com.demo.demo.demo.views_interface;

import com.demo.demo.demo.base.BaseView;
import com.demo.demo.demo.units.SQData;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28/028.
 */
public interface DeleteViews extends BaseView {
    void resultData(List<SQData> list);

    void setRefresh(String right);
}
