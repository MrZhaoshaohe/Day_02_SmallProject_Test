package com.example.administrator.day_02_smallproject_test.bean;

/**
 * Created by Administrator on 2018/3/2.
 */

public class Tab {

    private int image;
    private String name;
    private Class Frament;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getFrament() {
        return Frament;
    }

    public void setFrament(Class frament) {
        Frament = frament;
    }

    public Tab(int image, String name, Class frament) {

        this.image = image;
        this.name = name;
        Frament = frament;
    }
}
