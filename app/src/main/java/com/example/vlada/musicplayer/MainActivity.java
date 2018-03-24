package com.example.vlada.musicplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    MusicDataStore musicDataStore = new MusicDataStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = findViewById(R.id.list_item);
        musicDataStore.addFolder(new Folder());

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(R.string.add_music);
        alertDialog.setItems((R.array.add_by), new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        final AlertDialog.Builder artistDialog= new AlertDialog.Builder(MainActivity.this);
                        final List<String> artists = musicDataStore.getAllArtists();
                        artistDialog.setTitle(R.string.select_artist);
                        artistDialog.setItems(artists.toArray(new String[artists.size()]), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listView.setAdapter(new MusicAdapter(MainActivity.this, musicDataStore.getMusicByArtist(artists.get(i))));
                            }
                        });
                        artistDialog.show();
                        break;
                    case 1:
                        AlertDialog.Builder genreDialog = new AlertDialog.Builder(MainActivity.this);
                        final List<String> genre = musicDataStore.getAllGenre();
                        genreDialog.setTitle(R.string.select_genre);
                        genreDialog.setItems(genre.toArray(new String[genre.size()]), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listView.setAdapter(new MusicAdapter(MainActivity.this, musicDataStore.getMusicByGenre(genre.get(i))));
                            }
                        });
                        genreDialog.show();
                        break;
                    case 2:
                        AlertDialog.Builder albumDialog = new AlertDialog.Builder(MainActivity.this);
                        final List<String> album = musicDataStore.getAllAlbums();
                        albumDialog.setTitle(R.string.select_album);
                        albumDialog.setItems(album.toArray(new String[album.size()]), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listView.setAdapter(new MusicAdapter(MainActivity.this, musicDataStore.getMusicByAlbum(album.get(i))));
                            }
                        });
                        albumDialog.show();
                        break;

                    default:
                        break;


                        }

                    }
                });

                alertDialog.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playMusic = new Intent(MainActivity.this, PlayerActivity.class);
                MusicAdapter adapter = (MusicAdapter)listView.getAdapter();
                playMusic.putExtra("Music", adapter.getAllItems());
                playMusic.putExtra("songNo", i);
                startActivity(playMusic);
            }
        });

    }





}
