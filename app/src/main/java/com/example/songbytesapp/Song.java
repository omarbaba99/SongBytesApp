package com.example.songbytesapp;

public class Song {
    private String name;
    private int length;
    private String artist;

    public Song(String name, int length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String mail) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return name;
    }
}
