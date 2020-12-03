package com.example.auraflick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterFav extends BaseAdapter {
    Context c;
    ArrayList<Movie> movies;
    LayoutInflater inflater;

    public CustomAdapterFav(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
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
            convertView=inflater.inflate(R.layout.model_fav,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.tvNameFav);
        ImageView img= (ImageView) convertView.findViewById(R.id.ivPosterFav);
        TextView descTxt = convertView.findViewById(R.id.tvYearFav);
        TextView posTxt = convertView.findViewById(R.id.tvTypeFav);

        final String name= movies.get(position).getName();
        final int pic = movies.get(position).getImage();
        final String year = movies.get(position).getYear();
        final String type = movies.get(position).getType();

        nameTxt.setText(name);
        img.setImageResource(pic);
        descTxt.setText(year);
        posTxt.setText(type);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return convertView;
    }
}
