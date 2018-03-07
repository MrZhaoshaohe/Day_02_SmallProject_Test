package com.example.administrator.day_02_smallproject_test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.day_02_smallproject_test.R;
import com.example.administrator.day_02_smallproject_test.adapter.RecyAdapter;
import com.example.administrator.day_02_smallproject_test.bean.ApiService;
import com.example.administrator.day_02_smallproject_test.bean.Constant;
import com.example.administrator.day_02_smallproject_test.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class OumeiFragment extends Fragment {


    private List<User.ResultBean.DataBean> beanList;
    private RecyclerView lv_recy;

    public OumeiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_oumei, container, false);
        initView(inflate);
        initData();
        return inflate;


    }

    private void initData() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.getDataUrl(Constant.URL);
        call.enqueue(new Callback<User>() {


            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                beanList = response.body().getResult().getData();
                LinearLayoutManager manager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
                lv_recy.setLayoutManager(manager);
                RecyAdapter adapter =new RecyAdapter(beanList,getActivity());
                lv_recy.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


}

    private void initView(View inflate) {
        lv_recy = (RecyclerView) inflate.findViewById(R.id.lv_recy);
    }
}
