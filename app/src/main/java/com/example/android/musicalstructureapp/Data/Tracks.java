package com.example.android.musicalstructureapp.Data;

import java.io.Serializable;

public class Tracks {

    private String track_title; //Stores the track title

    private String artist_name; //Stores the artist's name

    private int imageResourceID; //Stores the album image



    /**
     * Creates a constructor class of Tracks
     *
     * @param track_titleInput is the title of the song
     * @param artist_nameInput is the name of the artist
     * @param imageResourceIDInput is the ID of the album
     */
    public Tracks(String track_titleInput, String artist_nameInput, int imageResourceIDInput){
        track_title = track_titleInput;
        artist_name = artist_nameInput;
        imageResourceID = imageResourceIDInput;
    }

    //Gets the title of the track
    public String getTrack_title() {
        return track_title;
    }

    //Gets the artist's name
    public String getArtist_name() {
        return artist_name;
    }

    //Gets the ID of the image
    public int getImageResourceID() {
        return imageResourceID;
    }

}
