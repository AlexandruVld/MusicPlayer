package com.example.vlada.musicplayer;

import java.io.Serializable;
import java.util.ArrayList;


class PlayList implements Serializable {
    int currentSongIndex = 0;
    ArrayList<Song> playList = new ArrayList<>();

    public ArrayList<Song> getSongs() {
        return playList;
    }

    public void add(Song song) {
        playList.add(song);
    }

    public Song getCurrentSong(){
        return playList.get(currentSongIndex);
    }

    public Song next(){
        currentSongIndex++;
        if (currentSongIndex < playList.size()) {
            return playList.get(currentSongIndex);
        } else {
            currentSongIndex--;
            return playList.get(currentSongIndex);
        }
    }

    public Song previous() {
        currentSongIndex--;
        if (currentSongIndex >= 0){
            return playList.get(currentSongIndex);
        } else {
            currentSongIndex++;
            return playList.get(currentSongIndex);
        }
    }
}