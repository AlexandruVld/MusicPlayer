package com.example.vlada.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


//Receives the data from the ListView
public class PlayerActivity extends AppCompatActivity{

    int songNo;
    ArrayList<Song> songs;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        final TextView track = findViewById(R.id.track_name);
        final ImageView nextSong = findViewById(R.id.pass_track);
        ImageView previousSong = findViewById(R.id.back_track);
        ImageView backToPlaylist = findViewById(R.id.back_to_playlist);
        //Gets the info from the ListView
        Bundle bundle = getIntent().getExtras();
        songs = (ArrayList<Song>) bundle.getSerializable("Music");
        songNo = bundle.getInt("songNo");
        Song song = songs.get(songNo);
        track.setText(song.getSongString());

        // Goes to the next item in the ListView
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songNo = songNo + 1;
                if (songNo < songs.size()) {
                    Song song = songs.get(songNo);
                    track.setText(song.getSongString());
                } else {
                    songNo = songNo - 1;
                }
            }
        });

        //Goes to the previous item in the ListView
        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songNo = songNo - 1;
                if (songNo >= 0) {
                    Song song = songs.get(songNo);
                    track.setText(song.getSongString());
                } else {
                    songNo = songNo + 1;
                }
            }
        });

        // Goes to the MainActivity where the Dialog box gives the options to populate ListView
        backToPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToPlaylist = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(backToPlaylist);
            }
        });



    }
}


