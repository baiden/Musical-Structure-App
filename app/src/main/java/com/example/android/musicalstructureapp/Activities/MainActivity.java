package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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

public class MainActivity extends AppCompatActivity {

      @BindView(R.id.bottonNavigationView) BottomNavigationView bottomNavMenu;
      @BindView(R.id.list) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        ButterKnife.bind(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disables the default transaction in the bottom navigation view

        //Sets onClick listeners on the buttons on the bottom navigation view
        bottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.favourite:
                        Intent favourtieIntent = new Intent(MainActivity.this, FavouritesActivity.class);
                        startActivity(favourtieIntent);
                        break;

                    case R.id.playlistm:
                        Intent playListIntent = new Intent(MainActivity.this, PlayListActivity.class);
                        startActivity(playListIntent);
                        break;

                    case R.id.tracksm:
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(findViewById(R.id.tracksm));
                        break;

                    case R.id.albumm:
                        Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                        startActivity(albumIntent);
                        break;

                    case R.id.artist:
                        Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
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
        track.add(new Tracks("Imela", "Nathaniel Bassey", R.drawable.nb1));
        track.add(new Tracks("Miracle Worker", "Nathaniel Bassey", R.drawable.nb1));
        track.add(new Tracks("Count your blessings", "Cwesi Oteng", R.drawable.nb1));
        track.add(new Tracks("Crazy Love", "Akesse Brempong", R.drawable.tracks_icon));
        track.add(new Tracks("God is working", "Akesse Brempong", R.drawable.tracks_icon));

        final TrackAdapter trackAdapter = new TrackAdapter(this, track); //Puts the values into the TrackAdapter class

        listView.setAdapter(trackAdapter); //Displays the data in the TrackAdapter

        //Sets onClick listeners on the buttons and the listViews
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long viewId = view.getId();
                if (viewId == R.id.playButton) {
                    Tracks word = track.get(position);

                    Intent playtrack = new Intent(MainActivity.this, NowPlayingActivity.class);
                    playtrack.putExtra("Title",word.getTrack_title());
                    playtrack.putExtra("Artist",word.getArtist_name());
                    playtrack.putExtra("AlbumImage", word.getImageResourceID());
                    startActivity(playtrack);

                } else if (viewId == R.id.optionMenuButton) {
                    Toast.makeText(MainActivity.this, "Options button clicked", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent playtrack = new Intent(MainActivity.this, NowPlayingActivity.class);
                    Tracks word = track.get(position);

                    playtrack.putExtra("Title",word.getTrack_title());
                    playtrack.putExtra("Artist",word.getArtist_name());
                    playtrack.putExtra("AlbumImage", word.getImageResourceID());
                    startActivity(playtrack);
                }
            }
        });

    }

    //Inflates the menu icons
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //Sets onClick listeners on the menu icons
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
