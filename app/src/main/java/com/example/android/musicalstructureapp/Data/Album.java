package com.example.android.musicalstructureapp.Data;

public class Album {

    private String album_name; // Stores the album name

    private String albumArtist_name; // Stores the artise name

    private int albumImageResourceID; // Stores the image's ID


    /**
     * Creates a constuctor of the Album class
     * @param album_nameInput is the name of the album
     * @param albumArtist_nameInput is the name of the artist
     * @param albumImageResourceIDInput is the ID of the image
     */
    public Album (String album_nameInput, String albumArtist_nameInput, int albumImageResourceIDInput){
        album_name = album_nameInput;
        albumArtist_name = albumArtist_nameInput;
        albumImageResourceID = albumImageResourceIDInput;
    }


    public String getAlbum_name() {
        return album_name;
    }

    public String getAlbumArtist_name() {
        return albumArtist_name;
    }

    public int getAlbumImageResourceID() {
        return albumImageResourceID;
    }
}
