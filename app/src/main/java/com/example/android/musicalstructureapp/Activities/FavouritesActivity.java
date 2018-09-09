package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.musicalstructureapp.Adapter.TrackAdapter;
import com.example.android.musicalstructureapp.Data.Tracks;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouritesActivity extends AppCompatActivity {

    @BindView(R.id.bottonNavigationView) BottomNavigationView bottomNavMenu;
    @BindView(R.id.list) ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites_activity);

        ButterKnife.bind(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disables the default transaction in the bottom navigation view

        //Sets onClick listeners on the buttons on the bottom navigation view
        bottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.favourite:
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(findViewById(R.id.favourite));
                        break;

                    case R.id.playlistm:
                        Intent playListIntent = new Intent(FavouritesActivity.this, PlayListActivity.class);
                        startActivity(playListIntent);
                        break;

                    case R.id.tracksm:
                        Intent tracksIntent = new Intent(FavouritesActivity.this, MainActivity.class);
                        startActivity(tracksIntent);
                        break;

                    case R.id.albumm:
                        Intent albumIntent = new Intent(FavouritesActivity.this, ArtistActivity.class);
                        startActivity(albumIntent);
                        break;

                    case R.id.artist:
                        Intent artistIntent = new Intent(FavouritesActivity.this, ArtistActivity.class);
                        startActivity(artistIntent);
                        break;
                }

                return false;
            }
        });

        // Create an array of tracks using an ArrayList
        final ArrayList<Tracks> track = new ArrayList<Tracks>();

        //Sets values into the track instance of the Track Class
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.tracks_icon));
        track.add(new Tracks("Song of God", "Nathaniel Bassey", R.drawable.nb1));
        track.add(new Tracks("My Everything", "Joe Mettle", R.drawable.tracks_icon));
        track.add(new Tracks("Bonooni", "Joe Mettle", R.drawable.tracks_icon));
        track.add(new Tracks("This God is too good", "Nathaniel Bassey", R.drawable.nb1));

        final TrackAdapter trackAdapter = new TrackAdapter(this, track); //Puts the values into the TrackAdapter class

        listView.setAdapter(trackAdapter); //Displays the data in the TrackAdapter

        //Sets onClick listeners on the buttons and the listViews
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long viewId = view.getId();
                if (viewId == R.id.playButton) {
                    Tracks word = track.get(position);

                    Intent playtrack = new Intent(FavouritesActivity.this, NowPlayingActivity.class);
                    playtrack.putExtra("Title",word.getTrack_title());
                    playtrack.putExtra("Artist",word.getArtist_name());
                    playtrack.putExtra("AlbumImage", word.getImageResourceID());
                    startActivity(playtrack);

                } else if (viewId == R.id.optionMenuButton) {
                    Toast.makeText(FavouritesActivity.this, "Options button clicked", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent playtrack = new Intent(FavouritesActivity.this, NowPlayingActivity.class);
                    Tracks word = track.get(position);

                    playtrack.putExtra("Title",word.getTrack_title());
                    playtrack.putExtra("Artist",word.getArtist_name());
                    playtrack.putExtra("AlbumImage", word.getImageResourceID());
                    startActivity(playtrack);
                }
            }
        });
    }
}
