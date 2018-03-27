package com.example.vlada.musicplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String STATE_LIST = "State Adapter Data";
    final MusicDataStore musicDataStore = new MusicDataStore();

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        ListAdapter listAdapter = ((ListView) findViewById(R.id.list_item)).getAdapter();
        if (listAdapter != null) {
            savedInstanceState.putSerializable(STATE_LIST, ((MusicAdapter) listAdapter).getCurrentPlayList(0));
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getSerializable(STATE_LIST) != null) {
            ((ListView) findViewById(R.id.list_item)).setAdapter(new MusicAdapter(
                    MainActivity.this, (PlayList) savedInstanceState.getSerializable(STATE_LIST)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView option = findViewById(R.id.add_music_option);
        final ListView listView = findViewById(R.id.list_item);
        musicDataStore.addFolder(new Folder());

        // Creates Dialog box with options to populate ListView
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle(R.string.add_music);
                alertDialog.setItems((R.array.add_by), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                final AlertDialog.Builder artistDialog = new AlertDialog.Builder(MainActivity.this);
                                final List<String> artists = musicDataStore.getAllArtists();
                                artistDialog.setTitle(R.string.select_artist);
                                artistDialog.setItems(artists.toArray(new String[artists.size()]), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        listView.setAdapter(new MusicAdapter(MainActivity.this,
                                                musicDataStore.getMusicByArtist(artists.get(i))));
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
                                        listView.setAdapter(new MusicAdapter(MainActivity.this,
                                                musicDataStore.getMusicByGenre(genre.get(i))));
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
                                        listView.setAdapter(new MusicAdapter(MainActivity.this,
                                                musicDataStore.getMusicByAlbum(album.get(i))));
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
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playMusic = new Intent(MainActivity.this, PlayerActivity.class);
                MusicAdapter adapter = (MusicAdapter) adapterView.getAdapter();
                PlayList playList = adapter.getCurrentPlayList(i);
                playMusic.putExtra("Music", playList);
                startActivity(playMusic);
            }
        });

    }
}
