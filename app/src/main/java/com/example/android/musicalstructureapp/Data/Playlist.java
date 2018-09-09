package com.example.android.musicalstructureapp.Data;

public class Playlist {

    private String playListName; // Stores the name of the playlist

    /**
     * Stores the playList's name
     *
     * @param playListInput stores the name of the playList
     */
    public Playlist (String playListInput){
        playListName = playListInput;
    }

    /**
     * Gets the name of the playList
     *
     * @return the name of the playList
     */
    public String getPlayListName() {
        return playListName;
    }


}
