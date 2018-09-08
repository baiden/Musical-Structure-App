package com.example.android.musicalstructureapp.Data;

import java.io.Serializable;

public class Tracks {

    private String mTrack_title; //Stores the track title

    private String mArtist_name; //Stores the artist's name

    private int mImageResourceID; //Stores the album image



    /**
     * Creates a constructor class of Tracks
     *
     * @param vTrack_title is the title of the song
     * @param vArtist_name is the name of the artist
     * @param vImageResourceID is the ID of the album
     */
    public Tracks(String vTrack_title, String vArtist_name, int vImageResourceID){
        mTrack_title = vTrack_title;
        mArtist_name = vArtist_name;
        mImageResourceID = vImageResourceID;
    }

    //Gets the title of the track
    public String getmTrack_title() {
        return mTrack_title;
    }

    //Gets the artist's name
    public String getmArtist_name() {
        return mArtist_name;
    }

    //Gets the ID of the image
    public int getmImageResourceID() {
        return mImageResourceID;
    }

}
