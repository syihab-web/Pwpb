package com.example.firebaselatihan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CharaList extends ArrayAdapter<Characters> {
    private Activity context;
    private List<Characters> charactersList;

    public CharaList(Activity context, List<Characters> charactersList) {
        super(context, R.layout.list_chara, charactersList);
        this.context = context;
        this.charactersList = charactersList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_chara, null, true);
        TextView textViewChara = (TextView) listViewItem.findViewById(R.id.textViewChara);
        TextView textViewRating = (TextView) listViewItem.findViewById(R.id.textViewRating);

        Characters c = charactersList.get(position);
        textViewChara.setText(c.getCharaName());
        textViewRating.setText(String.valueOf(c.getCharaRating()));

        return  listViewItem;
    }
}
