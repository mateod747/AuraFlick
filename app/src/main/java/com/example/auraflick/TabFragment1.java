package com.example.auraflick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


import static android.content.Context.MODE_PRIVATE;

public class TabFragment1 extends Fragment {

    private boolean moviecheck, tvcheck;
    private String feeling;

    private String key;

    private void saveData(ArrayList<Movie> list, String key) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    private void saveDesc(String list, String key) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, list);
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

    public ArrayList<Movie> normalMovies() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("normalMovies")) {

            movie=new Movie("Terminator 2: Judgment Day", "1991", R.drawable.terminator2,"Movie", false);
            normal.add(movie);

            movie=new Movie("Die Hard", "1989", R.drawable.diehard,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Dark Night", "2008", R.drawable.thedarknight,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Lord of the Rings: The Return of the King", "2003", R.drawable.lotr,"Movie", false);
            normal.add(movie);

            movie=new Movie("Oldboy", "2003", R.drawable.oldboy,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Matrix", "1999", R.drawable.matrix,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Legend of Drunken Master", "1994", R.drawable.drunkenmaster,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Empire Strikes Back", "1980", R.drawable.empirestrikesback,"Movie", false);
            normal.add(movie);

            movie=new Movie("First Blood", "1982", R.drawable.firstblood,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Bourne Identity", "2002 ", R.drawable.bourneidentity,"Movie", false);
            normal.add(movie);

            saveData(normal, "normalMovies");

            return loadData("normalMovies");
        } else {
            return loadData("normalMovies");
        }
    }

    public ArrayList<Movie> normalTV() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("normalTV")) {

            movie=new Movie("Band of Brothers", "2001", R.drawable.bandofbrothers,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Breaking Bad", "2008 - 2013", R.drawable.breakingbad,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Game of Thrones", "2011 -", R.drawable.gameofthrones,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Rick and Morty", "2013 -", R.drawable.rockandmorty,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Sherlock", "2010 -", R.drawable.sherlock,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Billions", "2016 -", R.drawable.billions,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Peaky Blinders", "2013 -", R.drawable.peakyblinders,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Daredevil", "2015 - 2018", R.drawable.daredevil,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Punisher", "2017 -", R.drawable.thepunisher,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Vikings", "2013 -", R.drawable.vikings,"TV Show", false);
            normal.add(movie);

            saveData(normal, "normalTV");

            return loadData("normalTV");
        } else {
            return loadData("normalTV");
        }
    }

    public ArrayList<Movie> normalBoth() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("normalBoth")) {

            movie=new Movie("Terminator 2: Judgment Day", "1991", R.drawable.terminator2,"Movie", false);
            normal.add(movie);

            movie=new Movie("Die Hard", "1989", R.drawable.diehard,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Dark Night", "2008", R.drawable.thedarknight,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Lord of the Rings: The Return of the King", "2003", R.drawable.lotr,"Movie", false);
            normal.add(movie);

            movie=new Movie("Oldboy", "2003", R.drawable.oldboy,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Matrix", "1999", R.drawable.matrix,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Legend of Drunken Master", "1994", R.drawable.drunkenmaster,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Empire Strikes Back", "1980", R.drawable.empirestrikesback,"Movie", false);
            normal.add(movie);

            movie=new Movie("First Blood", "1982", R.drawable.firstblood,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Bourne Identity", "2002 ", R.drawable.bourneidentity,"Movie", false);
            normal.add(movie);

            movie=new Movie("Band of Brothers", "2001", R.drawable.bandofbrothers,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Breaking Bad", "2008 - 2013", R.drawable.breakingbad,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Game of Thrones", "2011 -", R.drawable.gameofthrones,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Rick and Morty", "2013 -", R.drawable.rockandmorty,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Sherlock", "2010 -", R.drawable.sherlock,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Billions", "2016 -", R.drawable.billions,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Peaky Blinders", "2013 -", R.drawable.peakyblinders,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Daredevil", "2015 - 2018", R.drawable.daredevil,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Punisher", "2017 -", R.drawable.thepunisher,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Vikings", "2013 -", R.drawable.vikings,"TV Show", false);
            normal.add(movie);

            saveData(normal, "normalBoth");

            return loadData("normalBoth");
        } else {
            return loadData("normalBoth");
        }
    }

    public ArrayList<Movie> sadMovies() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("sadMovies")) {

            movie=new Movie("Up", "2009", R.drawable.up,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Wife", "2017", R.drawable.thewife,"Movie", false);
            normal.add(movie);

            movie=new Movie("Remember Me", "2010", R.drawable.rememberme,"Movie", false);
            normal.add(movie);

            movie=new Movie("Romeo and Juliet", "1996", R.drawable.up,"Movie", false);
            normal.add(movie);

            movie=new Movie("Lion", "2016", R.drawable.lion,"Movie", false);
            normal.add(movie);

            movie=new Movie("Room", "2015", R.drawable.room,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Lion King", "1994", R.drawable.thelionking,"Movie", false);
            normal.add(movie);

            movie=new Movie("Manchester by the Sea", "2016", R.drawable.manchester,"Movie", false);
            normal.add(movie);

            movie=new Movie("Boyhood", "2014", R.drawable.boyhood,"Movie", false);
            normal.add(movie);

            movie=new Movie("Pearl Harbor", "2001", R.drawable.pearlharbor,"Movie", false);
            normal.add(movie);

            saveData(normal, "sadMovies");

            return loadData("sadMovies");
        } else {
            return loadData("sadMovies");
        }
    }

    public ArrayList<Movie> sadTV() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("sadTV")) {

            movie=new Movie("The Wire", "2002 - 2008", R.drawable.thewire,"TV Show", false);
            normal.add(movie);

            movie=new Movie("This Is Us", "2016 -", R.drawable.thisisus,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Handmaid's Tale", "2017 -", R.drawable.thehandmaidstale,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Parenthood", "2010 - 2015", R.drawable.parenthood,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Boy Meets World", "1993 - 2000", R.drawable.boymeetsworld,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Orange Is the New Black", "2013 -", R.drawable.orange,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Glee", "2009 - 2015", R.drawable.glee,"TV Show", false);
            normal.add(movie);

            movie=new Movie("A Million Little Things", "2018 -", R.drawable.millionlittlethings,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Broadchurch", "2013 - 2017", R.drawable.broadchurch,"TV Show", false);
            normal.add(movie);

            movie=new Movie("13 Reasons Why", "2017 -", R.drawable.reasonswhy,"TV Show", false);
            normal.add(movie);

            saveData(normal, "sadTV");

            return loadData("sadTV");
        } else {
            return loadData("sadTV");
        }
    }

    public ArrayList<Movie> sadBoth() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("sadBoth")) {

            movie=new Movie("Up", "2009", R.drawable.up,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Wife", "2017", R.drawable.thewife,"Movie", false);
            normal.add(movie);

            movie=new Movie("Remember Me", "2010", R.drawable.rememberme,"Movie", false);
            normal.add(movie);

            movie=new Movie("Romeo and Juliet", "1996", R.drawable.up,"Movie", false);
            normal.add(movie);

            movie=new Movie("Lion", "2016", R.drawable.lion,"Movie", false);
            normal.add(movie);

            movie=new Movie("Room", "2015", R.drawable.room,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Lion King", "1994", R.drawable.thelionking,"Movie", false);
            normal.add(movie);

            movie=new Movie("Manchester by the Sea", "2016", R.drawable.manchester,"Movie", false);
            normal.add(movie);

            movie=new Movie("Boyhood", "2014", R.drawable.boyhood,"Movie", false);
            normal.add(movie);

            movie=new Movie("Pearl Harbor", "2001", R.drawable.pearlharbor,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Wire", "2002 - 2008", R.drawable.thewire,"TV Show", false);
            normal.add(movie);

            movie=new Movie("This Is Us", "2016 -", R.drawable.thisisus,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Handmaid's Tale", "2017 -", R.drawable.thehandmaidstale,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Parenthood", "2010 - 2015", R.drawable.parenthood,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Boy Meets World", "1993 - 2000", R.drawable.boymeetsworld,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Orange Is the New Black", "2013 -", R.drawable.orange,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Glee", "2009 - 2015", R.drawable.glee,"TV Show", false);
            normal.add(movie);

            movie=new Movie("A Million Little Things", "2018 -", R.drawable.millionlittlethings,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Broadchurch", "2013 - 2017", R.drawable.broadchurch,"TV Show", false);
            normal.add(movie);

            movie=new Movie("13 Reasons Why", "2017 -", R.drawable.reasonswhy,"TV Show", false);
            normal.add(movie);

            saveData(normal, "sadBoth");

            return loadData("sadBoth");
        } else {
            return loadData("sadBoth");
        }
    }

    public ArrayList<Movie> funnyMovies() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("funnyMovies")) {

            movie=new Movie("Rough Night", "2017", R.drawable.roughnight,"Movie", false);
            normal.add(movie);

            movie=new Movie("Dumb and Dumber", "1994", R.drawable.dumbanddumber,"Movie", false);
            normal.add(movie);

            movie=new Movie("Girls Trip", "2017", R.drawable.girlstrip,"Movie", false);
            normal.add(movie);

            movie=new Movie("Borat", "2006", R.drawable.borat,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Dictator", "2012", R.drawable.thedictator,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Hangover", "2009", R.drawable.thehangover,"Movie", false);
            normal.add(movie);

            movie=new Movie("Ghostbusters", "1984", R.drawable.ghostbusters,"Movie", false);
            normal.add(movie);

            movie=new Movie("Happy Gilmore", "1996", R.drawable.happygilmore,"Movie", false);
            normal.add(movie);

            movie=new Movie("Shaun of the Dead", "2004", R.drawable.shaunofthedead,"Movie", false);
            normal.add(movie);

            movie=new Movie("Beverly Hills Cop", "1984", R.drawable.beverlyhillscop,"Movie", false);
            normal.add(movie);

            saveData(normal, "funnyMovies");

            return loadData("funnyMovies");
        } else {
            return loadData("funnyMovies");
        }
    }

    public ArrayList<Movie> funnyTV() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("funnyTV")) {

            movie=new Movie("The Office", "2005 - 2013", R.drawable.theoffice,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Parks and Recreation", "2009 - 2015", R.drawable.parks,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Friends", "1994 - 2004", R.drawable.friends,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Big Bang Theory", "2007 -", R.drawable.thebigbangtheory,"TV Show", false);
            normal.add(movie);

            movie=new Movie("How I Met Your Mother", "2005 - 2014", R.drawable.howimetyourmother,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Seinfeld", "1989 - 1998", R.drawable.seinfeld,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Modern Family", "2009 -", R.drawable.modernfamily,"TV Show", false);
            normal.add(movie);

            movie=new Movie("South Park", "1997 -", R.drawable.southpark,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Fresh Prince of Bel-Air", "1990 - 1996", R.drawable.thefreshprinceofbelair,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Two and a Half Men", "2003 - 2015", R.drawable.twoandahalfmen,"TV Show", false);
            normal.add(movie);

            saveData(normal, "funnyTV");

            return loadData("funnyTV");
        } else {
            return loadData("funnyTV");
        }
    }

    public ArrayList<Movie> funnyBoth() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("funnyBoth")) {

            movie=new Movie("Rough Night", "2017", R.drawable.roughnight,"Movie", false);
            normal.add(movie);

            movie=new Movie("Dumb and Dumber", "1994", R.drawable.dumbanddumber,"Movie", false);
            normal.add(movie);

            movie=new Movie("Girls Trip", "2017", R.drawable.girlstrip,"Movie", false);
            normal.add(movie);

            movie=new Movie("Borat", "2006", R.drawable.borat,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Dictator", "2012", R.drawable.thedictator,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Hangover", "2009", R.drawable.thehangover,"Movie", false);
            normal.add(movie);

            movie=new Movie("Ghostbusters", "1984", R.drawable.ghostbusters,"Movie", false);
            normal.add(movie);

            movie=new Movie("Happy Gilmore", "1996", R.drawable.happygilmore,"Movie", false);
            normal.add(movie);

            movie=new Movie("Shaun of the Dead", "2004", R.drawable.shaunofthedead,"Movie", false);
            normal.add(movie);

            movie=new Movie("Beverly Hills Cop", "1984", R.drawable.beverlyhillscop,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Office", "2005 - 2013", R.drawable.theoffice,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Parks and Recreation", "2009 - 2015", R.drawable.parks,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Friends", "1994 - 2004", R.drawable.friends,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Big Bang Theory", "2007 -", R.drawable.thebigbangtheory,"TV Show", false);
            normal.add(movie);

            movie=new Movie("How I Met Your Mother", "2005 - 2014", R.drawable.howimetyourmother,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Seinfeld", "1989 - 1998", R.drawable.seinfeld,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Modern Family", "2009 -", R.drawable.modernfamily,"TV Show", false);
            normal.add(movie);

            movie=new Movie("South Park", "1997 -", R.drawable.southpark,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Fresh Prince of Bel-Air", "1990 - 1996", R.drawable.thefreshprinceofbelair,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Two and a Half Men", "2003 - 2015", R.drawable.twoandahalfmen,"TV Show", false);
            normal.add(movie);

            saveData(normal, "funnyBoth");

            return loadData("funnyBoth");
        } else {
            return loadData("funnyBoth");
        }
    }

    public ArrayList<Movie> scaryMovies() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("scaryMovies")) {

            movie=new Movie("Alien", "1979", R.drawable.alien,"Movie", false);
            normal.add(movie);

            movie=new Movie("Saw ", "2004", R.drawable.saw,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Ring", "2002", R.drawable.ring,"Movie", false);
            normal.add(movie);

            movie=new Movie("Paranormal Activity", "2007", R.drawable.paranormal,"Movie", false);
            normal.add(movie);

            movie=new Movie("It Follows", "2014", R.drawable.itfollows,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Blair Witch Project", "1999", R.drawable.blair,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Shining", "1980", R.drawable.theshining,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Texas Chainsaw Massacre", "1974", R.drawable.chainsaw,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Omen", "1976", R.drawable.theomen,"Movie", false);
            normal.add(movie);

            movie=new Movie("Hereditary", "2018", R.drawable.hereditary,"Movie", false);
            normal.add(movie);

            saveData(normal, "scaryMovies");

            return loadData("scaryMovies");
        } else {
            return loadData("scaryMovies");
        }
    }

    public ArrayList<Movie> scaryTV() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("scaryTV")) {

            movie=new Movie("Stranger Things", "2016 -", R.drawable.strangerthings,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Strain ", "2014 - 2017", R.drawable.strain,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Hannibal", "2013 - 2015", R.drawable.hannibal,"TV Show", false);
            normal.add(movie);

            movie=new Movie("American Horror Story", "2011 -", R.drawable.americanhorrorstory,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Invasion", "2005 - 2006", R.drawable.invasion,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Supernatural", "2005 -", R.drawable.supernatural,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Dark", "2017 -", R.drawable.dark,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Unsolved Mysteries", "1987 - 2010", R.drawable.unsolvedmysteries,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Twin Peaks", "1990 - 1991", R.drawable.twinpeaks,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The X-Files", "1993 -", R.drawable.xfiles,"TV Show", false);
            normal.add(movie);

            saveData(normal, "scaryTV");

            return loadData("scaryTV");
        } else {
            return loadData("scaryTV");
        }
    }

    public ArrayList<Movie> scaryBoth() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("scaryBoth")) {

            movie=new Movie("Alien", "1979", R.drawable.alien,"Movie", false);
            normal.add(movie);

            movie=new Movie("Saw ", "2004", R.drawable.saw,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Ring", "2002", R.drawable.ring,"Movie", false);
            normal.add(movie);

            movie=new Movie("Paranormal Activity", "2007", R.drawable.paranormal,"Movie", false);
            normal.add(movie);

            movie=new Movie("It Follows", "2014", R.drawable.itfollows,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Blair Witch Project", "1999", R.drawable.blair,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Shining", "1980", R.drawable.theshining,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Texas Chainsaw Massacre", "1974", R.drawable.chainsaw,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Omen", "1976", R.drawable.theomen,"Movie", false);
            normal.add(movie);

            movie=new Movie("Hereditary", "2018", R.drawable.hereditary,"Movie", false);
            normal.add(movie);

            movie=new Movie("Stranger Things", "2016 -", R.drawable.strangerthings,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Strain ", "2014 - 2017", R.drawable.strain,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Hannibal", "2013 - 2015", R.drawable.hannibal,"TV Show", false);
            normal.add(movie);

            movie=new Movie("American Horror Story", "2011 -", R.drawable.americanhorrorstory,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Invasion", "2005 - 2006", R.drawable.invasion,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Supernatural", "2005 -", R.drawable.supernatural,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Dark", "2017 -", R.drawable.dark,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Unsolved Mysteries", "1987 - 2010", R.drawable.unsolvedmysteries,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Twin Peaks", "1990 - 1991", R.drawable.twinpeaks,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The X-Files", "1993 -", R.drawable.xfiles,"TV Show", false);
            normal.add(movie);

            saveData(normal, "scaryBoth");

            return loadData("scaryBoth");
        } else {
            return loadData("scaryBoth");
        }
    }

    public ArrayList<Movie> mindblowMovies() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("mindblowMovies")) {

            movie=new Movie("Shutter Island", "2010", R.drawable.shutterisland,"Movie", false);
            normal.add(movie);

            movie=new Movie("Donnie Darko", "2001", R.drawable.donniedarko,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Machinist", "2004", R.drawable.themachinist,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Sixth Sense", "1999", R.drawable.sixthsense,"Movie", false);
            normal.add(movie);

            movie=new Movie("Fight Club", "1999", R.drawable.fightclub,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Illusionist", "2006", R.drawable.illusionist,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Butterfly Effect", "2004", R.drawable.thebutterflyeffect,"Movie", false);
            normal.add(movie);

            movie=new Movie("Inception", "2010", R.drawable.inception,"Movie", false);
            normal.add(movie);

            movie=new Movie("Interstellar", "2014", R.drawable.interstellar,"Movie", false);
            normal.add(movie);

            movie=new Movie("Split", "2016", R.drawable.split,"Movie", false);
            normal.add(movie);

            saveData(normal, "mindblowMovies");

            return loadData("mindblowMovies");
        } else {
            return loadData("mindblowMovies");
        }
    }

    public ArrayList<Movie> mindblowTV() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("mindblowTV")) {

            movie=new Movie("Mr. Robot", "2015 -", R.drawable.mrrobot,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Black Mirror", "2011 -", R.drawable.blackmirror,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Westworld", "2016 -", R.drawable.westworld,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Electric Dreams", "2017 -", R.drawable.electricdreams,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Sinner", "2017 -", R.drawable.thesinner,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Counterpart", "2017 -", R.drawable.counterpart,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Wayward Pines", "2015 - 2016", R.drawable.waywardpines,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Leftovers", "2014 - 2017", R.drawable.theleftovers,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Sense8", "2015 - 2018", R.drawable.sense8,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Lost", "2004 - 2010", R.drawable.lost,"TV Show", false);
            normal.add(movie);

            saveData(normal, "mindblowTV");

            return loadData("mindblowTV");
        } else {
            return loadData("mindblowTV");
        }
    }

    public ArrayList<Movie> mindblowBoth() {

        ArrayList<Movie> normal = new ArrayList<>();
        Movie movie;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);

        if(!sharedPreferences.contains("mindblowBoth")) {

            movie=new Movie("Shutter Island", "2010", R.drawable.shutterisland,"Movie", false);
            normal.add(movie);

            movie=new Movie("Donnie Darko", "2001", R.drawable.donniedarko,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Machinist", "2004", R.drawable.themachinist,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Sixth Sense", "1999", R.drawable.sixthsense,"Movie", false);
            normal.add(movie);

            movie=new Movie("Fight Club", "1999", R.drawable.fightclub,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Illusionist", "2006", R.drawable.illusionist,"Movie", false);
            normal.add(movie);

            movie=new Movie("The Butterfly Effect", "2004", R.drawable.thebutterflyeffect,"Movie", false);
            normal.add(movie);

            movie=new Movie("Inception", "2010", R.drawable.inception,"Movie", false);
            normal.add(movie);

            movie=new Movie("Interstellar", "2014", R.drawable.interstellar,"Movie", false);
            normal.add(movie);

            movie=new Movie("Split", "2016", R.drawable.split,"Movie", false);
            normal.add(movie);

            movie=new Movie("Mr. Robot", "2015 -", R.drawable.mrrobot,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Black Mirror", "2011 -", R.drawable.blackmirror,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Westworld", "2016 -", R.drawable.westworld,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Electric Dreams", "2017 -", R.drawable.electricdreams,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Sinner", "2017 -", R.drawable.thesinner,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Counterpart", "2017 -", R.drawable.counterpart,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Wayward Pines", "2015 - 2016", R.drawable.waywardpines,"TV Show", false);
            normal.add(movie);

            movie=new Movie("The Leftovers", "2014 - 2017", R.drawable.theleftovers,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Sense8", "2015 - 2018", R.drawable.sense8,"TV Show", false);
            normal.add(movie);

            movie=new Movie("Lost", "2004 - 2010", R.drawable.lost,"TV Show", false);
            normal.add(movie);

            saveData(normal, "mindblowBoth");

            return loadData("mindblowBoth");
        } else {
            return loadData("mindblowBoth");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);

        Bundle bundle = this.getArguments();

        saveAllDescriptions();

        boolean first = bundle.getBoolean("moviecheck", false);
        boolean second = bundle.getBoolean("tvcheck", false);
        String feel = bundle.getString("feel");

        this.moviecheck = first;
        this.tvcheck = second;
        this.feeling = feel;

        setKey();

        GlobalApplication app = ((GlobalApplication)getActivity().getApplicationContext());

        final ListView lv= rootView.findViewById(R.id.ListView);
        final CustomAdapter adapter = new CustomAdapter(this.getActivity(), app, getMovies(), key);
        lv.setAdapter(adapter);

        return rootView;
    }

    public void setKey() {
        if((moviecheck) && (!tvcheck)) {
            if(feeling.equals("happy")) {
                key = "normalMovies";
            } else if(feeling.equals("sad")) {
                key = "sadMovies";
            } else if(feeling.equals("scared")) {
                key = "scaryMovies";
            } else if(feeling.equals("mindblow")) {
                key = "mindblowMovies";
            } else if(feeling.equals("funny")) {
                key = "funnyMovies";
            } else {
                key = "normalMovies";
            }
        } else if((!moviecheck) && (tvcheck)) {
            if(feeling.equals("happy")) {
                key = "normalTV";
            } else if(feeling.equals("sad")) {
                key = "sadTV";
            } else if(feeling.equals("scared")) {
                key = "scaryTV";
            } else if(feeling.equals("mindblow")) {
                key = "mindblowTV";
            } else if(feeling.equals("funny")) {
                key = "funnyTV";
            } else {
                key = "normalTV";
            }
        } else if((moviecheck) && (tvcheck)) {
            if(feeling.equals("happy")) {
                key = "normalBoth";
            } else if(feeling.equals("sad")) {
                key = "sadBoth";
            } else if(feeling.equals("scared")) {
                key = "scaryBoth";
            } else if(feeling.equals("mindblow")) {
                key = "mindblowBoth";
            } else if(feeling.equals("funny")) {
                key = "funnyBoth";
            } else {
                key = "normalBoth";
            }
        } else {
            key = "normalMovies";
        }
    }

    private ArrayList<Movie> getMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        if((moviecheck) && (!tvcheck)) {
            if(feeling.equals("happy")) {
                key = "normalMovies";
                return normalMovies();
            } else if(feeling.equals("sad")) {
                key = "sadMovies";
                return sadMovies();
            } else if(feeling.equals("scared")) {
                key = "scaryMovies";
                return scaryMovies();
            } else if(feeling.equals("mindblow")) {
                key = "mindblowMovies";
                return mindblowMovies();
            } else if(feeling.equals("funny")) {
                key = "funnyMovies";
                return funnyMovies();
            } else {
                key = "normalMovies";
                return normalMovies();
            }
        } else if((!moviecheck) && (tvcheck)) {
            if(feeling.equals("happy")) {
                key = "normalTV";
                return normalTV();
            } else if(feeling.equals("sad")) {
                key = "sadTV";
                return sadTV();
            } else if(feeling.equals("scared")) {
                key = "scaryTV";
                return scaryTV();
            } else if(feeling.equals("mindblow")) {
                key = "mindblowTV";
                return mindblowTV();
            } else if(feeling.equals("funny")) {
                key = "funnyTV";
                return funnyTV();
            } else {
                key = "normalTV";
                return normalTV();
            }
        } else if((moviecheck) && (tvcheck)) {
            if(feeling.equals("happy")) {
                key = "normalBoth";
                return normalBoth();
            } else if(feeling.equals("sad")) {
                key = "sadBoth";
                return sadBoth();
            } else if(feeling.equals("scared")) {
                key = "scaryBoth";
                return scaryBoth();
            } else if(feeling.equals("mindblow")) {
                key = "mindblowBoth";
                return mindblowBoth();
            } else if(feeling.equals("funny")) {
                key = "funnyBoth";
                return funnyBoth();
            } else {
                key = "normalBoth";
                return normalBoth();
            }
        } else return normalMovies();
    }

    private void saveAllDescriptions() {
        saveDesc("When four lifelong friends travel to New Orleans for the annual Essence Festival, sisterhoods are rekindled, wild sides are rediscovered, and there's enough dancing, drinking, brawling, and romancing to make the Big Easy blush.", "Girls Trip");
        saveDesc("Things go terribly wrong for a group of girlfriends who hire a male stripper for a bachelorette party in Miami.","Rough Night");
        saveDesc("The cross-country adventures of 2 good-hearted but incredibly stupid friends.","Dumb and Dumber");
        saveDesc("Kazakh TV talking head Borat is dispatched to the United States to report on the greatest country in the world. With a documentary crew in tow, Borat becomes more interested in locating and marrying Pamela Anderson.","Borat");
        saveDesc("The heroic story of a dictator who risked his life to ensure that democracy would never come to the country he so lovingly oppressed.","The Dictator");
        saveDesc("Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding. ","The Hangover");
        saveDesc("Three former parapsychology professors set up shop as a unique ghost removal service.","Ghostbusters");
        saveDesc("A rejected hockey player puts his skills to the golf course to save his grandmother's house.","Happy Gilmore");
        saveDesc("A man's uneventful life is disrupted by the zombie apocalypse.","Shaun of the Dead");
        saveDesc("A freewheeling Detroit cop pursuing a murder investigation finds himself dealing with the very different culture of Beverly Hills.","Beverly Hills Cop");
        saveDesc("A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.","The Office");
        saveDesc("The absurd antics of an Indiana town's public officials as they pursue sundry projects to make their city a better place.","Parks and Recreation");
        saveDesc("Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan.","Friends");
        saveDesc("A woman who moves into an apartment across the hall from two brilliant but socially awkward physicists shows them how little they know about life outside of the laboratory.","The Big Bang Theory");
        saveDesc("A father recounts to his children, through a series of flashbacks, the journey he and his four best friends took leading up to him meeting their mother.","How I Met Your Mother");
        saveDesc("The continuing misadventures of neurotic New York City stand-up comedian Jerry Seinfeld and his equally neurotic New York City friends.","Seinfeld");
        saveDesc("Three different but related families face trials and tribulations in their own uniquely comedic ways.","Modern Family");
        saveDesc("Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.","South Park");
        saveDesc("A streetwise, poor young man from Philadelphia is sent by his mother to live with his aunt, uncle and cousins in their Bel-Air mansion.","The Fresh Prince of Bel-Air");
        saveDesc("A hedonistic jingle writer's free-wheeling life comes to an abrupt halt when his brother and 10-year-old nephew move into his beach-front house.","Two and a Half Men");
        saveDesc("Seventy-eight year old Carl Fredricksen travels to Paradise Falls in his home equipped with balloons, inadvertently taking a young stowaway.","Up");
        saveDesc("A wife questions her life choices as she travels to Stockholm with her husband, where he is slated to receive the Nobel Prize for Literature.","The Wife");
        saveDesc("A romantic drama centered on two new lovers: Tyler, whose parents have split in the wake of his brother's suicide, and Ally, who lives each day to the fullest since witnessing her mother's murder.","Remember Me");
        saveDesc("Shakespeare's famous play is updated to the hip modern suburb of Verona still retaining its original dialogue.","Romeo + Juliet");
        saveDesc("A five-year-old Indian boy gets lost on the streets of Calcutta, thousands of kilometers from home. He survives many challenges before being adopted by a couple in Australia. 25 years later, he sets out to find his lost family.","Lion");
        saveDesc("Held captive for years in an enclosed space, a woman and her young son finally gain their freedom, allowing the boy to experience the outside world for the first time.","Room");
        saveDesc("A Lion cub crown prince is tricked by a treacherous uncle into thinking he caused his father's death and flees into exile in despair, only to learn in adulthood his identity and his responsibilities.","The Lion King");
        saveDesc("A depressed uncle is asked to take care of his teenage nephew after the boy's father dies.","Manchester by the Sea");
        saveDesc("The life of Mason, from early childhood to his arrival at college.","Boyhood");
        saveDesc("A tale of war and romance mixed in with history. The story follows two lifelong friends and a beautiful nurse who are caught up in the horror of an infamous Sunday morning in 1941.","Pearl Harbor");
        saveDesc("Baltimore drug scene, seen through the eyes of drug dealers and law enforcement.","The Wire");
        saveDesc("A heartwarming and emotional story about a unique set of triplets, their struggles, and their wonderful parents.","This Is Us");
        saveDesc("Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship.","The Handmaid's Tale");
        saveDesc("The lives and tragedies of the Braverman family tree.","Parenthood");
        saveDesc("An adolescent with two siblings tests his various theories about life as he endures the trials of growing alongside a good friend.","Boy Meets World");
        saveDesc("Convicted of a decade old crime of transporting drug money to an ex-girlfriend, normally law-abiding Piper Chapman is sentenced to a year and a half behind bars to face the reality of how life-changing prison can really be.","Orange Is the New Black");
        saveDesc("A group of ambitious misfits try to escape the harsh realities of high school by joining a glee club.","Glee");
        saveDesc("A group of friends become motivated to living fuller lives after the unexpected death of a close friend.","A Million Little Things");
        saveDesc("The murder of a young boy in a small coastal town brings a media frenzy, which threatens to tear the community apart.","Broadchurch");
        saveDesc("Follows teenager Clay Jensen, in his quest to uncover the story behind his classmate and crush, Hannah, and her decision to end her life.","13 Reasons Why");
        saveDesc("A cyborg, identical to the one who failed to kill Sarah Connor, must now protect her teenage son, John Connor, from a more advanced and powerful cyborg.","Terminator 2: Judgment Day");
        saveDesc("An NYPD officer tries to save his wife and several others taken hostage by German terrorists during a Christmas party at the Nakatomi Plaza in Los Angeles.","Die Hard");
        saveDesc("When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.","The Dark Night");
        saveDesc("Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.","The Lord of the Rings: The Return of the King");
        saveDesc("After being kidnapped and imprisoned for fifteen years, Oh Dae-Su is released, only to find that he must find his captor in five days.","Oldboy");
        saveDesc("A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.","The Matrix");
        saveDesc("A young martial artist is caught between respecting his pacifist father's wishes or stopping a group of disrespectful foreigners from stealing precious artifacts.","The Legend of Drunken Master");
        saveDesc("After the rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader.","The Empire Strikes Back");
        saveDesc("Former Green Beret John Rambo is pursued into the mountains surrounding a small town by a tyrannical sheriff and his deputies, forcing him to survive using his combat skills.","First Blood");
        saveDesc("A man is picked up by a fishing boat, bullet-riddled and suffering from amnesia, before racing to elude assassins and attempting to regain his memory.","The Bourne Identity");
        saveDesc("The story of Easy Company of the U.S. Army 101st Airborne Division, and their mission in World War II Europe, from Operation Overlord, through V-J Day.","Band of Brothers");
        saveDesc("A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.","Breaking Bad");
        saveDesc("Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.","Game of Thrones");
        saveDesc("An animated series that follows the exploits of a super scientist and his not-so-bright grandson.","Rick and Morty");
        saveDesc("A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.","Sherlock");
        saveDesc("U.S. Attorney Chuck Rhoades goes after hedge fund king Bobby \"Axe\" Axelrod in a battle between two powerful New York figures.","Billions");
        saveDesc("A gangster family epic set in 1919 Birmingham, England; centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.","Peaky Blinders");
        saveDesc("A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.","Daredevil");
        saveDesc("After the murder of his family, Marine veteran Frank Castle becomes the vigilante known as \"The Punisher,\" with only one goal in mind: to avenge them.","The Punisher");
        saveDesc("Vikings transports us to the brutal and mysterious world of Ragnar Lothbrok, a Viking warrior and farmer who yearns to explore - and raid - the distant shores across the ocean.","Vikings");
        saveDesc("After a space merchant vessel perceives an unknown transmission as a distress call, its landing on the source moon finds one of the crew attacked by a mysterious lifeform, and they soon realize that its life cycle has merely begun.","Alien");
        saveDesc("Two strangers, who awaken in a room with no recollection of how they got there, soon discover they're pawns in a deadly game perpetrated by a notorious serial killer.","Saw");
        saveDesc("A journalist must investigate a mysterious videotape which seems to cause the death of anyone one week to the day after they view it.","The Ring");
        saveDesc("After moving into a suburban home, a couple becomes increasingly disturbed by a nightly demonic presence.","Paranormal Activity");
        saveDesc("A young woman is followed by an unknown supernatural force after a sexual encounter.","It Follows");
        saveDesc("Three film students vanish after traveling into a Maryland forest to film a documentary on the local Blair Witch legend, leaving only their footage behind.","The Blair Witch Project");
        saveDesc("A family heads to an isolated hotel for the winter where an evil spiritual presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future.","The Shining");
        saveDesc("Two siblings and three of their friends en route to visit their grandfather's grave in Texas end up falling victim to a family of cannibalistic psychopaths.","The Texas Chainsaw Massacre");
        saveDesc("Mysterious deaths surround an American ambassador. Could the child that he is raising actually be the Antichrist? The Devil's own son?","The Omen");
        saveDesc("After the family matriarch passes away, a grieving family is haunted by tragic and disturbing occurrences, and begin to unravel dark secrets.","Hereditary");
        saveDesc("When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.","Stranger Things");
        saveDesc("A mysterious viral outbreak with hallmarks of an ancient and evil strain of vampirism ravages the city of New York.","The Strain");
        saveDesc("Explores the early relationship between the renowned psychiatrist and his patient, a young FBI criminal profiler, who is haunted by his ability to empathize with serial killers.","Hannibal");
        saveDesc("An anthology series centering on different characters and locations, including a house with a murderous past, an insane asylum, a witch coven, a freak show, a hotel, a possessed farmhouse, a cult, and the apocalypse.","American Horror Story");
        saveDesc("In the aftermath of a hurricane, a Florida Park Ranger and his family deal with strange occurrences, including luminescent creatures in the water and people that somehow seem to have.","Invasion");
        saveDesc("Two brothers follow their father's footsteps as \"hunters\", fighting evil supernatural beings of many kinds, including monsters, demons, and gods that roam the earth.","Supernatural");
        saveDesc("A family saga with a supernatural twist, set in a German town, where the disappearance of two young children exposes the relationships among four families.","Dark");
        saveDesc("Combines dramatic re-enactments, interviews and updates, to tell stories of real mysteries, from human to the supernatural.","Unsolved Mysteries");
        saveDesc("An idiosyncratic FBI agent investigates the murder of a young woman in the even more idiosyncratic town of Twin Peaks.","Twin Peaks");
        saveDesc("Two F.B.I. Agents, Fox Mulder the believer and Dana Scully the skeptic, investigate the strange and unexplained, while hidden forces work to impede their efforts.","The X-Files");
        saveDesc("In 1954, a U.S. Marshal investigates the disappearance of a murderer, who escaped from a hospital for the criminally insane.","Shutter Island");
        saveDesc("A troubled teenager is plagued by visions of a man in a large rabbit suit who manipulates him to commit a series of crimes, after he narrowly escapes a bizarre accident.","Donnie Darko");
        saveDesc("An industrial worker who hasn't slept in a year begins to doubt his own sanity.","The Machinist");
        saveDesc("A boy who communicates with spirits seeks the help of a disheartened child psychologist.","The Sixth Sense");
        saveDesc("An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.","Fight Club");
        saveDesc("In turn-of-the-century Vienna, a magician uses his abilities to secure the love of a woman far above his social standing.","The Illusionist");
        saveDesc("Evan Treborn suffers blackouts during significant events of his life. As he grows up, he finds a way to remember these lost memories and a supernatural way to alter his life by reading his journal.","The Butterfly Effect");
        saveDesc("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.","Inception");
        saveDesc("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.","Interstellar");
        saveDesc("Three girls are kidnapped by a man with a diagnosed 23 distinct personalities. They must try to escape before the apparent emergence of a frightful new 24th.","Split");
        saveDesc("Elliot, a brilliant but highly unstable young cyber-security engineer and vigilante hacker, becomes a key figure in a complex game of global dominance when he and his shadowy allies try to take down the corrupt corporation he works for.","Mr. Robot");
        saveDesc("An anthology series exploring a twisted, high-tech world where humanity's greatest innovations and darkest instincts collide.","Black Mirror");
        saveDesc("Set at the intersection of the near future and the reimagined past, explore a world in which every human appetite can be indulged without consequence.","Westworld");
        saveDesc("A sci-fi anthology series with stand-alone episodes based on the works of Philip K. Dick.","Electric Dreams");
        saveDesc("Anthology series that examines how and why ordinary people commit brutal crimes.","The Sinner");
        saveDesc("A hapless UN employee discovers the agency he works for is hiding a gateway to a parallel dimension that's in Cold War with our own, and where his other self is a top spy. The war slowly heats up thanks to spies from both sides.","Counterpart");
        saveDesc("A Secret Service agent goes to Wayward Pines, Idaho, in search of two federal agents who have gone missing in the bucolic town. He soon learns that he may never get out of Wayward Pines alive.","Wayward Pines");
        saveDesc("Three years after the disappearance of two percent of the global population, a group of people in a small New York community try to continue their lives while coping with the tragedy of the unexplained nature of the event.","The Leftovers");
        saveDesc("A group of people around the world are suddenly linked mentally, and must find a way to survive being hunted by those who see them as a threat to the world's order.","Sense8");
        saveDesc("The survivors of a plane crash are forced to work together in order to survive on a seemingly deserted tropical island.","Lost");
    }

}