package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingActivity extends AppCompatActivity {
    @BindView(R.id.songName) TextView songName;
    @BindView(R.id.artistName) TextView artistName;
    @BindView(R.id.nowPlayingImage) ImageView albumImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing_item);

        ButterKnife.bind(this);

        Intent intentThatStartedThisActivity = getIntent();

        //Receives the data that was passed through the intent
        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra("Title")) {
                String receiveSongTitle = intentThatStartedThisActivity.getStringExtra("Title");
                String receiveArtistName = intentThatStartedThisActivity.getStringExtra("Artist");
                int receiveAlbumImageArt = intentThatStartedThisActivity.getIntExtra("AlbumImage", R.id.nowPlayingImage);

                songName.setText(receiveSongTitle);
                artistName.setText(receiveArtistName);
                albumImage.setImageResource(receiveAlbumImageArt);
            }
        }

    }
}
