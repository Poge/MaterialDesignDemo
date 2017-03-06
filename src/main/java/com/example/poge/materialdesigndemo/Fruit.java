package com.example.poge.materialdesigndemo;

/**
 * Created by Anpo on 2017/3/6.
 */
public class Fruit {

    private String name;
    private int resId;

    public Fruit() {
    }

    public Fruit(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
