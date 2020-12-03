package com.example.auraflick;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterFav extends FragmentStatePagerAdapter {
    int NumTabs;

    Context c;

    public PagerAdapterFav(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.NumTabs = NumOfTabs;
    }

    public void setValues(Context c) {
        this.c = c;
    }

    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                FavoritesTabMovies tab1 = new FavoritesTabMovies();
                return tab1;
            case 1:
                FavoritesTabTV tab2 = new FavoritesTabTV();
                return tab2;
            default:
                return null;
        }
    }

    public int getCount() {
        return NumTabs;
    }
}
