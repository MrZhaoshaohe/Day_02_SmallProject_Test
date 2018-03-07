package com.example.administrator.day_02_smallproject_test.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day_02_smallproject_test.R;
import com.example.administrator.day_02_smallproject_test.activity.MapActivity;
import com.example.administrator.day_02_smallproject_test.adapter.ListAdapter;
import com.example.administrator.day_02_smallproject_test.adapter.RecyAdapter;
import com.example.administrator.day_02_smallproject_test.bean.ApiService;
import com.example.administrator.day_02_smallproject_test.bean.Constant;
import com.example.administrator.day_02_smallproject_test.bean.GrideBean;
import com.example.administrator.day_02_smallproject_test.bean.User;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Banner banner;
    private GridView mgridview;
    private RecyclerView lv_recy;
    private List<GrideBean> grideBeanList;
    private List<User.ResultBean.DataBean> beanList;
    private TextView txt_map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_first, container, false);
        initView(inflate);
        initBannerData();
        initGridViewData();
        initRecyData();
        initListener();
        return inflate;
    }

    private void initListener() {



        txt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getActivity(),MapActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initRecyData() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<User> call = apiService.getDataUrl(Constant.URL);
        call.enqueue(new Callback<User>() {


            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                beanList = response.body().getResult().getData();
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                lv_recy.setLayoutManager(manager);
                RecyAdapter adapter = new RecyAdapter(beanList, getActivity());
                lv_recy.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void initGridViewData() {

        grideBeanList = new ArrayList<>();
        grideBeanList.add(new GrideBean(R.mipmap.q, "自由行"));
        grideBeanList.add(new GrideBean(R.mipmap.w, "机票"));
        grideBeanList.add(new GrideBean(R.mipmap.r, "签证"));
        grideBeanList.add(new GrideBean(R.mipmap.t, "目的地参团"));
        grideBeanList.add(new GrideBean(R.mipmap.s, "半自由行"));
        grideBeanList.add(new GrideBean(R.mipmap.f, "参团"));
        grideBeanList.add(new GrideBean(R.mipmap.g, "问票"));
        grideBeanList.add(new GrideBean(R.mipmap.h, "其他"));

        ListAdapter adapter = new ListAdapter(grideBeanList, getActivity());
        mgridview.setAdapter(adapter);


    }

    private void initBannerData() {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/10639/20141105163614-1223118510.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/5744/cut-20141105163400-882181576.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/10642/cut-20141105163509-311046641.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic2/27226/cut-20141105163259-200124067.jpg/0");
        arrayList.add("http://pic.baike.soso.com/ugc/baikepic/31024/cut-20140303113915-424758572.jpg/0");

        List<String> list = new ArrayList<>();
        list.add("哈比");
        list.add("格雷");
        list.add("纳兹");
        list.add("露西");
        list.add("温蒂");
        banner.setImages(arrayList)
                .setDelayTime(2000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setImageLoader(new BitmapPicasso())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setBannerTitles(list)
                .start();


    }

    private void initView(View inflate) {
        banner = (Banner) inflate.findViewById(R.id.banner);
        mgridview = (GridView) inflate.findViewById(R.id.mgridview);
        lv_recy = (RecyclerView) inflate.findViewById(R.id.lv_recy);
        txt_map = (TextView) inflate.findViewById(R.id.txt_map);

    }

    class BitmapPicasso extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context).load((String) path).into(imageView);
        }
    }

}
