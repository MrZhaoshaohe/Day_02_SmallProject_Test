package com.example.administrator.day_02_smallproject_test.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.administrator.day_02_smallproject_test.R;
import com.example.administrator.day_02_smallproject_test.bean.Tab;
import com.example.administrator.day_02_smallproject_test.fragment.CreatFragment;
import com.example.administrator.day_02_smallproject_test.fragment.FirstFragment;
import com.example.administrator.day_02_smallproject_test.fragment.LocalFragment;
import com.example.administrator.day_02_smallproject_test.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private FrameLayout realcontent;
    private FrameLayout tabcontent;
    private FragmentTabHost tabhost;
    List<Tab> tabList =new ArrayList<>();
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

        Tab firsttab = new Tab(R.drawable.first_item, "首页", FirstFragment.class);
        Tab creattab = new Tab(R.drawable.creat_item, "定制", CreatFragment.class);
        Tab loacltab = new Tab(R.drawable.local_item, "当地玩乐", LocalFragment.class);
        Tab minetab = new Tab(R.drawable.mine_item, "我的", MineFragment.class);

        tabList.add(firsttab);
        tabList.add(creattab);
        tabList.add(loacltab);
        tabList.add(minetab);


        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabhost.setup(this, getSupportFragmentManager(), R.id.realcontent);
        mInflater = LayoutInflater.from(this);


        //通过循环实例化一个个TabSpec
        //并调用其中setIndicator方法
        //然后将TabSpec加到TabHost中
        for (Tab tab  :tabList) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(String.valueOf(tab.getName()));
            tabSpec.setIndicator(buildView(tab));
            tabhost.addTab(tabSpec,tab.getFrament(), null);
        }

        //通过这行代码可以去除掉底部菜单5个图表之间的分割线
        tabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);    }

    //设置Indicator中的View
    private View buildView(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView Tab_img = (ImageView) view.findViewById(R.id.tab_img);
        TextView Tab_txt = (TextView) view.findViewById(R.id.tab_txt);

        Tab_img.setBackgroundResource(tab.getImage());
        Tab_txt.setText(tab.getName());
        return view;


    }

    private void initView() {
        realcontent = (FrameLayout) findViewById(R.id.realcontent);
        tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }
}
