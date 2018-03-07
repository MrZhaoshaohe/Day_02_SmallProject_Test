package com.example.administrator.day_02_smallproject_test.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.day_02_smallproject_test.R;
import com.example.administrator.day_02_smallproject_test.adapter.FrPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreatFragment extends Fragment {

    private TabLayout tab;
    private ViewPager vp;
    private List<Fragment> fragmentList;
    private List<String> stringList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_creat, container, false);
        initView(inflate);
        initData();
        initAdapter();
        return inflate;


    }

    private void initAdapter() {

        stringList = new ArrayList<>();
        stringList.add("欧美");
        stringList.add("东南亚");
        stringList.add("海岛");

        FrPageAdapter adapter =new FrPageAdapter(getActivity().getSupportFragmentManager(),fragmentList,stringList);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

    private void initData() {



        fragmentList = new ArrayList<>();
        fragmentList.add(new OumeiFragment());
        fragmentList.add(new DongnanFragment());
        fragmentList.add(new HaidaoFragment());
    }

    private void initView(View inflate) {
        tab = (TabLayout) inflate.findViewById(R.id.tab);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
    }
}
