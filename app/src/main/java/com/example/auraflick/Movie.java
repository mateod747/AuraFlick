package com.example.auraflick;

import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Movie {
    private String name;
    private int image;
    private String year;
    private String type;
    private boolean check;

    public Movie(String name, String year, int image, String type, boolean check) {
        this.name = name;
        this.image = image;
        this.year = year;
        this.type = type;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
