package com.example.songbytesapp;

public class Song {

    private String name;
    private double length;
    private String artist;

    public Song(String name, double length, String artist) {
        //constructor to fill in the song details
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
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
