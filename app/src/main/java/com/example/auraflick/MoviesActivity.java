package com.example.auraflick;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MoviesActivity extends AppCompatActivity {

    private boolean moviecheck, tvcheck;
    private String feel;
    static ViewPager pager;

    public static Context getContext() {
        return getContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        Intent intent = getIntent();

        boolean first = intent.getBooleanExtra("moviechecked", false);
        boolean second = intent.getBooleanExtra("tvchecked", false);
        String feeling = intent.getStringExtra("feel");

        moviecheck = first;
        tvcheck = second;
        feel = feeling;

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Suggestions"));
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"), Color.parseColor("#ffffff"));

        final SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        adapter.setValues(moviecheck, tvcheck, feel, this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        pager = viewPager;

        viewPager.setPagingEnabled(false);
        tabLayout.getTabAt(0).setIcon(R.drawable.movie2);
        tabLayout.getTabAt(1).setIcon(R.drawable.info1);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getText().equals("Suggestions")) {
                    tab.setIcon(R.drawable.movie2);
                } else {
                    tab.setIcon(R.drawable.info2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if(tab.getText().equals("Suggestions")) {
                    tab.setIcon(R.drawable.movie1);
                } else {
                    tab.setIcon(R.drawable.info1);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

        }
    });
    }
    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 1) {
            pager.setCurrentItem(0,true);
        } else{
            finish();
        }
    }
}
