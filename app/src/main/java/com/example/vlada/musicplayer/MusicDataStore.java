package com.example.vlada.musicplayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Holds the data to be manipulated in the app

public class MusicDataStore {

    private ArrayList<Song> musicStore = new ArrayList<Song>();

    public void addTrack(Song t){
        musicStore.add(t);
    }

    public void addFolder(Folder f){
        for(Song t: f) this.addTrack(t);
    }

    public PlayList getMusicByArtist(String artist) {
        PlayList tracksByArtist = new PlayList();
        for(Song t: musicStore) if (t.getArtist() == artist) tracksByArtist.add(t);
        return tracksByArtist;
    }

    public ArrayList<String> getAllArtists() {
        Set<String> allArtists = new HashSet<>();
        for(Song t: musicStore) allArtists.add(t.getArtist());
        return new ArrayList<>(allArtists);
    }

    public ArrayList<String> getAllAlbums() {
        Set<String> allAlbums = new HashSet<>();
        for(Song t: musicStore) allAlbums.add(t.getAlbum());
        return new ArrayList<>(allAlbums);
    }

    public PlayList getMusicByAlbum(String album){
        PlayList tracksByAlbum = new PlayList();
        for(Song t: musicStore) if (t.getAlbum() == album) tracksByAlbum.add(t);
        return tracksByAlbum;
    }

    public ArrayList<String> getAllGenre() {
        Set<String> sllGenre = new HashSet<>();
        for(Song t: musicStore) sllGenre.add(t.getGenre());
        return new ArrayList<>(sllGenre);
    }

    public PlayList getMusicByGenre(String genre){
        PlayList tracksByGenre = new PlayList();
        for(Song t: musicStore) if(t.getGenre() == genre) tracksByGenre.add(t);
        return tracksByGenre;
    }
}
