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

public class FavoritesTabMovies extends Fragment {

    ArrayList<Movie> movies;
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fav_movies, container, false);

        lv = rootView.findViewById(R.id.lvMovies);

        CustomAdapterFav adapter = new CustomAdapterFav(this.getActivity(),getMovies());
        lv.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<Movie> getMovies() {
        GlobalApplication app = ((GlobalApplication)getActivity().getApplicationContext());
        movies = app.getMovies();
        return movies;
    }
}
