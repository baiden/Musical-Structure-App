package com.example.android.musicalstructureapp.Data;

public class Playlist {

    private String mplayListName; // Stores the name of the playlist

    /**
     * Stores the playList's name
     *
     * @param vplayList stores the name of the playList
     */
    public Playlist (String vplayList){
        mplayListName = vplayList;
    }

    /**
     * Gets the name of the playList
     *
     * @return the name of the playList
     */
    public String getmPlayListName() {
        return mplayListName;
    }


}
