package com.example.administrator.day_02_smallproject_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day_02_smallproject_test.R;
import com.example.administrator.day_02_smallproject_test.bean.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/2.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User.ResultBean.DataBean> beanList;
    private Context context;

    public RecyAdapter(List<User.ResultBean.DataBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.recy_item, parent, false);
        RecyclerView.ViewHolder holder = new FirstViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((FirstViewHolder)holder).title.setText(beanList.get(position).getDate());
        Picasso.with(context).load(beanList.get(position).getThumbnail_pic_s()).into(((FirstViewHolder) holder).img);

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class FirstViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;

        public FirstViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }
}
