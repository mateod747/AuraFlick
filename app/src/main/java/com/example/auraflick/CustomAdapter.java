package com.example.auraflick;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Movie> movies;
    LayoutInflater inflater;
    GlobalApplication app;
    boolean[] checks;
    String key;
    boolean[] first, second;
    int br1 = 0, br2 = 0;

    public CustomAdapter(Context c, GlobalApplication app, ArrayList<Movie> movies, String key) {
        this.c = c;
        this.movies = movies;
        this.app = app;
        this.key = key;
        both(key);
    }

    private void both(String key) {

        boolean[] merged = new boolean[movies.size()];

        for(int i=0; i<movies.size(); i++) {
            if(movies.get(i).getType().equals("Movie")) {
                br1++;
            } else {
                br2++;
            }
        }
        if(key.equals("normalBoth") || key.equals("sadBoth") || key.equals("scaryBoth") || key.equals("mindblowBoth") || key.equals("funnyBoth")) {
            first = new boolean[br1];
            second = new boolean[br2];

            if(key.equals("normalBoth")) {
                first = app.loadChecks("normalMovies", br1);
                second = app.loadChecks("normalTV", br2);
                app.saveChecks(first, "normalMovies");
                app.saveChecks(second, "normalTV");
            }else if(key.equals("sadBoth")) {
                first = app.loadChecks("sadMovies", br1);
                second = app.loadChecks("sadTV", br2);
                app.saveChecks(first, "sadMovies");
                app.saveChecks(second, "sadTV");
            } else if(key.equals("scaryBoth")) {
                first = app.loadChecks("scaryMovies", br1);
                second = app.loadChecks("scaryTV", br2);
                app.saveChecks(first, "scaryMovies");
                app.saveChecks(second, "scaryTV");
            } else if(key.equals("mindblowBoth")) {
                first = app.loadChecks("mindblowMovies", br1);
                second = app.loadChecks("mindblowTV", br2);
                app.saveChecks(first, "mindblowMovies");
                app.saveChecks(second, "mindblowTV");
            } else if(key.equals("funnyBoth")) {
                first = app.loadChecks("funnyMovies", br1);
                second = app.loadChecks("funnyTV", br2);
                app.saveChecks(first, "funnyMovies");
                app.saveChecks(second, "funnyTV");
            }

            for(int i=0; i<br1; i++) {
                merged[i] = first[i];
            }
            for(int i=br1; i<br1+br2; i++) {
                merged[i] = second[i-br1];
            }
            if (key.equals("normalBoth") || key.equals("sadBoth") || key.equals("scaryBoth") || key.equals("mindblowBoth") || key.equals("funnyBoth")) {
                this.checks = merged;
            }
        } else {
            if(key.equals("normalMovies") || key.equals("sadMovies") || key.equals("scaryMovies") || key.equals("funnyMovies") || key.equals("mindblowMovies")) {
                this.first = app.loadChecks(key, movies.size());
            } else if(key.equals("normalTV") || key.equals("sadTV") || key.equals("scaryTV") || key.equals("funnyTV") || key.equals("mindblowTV")) {
                this.second = app.loadChecks(key, movies.size());
            }
            this.checks = app.loadChecks(key, movies.size());
        }
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.movieImage);
        TextView descTxt = convertView.findViewById(R.id.descTxt);
        TextView posTxt = convertView.findViewById(R.id.posTxt);
        final CheckBox cbFavorite = convertView.findViewById(R.id.cbFavorite);

        cbFavorite.setTag(position);
        cbFavorite.setOnCheckedChangeListener(null);
        cbFavorite.setFocusable(false);

        final String name= movies.get(position).getName();
        final int pic = movies.get(position).getImage();
        final String year = movies.get(position).getYear();
        final String type = movies.get(position).getType();

        nameTxt.setText(name);
        img.setImageResource(pic);
        descTxt.setText(year);
        posTxt.setText(type);

        if(key.equals("normalBoth") || key.equals("sadBoth") || key.equals("scaryBoth") || key.equals("mindblowBoth") || key.equals("funnyBoth")) {
            if((movies.get(position).getCheck() && (checks.length > 0)) || checks[position]) {
                cbFavorite.setChecked(true);
            } else {
                cbFavorite.setChecked(false);
            }
        } else {
            if(movies.get(position).getType().equals("Movie")) {
                if((movies.get(position).getCheck() && (first.length > 0)) || first[position]) {
                    cbFavorite.setChecked(true);
                } else {
                    cbFavorite.setChecked(false);
                }
            } else {
                if((movies.get(position).getCheck() && (second.length > 0)) || second[position]) {
                    cbFavorite.setChecked(true);
                } else {
                    cbFavorite.setChecked(false);
                }
            }
        }



        cbFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cbFavorite.isChecked()) {
                    movies.get(position).setCheck(true);
                        if(key.equals("normalBoth") || key.equals("sadBoth") || key.equals("scaryBoth") || key.equals("mindblowBoth") || key.equals("funnyBoth")) {
                            if(movies.get(position).getType().equals("Movie")) {
                                first[position] = true;
                            } else {
                                second[position-br1] = true;
                            }
                            if(key.equals("normalBoth")) {
                                app.saveChecks(first, "normalMovies");
                                app.saveChecks(second, "normalTV");
                            } else if(key.equals("sadBoth")) {
                                app.saveChecks(first, "sadMovies");
                                app.saveChecks(second, "sadTV");
                            } else if(key.equals("scaryBoth")) {
                                app.saveChecks(first, "scaryMovies");
                                app.saveChecks(second, "scaryTV");
                            } else if(key.equals("mindblowBoth")) {
                                app.saveChecks(first, "mindblowMovies");
                                app.saveChecks(second, "mindblowTV");
                            } else if(key.equals("funnyBoth")) {
                                app.saveChecks(first, "funnyMovies");
                                app.saveChecks(second, "funnyTV");
                            }
                        } else {
                            checks[position] = true;
                            app.saveChecks(checks, key);
                            if(movies.get(position).getType().equals("Movie")) {
                                first[position] = true;
                                app.saveChecks(first, movies.get(position).getName());
                            } else {
                                second[position] = true;
                                app.saveChecks(second, movies.get(position).getName());
                            }
                         }

                    Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
                    if(movies.get(position).getType().contains("Movie")) {
                        app.setMovieArray(movies.get(position));
                    } else if(movies.get(position).getType().contains("TV Show")) {
                        app.setTVArray(movies.get(position));
                    }
                } else {
                    movies.get(position).setCheck(false);
                    if (key.equals("normalBoth") || key.equals("sadBoth") || key.equals("scaryBoth") || key.equals("mindblowBoth") || key.equals("funnyBoth")) {
                        if (movies.get(position).getType().equals("Movie")) {
                            first[position] = false;
                        } else {
                            second[position - br1] = false;
                        }
                        if (key.equals("normalBoth")) {
                            app.saveChecks(first, "normalMovies");
                            app.saveChecks(second, "normalTV");
                        } else if (key.equals("sadBoth")) {
                            app.saveChecks(first, "sadMovies");
                            app.saveChecks(second, "sadTV");
                        } else if (key.equals("scaryBoth")) {
                            app.saveChecks(first, "scaryMovies");
                            app.saveChecks(second, "scaryTV");
                        } else if (key.equals("funnyBoth")) {
                            app.saveChecks(first, "funnyMovies");
                            app.saveChecks(second, "funnyTV");
                        } else if (key.equals("mindblowBoth")) {
                            app.saveChecks(first, "mindblowMovies");
                            app.saveChecks(second, "mindblowTV");
                        }
                    } else {
                        checks[position] = false;
                        app.saveChecks(checks, key);
                        if (movies.get(position).getType().equals("Movie")) {
                            first[position] = false;
                            app.saveChecks(first, movies.get(position).getName());
                        } else {
                            second[position] = false;
                            app.saveChecks(second, movies.get(position).getName());
                        }
                    }
                    if(movies.get(position).getType().contains("Movie")) {
                        app.removeMovie(movies.get(position).getName());
                    } else if(movies.get(position).getType().contains("TV Show")) {
                        app.removeShow(movies.get(position).getName());
                    }
                }
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();

                SharedPreferences mPrefs = c.getSharedPreferences("shared preferences", MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                prefsEditor.putString("name2", name);
                prefsEditor.putInt("pic2", pic);

                prefsEditor.putString("desc2", loadDesc(movies.get(position).getName()));

                prefsEditor.apply();

                MoviesActivity.pager.setCurrentItem(1);

            }
        });

        return convertView;
    }

    private String loadDesc(String key) {
        String list;
        SharedPreferences prefs = c.getSharedPreferences("shared preferences", MODE_PRIVATE);

        list = prefs.getString(key,"kk");

        return list;
    }
}

