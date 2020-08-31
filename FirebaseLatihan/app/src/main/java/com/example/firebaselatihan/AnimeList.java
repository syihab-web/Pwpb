package com.example.firebaselatihan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AnimeList extends ArrayAdapter<AnimeStudio>{
    private Activity context;
    private List<AnimeStudio> animeList;

    public AnimeList(Activity context, List<AnimeStudio> animeList) {
        super(context, R.layout.list_layout, animeList);
        this.context = context;
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewAnime = (TextView) listViewItem.findViewById(R.id.textViewAnime);
        TextView textViewStudio = (TextView) listViewItem.findViewById(R.id.textViewStudio);

        AnimeStudio animeStudio = animeList.get(position);
        textViewAnime.setText(animeStudio.getAnimeName());
        textViewStudio.setText(animeStudio.getStudio());

        return  listViewItem;
    }
}
