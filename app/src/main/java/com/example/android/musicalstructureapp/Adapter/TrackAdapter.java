package com.example.android.musicalstructureapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Data.Tracks;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

public class TrackAdapter extends ArrayAdapter<Tracks> {

    private static final String Log = TrackAdapter.class.getSimpleName();

    /**
     * Constructor class of TrackAdapter
     *
     * @param context The current context. Used to inflate the layout file.
     * @param ptracks A list of tracks objects to display in a list
     */
    public TrackAdapter(Activity context, ArrayList<Tracks> ptracks) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, ptracks);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tracks_list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Tracks currentTrack = getItem(position);

        // Find the TextView in the tracks_list_itemst_item.xml layout with the ID version_name
        TextView trackTitle_txt = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        trackTitle_txt.setText(currentTrack.getmTrack_title());

        // Find the TextView in the tracks_list_itemst_item.xml layout with the ID version_number
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        artistTextView.setText(currentTrack.getmArtist_name());

        // Find the ImageView in the tracks_list_item.xmltem.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentTrack.getmImageResourceID());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }
}
