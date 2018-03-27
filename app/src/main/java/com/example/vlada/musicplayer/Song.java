package com.example.vlada.musicplayer;

import java.io.Serializable;

// Data container
public class Song implements Serializable {

    private String mArtist;
    private String mTitle;
    private String mGenre;
    private String mAlbum;

    public Song(String artist, String track, String genre, String album){
        mArtist = artist;
        mTitle = track;
        mGenre = genre;
        mAlbum = album;
    }

    public String getArtist(){
        return mArtist;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getGenre() { return mGenre; }

    public String getAlbum() {return mAlbum;}

    public String getSongString() {
        return getArtist() + R.string.separator + getTitle() + R.string.separators + getAlbum();
    }

}
