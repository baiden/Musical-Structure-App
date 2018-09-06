package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

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
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

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

        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));
        albums.add(new Album("Yonda","Sammie", R.drawable.nb1));

        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        GridView gridView = (GridView) findViewById(R.id.albumGridview);
        gridView.setAdapter(albumAdapter);

    }
}
