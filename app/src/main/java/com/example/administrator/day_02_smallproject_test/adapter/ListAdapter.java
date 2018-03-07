package com.example.administrator.day_02_smallproject_test.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day_02_smallproject_test.R;
import com.example.administrator.day_02_smallproject_test.bean.GrideBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/2.
 */

public class ListAdapter extends BaseAdapter {
    private List<GrideBean> grideBeanList;
    private Context context;

    public ListAdapter(List<GrideBean> grideBeanList, Context context) {
        this.grideBeanList = grideBeanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return grideBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            holder.img=(ImageView) convertView.findViewById(R.id.img);
            holder.tv_content= (TextView) convertView.findViewById(R.id.tab_txt);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageResource(grideBeanList.get(position).getImg());
        holder.tv_content.setText(grideBeanList.get(position).getName());

        return convertView;

    }

    class ViewHolder{

        ImageView img;
        TextView tv_content;
    }

}
