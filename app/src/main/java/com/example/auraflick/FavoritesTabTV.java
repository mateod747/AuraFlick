package com.example.auraflick;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritesTabTV extends Fragment {

    ArrayList<Movie> shows;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fav_tv, container, false);

        final ListView lv = rootView.findViewById(R.id.lvTV);

        final CustomAdapterFav adapter = new CustomAdapterFav(this.getActivity(),getTV());
        lv.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<Movie> getTV() {
        GlobalApplication app = ((GlobalApplication)getActivity().getApplicationContext());
        shows = app.getShows();
        return shows;
    }

}
