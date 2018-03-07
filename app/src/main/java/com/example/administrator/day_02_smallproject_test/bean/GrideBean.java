package com.example.administrator.day_02_smallproject_test.bean;

/**
 * Created by Administrator on 2018/3/2.
 */

public class GrideBean {

    private int img;
    private String name;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GrideBean(int img, String name) {

        this.img = img;
        this.name = name;
    }
}
