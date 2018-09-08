package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.musicalstructureapp.Adapter.AlbumAdapter;
import com.example.android.musicalstructureapp.Data.Album;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends AppCompatActivity{

    @BindView(R.id.bottonNavigationView) BottomNavigationView bottomNavMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albums_activity);

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
                        Intent favourtieIntent = new Intent(AlbumActivity.this, FavouritesActivity.class);
                        startActivity(favourtieIntent);
                        break;

                    case R.id.playlistm:
                        Intent playListIntent = new Intent(AlbumActivity.this, PlayListActivity.class);
                        startActivity(playListIntent);
                        break;

                    case R.id.tracksm:
                        Intent tracksIntent = new Intent(AlbumActivity.this, MainActivity.class);
                        startActivity(tracksIntent);
                        break;

                    case R.id.albumm:
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(findViewById(R.id.albumm));
                        break;

                    case R.id.artist:
                        Intent artistIntent = new Intent(AlbumActivity.this, ArtistActivity.class);
                        startActivity(artistIntent);
                        break;
                }

                return false;
            }
        });

        ArrayList<Album> albums = new ArrayList<Album>();

        //Sets values into the albums instance of the Albums Class
        albums.add(new Album("Son of God","Nathaniel Bassey", R.drawable.nb1));
        albums.add(new Album("Encounter","Joe Mettle", R.drawable.ic_queue_music_black_24dp));
        albums.add(new Album("Imela","Nathaniel Bassey", R.drawable.nb1));
        albums.add(new Album("Live through it","James Fortune", R.drawable.ic_queue_music_black_24dp));
        albums.add(new Album("Crazy love","Akesse Brempong", R.drawable.ic_queue_music_black_24dp));
        albums.add(new Album("This kind love","Nathaniel Bassey", R.drawable.nb1));
        albums.add(new Album("Yaweh","Cwesi Oteng", R.drawable.ic_queue_music_black_24dp));
        albums.add(new Album("God is working","Akesse Brempong", R.drawable.nb1));

        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums); //Puts the values into the AlbumAdapter class
        GridView gridView = (GridView) findViewById(R.id.albumGridview);
        gridView.setAdapter(albumAdapter); //Displays the data in the AlbumAdapter

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
