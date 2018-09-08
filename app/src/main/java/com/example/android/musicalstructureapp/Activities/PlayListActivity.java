package com.example.android.musicalstructureapp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.android.musicalstructureapp.Adapter.TrackAdapter;
import com.example.android.musicalstructureapp.Data.Playlist;
import com.example.android.musicalstructureapp.Data.Tracks;
import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayListActivity extends AppCompatActivity {

    @BindView(R.id.bottonNavigationView) BottomNavigationView bottomNavMenu;
    @BindView(R.id.createPlaylistBtn) Button createPlayButton;
    private String m_Text = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_activity);

        ButterKnife.bind(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView); //Disables the default transaction in the bottom navigation view

        //Sets onClick listeners on the buttons on the bottom navigation view
        bottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.favourite:
                        Intent favourtieIntent = new Intent(PlayListActivity.this, FavouritesActivity.class);
                        startActivity(favourtieIntent);
                        break;

                    case R.id.playlistm:
                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(findViewById(R.id.playlistm));

                        break;

                    case R.id.tracksm:
                        Intent tracksIntent = new Intent(PlayListActivity.this, MainActivity.class);
                        startActivity(tracksIntent);
                        break;

                    case R.id.albumm:
                        Intent albumIntent = new Intent(PlayListActivity.this, AlbumActivity.class);
                        startActivity(albumIntent);
                        break;

                    case R.id.artist:
                        Intent artistIntent = new Intent(PlayListActivity.this, ArtistActivity.class);
                        startActivity(artistIntent);
                        break;
                }

                return false;
            }
        });

    }

    //Creates a an Alert dialog to create a playlist
    @OnClick(R.id.createPlaylistBtn)
    public void submit(View view) {
        YoYo.with(Techniques.Wobble)
                .duration(700)
                .playOn(findViewById(R.id.createPlaylistBtn));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Create playlist");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 0, 70, 0);

        // Set up the input
        final EditText input = new EditText(this);
        layout.addView(input, params);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(layout);

        // Set up the buttons
        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    //Inflates the view with the menu icons
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
