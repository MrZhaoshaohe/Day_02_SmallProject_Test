package com.example.administrator.day_02_smallproject_test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.day_02_smallproject_test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DongnanFragment extends Fragment {


    public DongnanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dongnan, container, false);
    }

}
