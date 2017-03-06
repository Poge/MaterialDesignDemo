package com.example.poge.materialdesigndemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private MyApp mApp;
    private NavigationView mNaviView;
    private FloatingActionButton fab;
    private int[] resids={R.drawable.apple,R.drawable.banana,R.drawable.cherry,R.drawable.grape,R.drawable.mango,R.drawable.orange,
            R.drawable.pear,R.drawable.pineapple,R.drawable.strawberry,R.drawable.watermelon};
    private RecyclerView recycleView;
    private FruitAdapter fruitAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Hi");
        mToolbar.setSubtitle("Poge");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setSubtitleTextColor(Color.GREEN);
        mToolbar.setTitleTextColor(Color.GREEN);
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        if (bar!=null){
//            bar.setDisplayHomeAsUpEnabled(true);
        }
//        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });

        mNaviView = (NavigationView) findViewById(R.id.navi);
        mNaviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                return true;
            }
        });
        mNaviView.setItemTextColor(null);
        mNaviView.setItemIconTintList(null);
//        mNaviView.getMenu().getItem(0).setChecked(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "poge", Snackbar.LENGTH_SHORT).setAction("goto", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "KG", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.GREEN);
                changeSnackbar(snackbar);
                snackbar.show();
            }
        });

        String[] array = getResources().getStringArray(R.array.fruits);
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        for (int i=0;i<array.length;i++){
            list.add(new Fruit(array[i],resids[i]));
        }

        recycleView = (RecyclerView) findViewById(R.id.recyler);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        fruitAdapter = new FruitAdapter(list);
        recycleView.setAdapter(fruitAdapter);

    }



    private void changeSnackbar(Snackbar sb){
        View view = sb.getView();
        ((TextView)view.findViewById(R.id.snackbar_text)).setTextColor(Color.GREEN);
        Snackbar.SnackbarLayout layout=(Snackbar.SnackbarLayout)view;
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity= Gravity.CENTER_VERTICAL;
        layout.addView(iv,0,layoutParams);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();


        return super.onOptionsItemSelected(item);
    }
}
