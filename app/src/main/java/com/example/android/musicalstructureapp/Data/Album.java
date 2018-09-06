package com.example.android.musicalstructureapp.Data;

public class Album {

    private String mAlbum_name; // Stores the album name

    private String mAlbumArtist_name; // Stores the artise name

    private int mAlbumImageResourceID; // Stores the image's ID


    /**
     * Creates a constuctor of the Album class
     * @param vAlbum_name is the name of the album
     * @param vAlbumArtist_name is the name of the artist
     * @param vAlbumImageResourceID is the ID of the image
     */
    public Album (String vAlbum_name, String vAlbumArtist_name, int vAlbumImageResourceID){
        mAlbum_name = vAlbum_name;
        mAlbumArtist_name = vAlbumArtist_name;
        mAlbumImageResourceID = vAlbumImageResourceID;
    }


    public String getmAlbum_name() {
        return mAlbum_name;
    }

    public String getmAlbumArtist_name() {
        return mAlbumArtist_name;
    }

    public int getmAlbumImageResourceID() {
        return mAlbumImageResourceID;
    }
}
