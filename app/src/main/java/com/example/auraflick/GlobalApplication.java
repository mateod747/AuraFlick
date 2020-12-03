package com.example.auraflick;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GlobalApplication extends Application {

    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Movie> shows = new ArrayList<>();

    public Context getContext() {
        return getApplicationContext();
    }

    public void setMovieArray(Movie movie) {
        int br = 0;
        for(int i=0; i < movies.size(); i++) {
            if(movie.getName().contains(movies.get(i).getName())) {
                br++;
            }
        }
        if(br==0) movies.add(movie);
        saveData(movies, "pauseMovies");
    }

    public void setTVArray(Movie movie) {
        int br = 0;
        for(int i=0; i < shows.size(); i++) {
            if(movie.getName().contains(shows.get(i).getName())) {
                br++;
            }
        }
        if(br==0) shows.add(movie);
        saveData(shows, "pauseShows");
    }

    public void removeMovie(String name) {
        for(int i=0; i<movies.size(); i++) {
            if(movies.get(i).getName().equals(name)) {
                movies.remove(i);
            }
        }
        saveData(movies, "pauseMovies");
    }

    public void removeShow(String name) {
        for(int i=0; i<shows.size(); i++) {
            if(shows.get(i).getName().equals(name)) {
                shows.remove(i);
            }
        }
        saveData(shows, "pauseShows");
    }

    public ArrayList<Movie> getMovies() {
        return loadData("pauseMovies");
    }

    public ArrayList<Movie> getShows() {
        return loadData("pauseShows");
    }

    public ArrayList<Movie> getAll() {
        ArrayList<Movie> all = new ArrayList<>();

        for(int i=0; i<movies.size(); i++) {
            all.add(getMovies().get(i));
        }

        for(int i=0; i<shows.size(); i++) {
            all.add(getShows().get(i));
        }

        return all;
    }

    private void saveData(ArrayList<Movie> list, String key) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    private ArrayList<Movie> loadData(String key) {
        ArrayList<Movie> list;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, null);
        Type type = new TypeToken<ArrayList<Movie>>() {}.getType();
        list = gson.fromJson(json, type);

        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    public void saveChecks(boolean[] array, String key) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(int i=0;i<array.length;i++) {
            editor.putBoolean(key+i, array[i]);
        }
        editor.putInt(key+"size",array.length);
        editor.apply();
    }

    public boolean[] loadChecks(String key, int size) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        int br = sharedPreferences.getInt(key+"size", size);
        boolean[] checks = new boolean[br];
        for(int i=0; i<br; i++) {
            checks[i] = sharedPreferences.getBoolean(key+i, false);
        }
        return checks;
        }
    }
