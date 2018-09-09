package com.example.android.musicalstructureapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Data.Tracks;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

public class TrackAdapter extends ArrayAdapter<Tracks> {

    private static final String Log = TrackAdapter.class.getSimpleName();

    View listItemView;

    /**
     * Constructor class of TrackAdapter
     *
     * @param context The current context. Used to inflate the layout file.
     * @param ptracks A list of tracks objects to display in a list
     */
    public TrackAdapter(Activity context, ArrayList<Tracks> ptracks) {

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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tracks_list_item, parent, false);
        }

        // Get the Tracks object located at this position in the list
        Tracks currentTrack = getItem(position);

        // Find the TextView in the tracks_list_item.xml layout with the ID version_name
        TextView trackTitle_txt = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the version name from the current Tracks object and
        // set this text on the name TextView
        trackTitle_txt.setText(currentTrack.getTrack_title());

        // Find the TextView in the tracks_list_item.xml layout with the ID version_number
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the version number from the current Tracks object and
        // set this text on the number TextView
        artistTextView.setText(currentTrack.getArtist_name());

        // Find the ImageView in the tracks_list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current Tracks object and
        // set the image to iconView
        iconView.setImageResource(currentTrack.getImageResourceID());


        Button playButton = (Button) listItemView.findViewById(R.id.playButton);
        Button optionsMenuButton = (Button) listItemView.findViewById(R.id.optionMenuButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
            }
        });

        optionsMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
            }
        });

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) parent).performItemClick(v, position, 0); // Let the event be handled in onItemClick()
            }
        });

        return listItemView;
    }
}
