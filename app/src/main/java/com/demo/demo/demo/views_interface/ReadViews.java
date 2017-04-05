package com.demo.demo.demo.views_interface;

import com.demo.demo.demo.base.BaseView;
import com.demo.demo.demo.units.SQData;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27/027.
 */
public interface ReadViews extends BaseView{
    void resultData(List<SQData> list);
}
