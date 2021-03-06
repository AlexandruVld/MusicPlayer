package com.example.vlada.musicplayer;

import java.util.ArrayList;

//The Arraylist with the songs info
public class Folder extends ArrayList<Song> {
    public Folder() {
        this.add(new Song("Tiesto", "Addagio for Strings", "Trance","Just Be"));
        this.add(new Song("Armin Van Buuren", "In and out of love", "Dance", "Imagine"));
        this.add(new Song("Armin Van Buuren", "This light between us", "Dance", "Mirage"));
        this.add(new Song("Armin Van Buuren", "Save my Night", "Dance","Intense"));
        this.add(new Song("Tiesto", "Dance for life", "Trance","Elements Of Life"));
        this.add(new Song("Tiesto", "Traffic", "Trance","Just Be"));
    }
}
