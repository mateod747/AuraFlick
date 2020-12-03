package com.example.auraflick;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int NumTabs;
    boolean first, second;
    String feeling;

    Context c;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.NumTabs = NumOfTabs;
    }

    public void setValues(boolean first, boolean second, String feeling, Context c) {
        this.first = first;
        this.second = second;
        this.feeling = feeling;
        this.c = c;
    }

    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                Bundle bundle = new Bundle();
                bundle.putBoolean("moviecheck", first);
                bundle.putBoolean("tvcheck", second);
                bundle.putString("feel", feeling);
                tab1.setArguments(bundle);
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();

                return tab2;
            default:
                return null;
        }
    }

    public int getCount() {
        return NumTabs;
    }
}
