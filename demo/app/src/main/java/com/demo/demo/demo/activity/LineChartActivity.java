package com.demo.demo.demo.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;

import com.demo.demo.demo.R;
import com.demo.demo.demo.base.BaseActivity;
import com.demo.demo.demo.databinding.ActivityLineChartBinding;
import com.demo.demo.demo.presenter.LinesPresenter;
import com.demo.demo.demo.views_interface.LinesViews;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;

public class LineChartActivity extends BaseActivity<LinesPresenter> implements LinesViews {

    ActivityLineChartBinding binding;
    String[] date;
    int[] num;

    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();

    @Override
    protected LinesPresenter getPresenter() {
        return new LinesPresenter(this);
    }

    @Override
    protected void getBinding() {
        binding=DataBindingUtil.setContentView(this, R.layout.activity_line_chart);

    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.getData();


    }

    @Override
    protected void initEvent() {
        super.initEvent();
    }

    @Override
    public void resultData(String[] date, int[] num) {
        this.date=date;
        this.num=num;
        getAxisXLables();//获取x轴的标注
        getAxisPoints();//获取坐标点
        initLineChart();//初始化
    }

    public void getAxisXLables() {
        for (int i = 0; i < date.length; i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(date[i]));
        }
    }

    public void getAxisPoints() {
        for (int i = 0; i < num.length; i++) {
            mPointValues.add(new PointValue(i, num[i]));
        }

    }

    private void initLineChart() {
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  //折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平滑
//	    line.setStrokeWidth(3);//线条的粗细，默认是3
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注
//		line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);  //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
//	    axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setTextColor(Color.parseColor("#D6D6D9"));//灰色

//	    axisX.setName("未来几天的天气");  //表格名称
        axisX.setTextSize(11);//设置字体大小
        axisX.setMaxLabelChars(7); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
//	    data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线


        Axis axisY = new Axis();  //Y轴
        axisY.setName("");//y轴标注
        axisY.setTextSize(11);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边
        //设置行为属性，支持缩放、滑动以及平移
        binding.lineChart.setInteractive(true);
        binding.lineChart.setZoomType(ZoomType.HORIZONTAL);  //缩放类型，水平
        binding.lineChart.setMaxZoom((float) 3);//缩放比例
        binding.lineChart.setLineChartData(data);
        binding.lineChart.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(binding.lineChart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        binding.lineChart.setCurrentViewport(v);
    }
}
