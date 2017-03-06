package com.example.poge.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Anpo on 2017/3/6.
 */
public class FriutActivity extends AppCompatActivity {

    public final static String IMG="img_fruit";
    private ImageView imgFruit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_friut);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_fruit);
        setSupportActionBar(toolbar);
        imgFruit = (ImageView) findViewById(R.id.img_fruit);
        Intent intent = getIntent();
        if(intent!=null){
            int resId = intent.getIntExtra(IMG, 0);
            Glide.with(this).load(resId).into(imgFruit);
        }
    }

}
