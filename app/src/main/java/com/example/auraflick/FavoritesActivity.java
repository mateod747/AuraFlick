package com.example.auraflick;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_fav);
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        tabLayout.addTab(tabLayout.newTab().setText("TV Shows"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"), Color.parseColor("#ffffff"));

        final SwipeViewPager viewPager = (SwipeViewPager) findViewById(R.id.pager_fav);
        final PagerAdapterFav adapter = new PagerAdapterFav(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        adapter.setValues(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setPagingEnabled(false);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
