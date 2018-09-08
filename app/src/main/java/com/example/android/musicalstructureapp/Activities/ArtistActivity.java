package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class ArtistActivity extends AppCompatActivity {

    @BindView(R.id.bottonNavigationView) BottomNavigationView bottomNavMenu;
    @BindView(R.id.list) ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artists_activity);

        ButterKnife.bind(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disables the default transaction in the bottom navigation view

        //Sets onClick listeners on the icons on the botton navigation view
        bottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.favourite:
                        Intent favourtieIntent = new Intent(ArtistActivity.this, FavouritesActivity.class);
                        startActivity(favourtieIntent);
                        break;

                    case R.id.playlistm:
                        Intent playListIntent = new Intent(ArtistActivity.this, PlayListActivity.class);
                        startActivity(playListIntent);
                        break;

                    case R.id.tracksm:
                        Intent tracksIntent = new Intent(ArtistActivity.this, MainActivity.class);
                        startActivity(tracksIntent);
                        break;

                    case R.id.albumm:
                        Intent albumIntent = new Intent(ArtistActivity.this, AlbumActivity.class);
                        startActivity(albumIntent);
                        break;

                    case R.id.artist:
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(findViewById(R.id.artist));
                        break;
                }

                return false;
            }
        });

        // Create an array of tracks using an ArrayList
        final ArrayList<Tracks> track = new ArrayList<Tracks>();

        //Sets values into the track instance of the Tracks Class
        track.add(new Tracks("", "FIYA & James Fortune", R.drawable.james));
        track.add(new Tracks("", "Cwesi Oteng", R.drawable.tracks_icon));
        track.add(new Tracks("", "Nathaniel Bassey", R.drawable.napthy));
        track.add(new Tracks("", "Akesse Brempong", R.drawable.tracks_icon));
        track.add(new Tracks("", "Joe Mettle", R.drawable.joe));

        final TrackAdapter trackAdapter = new TrackAdapter(this, track); //Puts the values into the TrackAdapter class

        listView.setAdapter(trackAdapter); //Displays the data in the TrackAdapter
    }

    //Inflates the menu icons on the screen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //Sets onClick listeners on the icons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        if (res_id==R.id.search){
            Toast.makeText(this, "Search feature is selectly unavailable", Toast.LENGTH_SHORT).show();
        }

        if (res_id == R.id.options){
            Toast.makeText(this, "Settings menu is selectly unavailable", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
