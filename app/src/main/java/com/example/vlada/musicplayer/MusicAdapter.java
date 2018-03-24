package com.example.vlada.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vlada on 17-Mar-18.
 */

public class MusicAdapter extends ArrayAdapter<Song> {

    public MusicAdapter(Activity context, ArrayList<Song> music){
        super (context,0, music);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentMusic = getItem(position);

        TextView artistTextView = listItemView.findViewById(R.id.artist_name);

        artistTextView.setText(currentMusic.getArtist());

        TextView titleTextView = listItemView.findViewById(R.id.song_name);

        titleTextView.setText(currentMusic.getTitle());

        TextView genreTextView = listItemView.findViewById(R.id.song_genre);
        genreTextView.setText(currentMusic.getGenre());

        TextView albumTextView = listItemView.findViewById(R.id.song_album);
        albumTextView.setText(currentMusic.getAlbum());

        return listItemView;
    }

    public class SongList extends ArrayList<Song> implements Serializable {}

    public ArrayList<Song> getAllItems() {
        SongList allItems = new SongList();
        for (int i=0; i<getCount(); i++) allItems.add(getItem(i));
        return allItems;
    }


}
