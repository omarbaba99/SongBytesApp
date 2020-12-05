package com.example.songbytesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlaySongActivity extends AppCompatActivity {
    MediaPlayer music;
    int resId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        Intent intent = getIntent();
        String songData = intent.getStringExtra("songData");
        TextView textView = (TextView) findViewById(R.id.playMainTextHeader3);
        textView.setText(songData);

        String songName = intent.getStringExtra("songName");
        TextView textView2 = (TextView) findViewById(R.id.playMainTextHeader);
        textView2.setText(songName);

        String SongId = "";
        if(songName.equals("Waka Waka")) {
            SongId += "wakawaka";
        }
        else if(songName.equals("Despacito")) {
            SongId += "despacito";
        }
        else if(songName.equals("Baby Shark")) {
            SongId += "babyshark";
        }
        String packageName = getPackageName();
        resId = getResources().getIdentifier(SongId, "raw", packageName);
        music = MediaPlayer.create(
                this, resId);

    }

    public void musicplay(View v)
    {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v)
    {
        music.pause();
    }

    // Stoping the music
    public void musicstop(View v)
    {
        music.stop();
        music = MediaPlayer.create(
                this, resId);
    }
}