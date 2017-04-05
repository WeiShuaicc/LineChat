package com.demo.demo.demo.adapter;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.demo.demo.R;
import com.demo.demo.demo.units.SQData;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2/002.
 */

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<SQData> list;


    public ListAdapter(Context context, List<SQData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(context, R.layout.list_items, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_date.setText(list.get(i).getData_time());
        holder.tv_num.setText(String.valueOf(list.get(i).getNum()));
        return view;
    }

    class ViewHolder {
        public TextView tv_date;
        public TextView tv_num;

        public ViewHolder(View view) {
            tv_date = (TextView) view.findViewById(R.id.tv_date_record);
            tv_num = (TextView) view.findViewById(R.id.tv_num_record);
        }
    }
}
