package com.example.android.musicalstructureapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Data.Album;
import com.example.android.musicalstructureapp.Data.Tracks;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumAdapter extends ArrayAdapter<Album> {
    @BindView(R.id.albumImage1) ImageView albumImage1;
    @BindView(R.id.albumTitle1) TextView albumTitle_txt1;
    @BindView(R.id.albumArtise1) TextView albumArtist_txt1;

    private static final String Log = AlbumAdapter.class.getSimpleName();

    public AlbumAdapter(Activity context, ArrayList<Album> pAlbum){
        super(context, 0, pAlbum);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View albumListView = convertView;

        if(albumListView == null) {
            albumListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.albums_list_item, parent, false);
        }


        // Get the Album object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the TextView in the albums_list_item.xml layout with the ID version_name
        TextView albumTitle_txt1 = (TextView) albumListView.findViewById(R.id.albumTitle1);
        albumTitle_txt1.setText(currentAlbum.getAlbum_name());

        TextView albumArtist_txt1 = (TextView) albumListView.findViewById(R.id.albumArtise1);
        albumArtist_txt1.setText(currentAlbum.getAlbumArtist_name());

        // Find the ImageView in the albums_list_item.xml layout with the ID list_item_icon
        ImageView albumImage1 = (ImageView) albumListView.findViewById(R.id.albumImage1);
        albumImage1.setImageResource(currentAlbum.getAlbumImageResourceID());

        return albumListView;
    }
}
