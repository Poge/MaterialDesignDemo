package com.example.poge.materialdesigndemo;

import android.app.Application;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Anpo on 2017/3/1.
 */
public class MyApp extends Application {

    public static Toast MyToast;
    @Override
    public void onCreate() {
        super.onCreate();
        MyToast=new Toast(this);
        MyToast.setView(new TextView(this));
    }
}
