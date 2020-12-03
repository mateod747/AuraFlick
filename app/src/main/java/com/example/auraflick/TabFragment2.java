package com.example.auraflick;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class TabFragment2 extends Fragment {
    TextView nameMovie, descMovie;
    ImageView posterMovie;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_2, container, false);

        nameMovie = rootView.findViewById(R.id.tvMovie);
        descMovie = rootView.findViewById(R.id.tvDescription);
        posterMovie = rootView.findViewById(R.id.ivPoster);

        return rootView;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            SharedPreferences mPrefs = getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
            String name = mPrefs.getString("name2", "");
            String desc = mPrefs.getString("desc2", "");
            int image = mPrefs.getInt("pic2", 0);

            nameMovie.setText(name);
            descMovie.setText(desc);
            posterMovie.setImageResource(image);
        }
    }
}
