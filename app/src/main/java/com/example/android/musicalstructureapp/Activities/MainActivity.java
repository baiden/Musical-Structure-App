package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.musicalstructureapp.Adapter.TrackAdapter;
import com.example.android.musicalstructureapp.Data.Tracks;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.tracks_text_view) TextView tracks_txt;
//    @BindView(R.id.album_text_view) TextView albums_txt;
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
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

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
        ArrayList<Tracks> track = new ArrayList<Tracks>();

        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("Live Through it", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("For your glory", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("I believe", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));
        track.add(new Tracks("All For Me", "FIYA & James Fortune", R.drawable.nb1));


        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        final TrackAdapter trackAdapter = new TrackAdapter(this, track);

        listView.setAdapter(trackAdapter);

//        listView = TrackAdapter.getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String value = (String)trackAdapter.getItemAtPosition(position);
                long viewId = view.getId();
                if (viewId == R.id.playButton) {
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .playOn(findViewById(R.id.playButton));
                    Intent playtrack = new Intent(MainActivity.this, NowPlayingActivity.class);
                    startActivity(playtrack);
                } else if (viewId == R.id.optionMenuButton) {
                    Toast.makeText(MainActivity.this, "Options button clicked", Toast.LENGTH_SHORT).show();
                } else {
                    Intent playtrack = new Intent(MainActivity.this, NowPlayingActivity.class);
                    startActivity(playtrack);
                }
            }
        });

    }


}
