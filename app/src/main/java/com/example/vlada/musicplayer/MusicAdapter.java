package com.example.vlada.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class MusicAdapter extends ArrayAdapter<Song> {

    public MusicAdapter(Activity context, PlayList playList){
        super (context,0, playList.getSongs());
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

    public PlayList getCurrentPlayList(int currentSong) {
        PlayList playList = new PlayList();
        for (int i=0; i<getCount(); i++) playList.add(getItem(i));
        playList.currentSongIndex = currentSong;
        return playList;
    }

}
