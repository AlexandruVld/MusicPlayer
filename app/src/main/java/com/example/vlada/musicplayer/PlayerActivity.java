package com.example.vlada.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by vlada on 21-Mar-18.
 */

public class PlayerActivity extends AppCompatActivity{

    int songNo;
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        final TextView track = findViewById(R.id.track_name);
        final ImageView nextSong = findViewById(R.id.pass_track);
        ImageView previousSong = findViewById(R.id.back_track);
        Bundle bundle = getIntent().getExtras();
        final ArrayList<Song> songs = (ArrayList<Song>) bundle.getSerializable("Music");
        songNo = bundle.getInt("songNo");
        Song song = songs.get(songNo);
        track.setText(song.getArtist() + " - " + song.getTitle() + " -- " + song.getAlbum());

        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songNo = songNo + 1;
                if (songNo < songs.size()) {
                    Song song = songs.get(songNo);
                    track.setText(song.getArtist() + " - " + song.getTitle() + " -- " + song.getAlbum());
                } else {
                    songNo = songNo - 1;
                }
            }
        });

        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songNo = songNo - 1;
                if (songNo >= 0) {
                    Song song = songs.get(songNo);
                    track.setText(song.getArtist() + " - " + song.getTitle() + " -- " + song.getAlbum());
                } else {
                    songNo = songNo + 1;
                }
            }
        });



    }







}


