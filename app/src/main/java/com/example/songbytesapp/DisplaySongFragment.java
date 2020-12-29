package com.example.songbytesapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DisplaySongFragment extends Fragment {
    private Spinner spinner;
    String songData, songName;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DisplaySongFragment() {
        // Required empty public constructor
    }

    public static DisplaySongFragment newInstance(String param1, String param2) {
        DisplaySongFragment fragment = new DisplaySongFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //Add all the song details to a song arrayList
        spinner = (Spinner) Objects.requireNonNull(getView()).findViewById(R.id.fragSpinner);
        List<Song> songList = new ArrayList<>();
        Song song1 = new Song("Baby Shark", 2.16, "Pink Fong");
        songList.add(song1);
        Song song2 = new Song("Despacito", 4.41, "Luis Fonsi, Daddy Yankee");
        songList.add(song2);
        Song song3 = new Song("Waka Waka", 4.01, "Shakira");
        songList.add(song3);
        ArrayAdapter<Song> adapter = new ArrayAdapter<Song>(Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_item, songList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) parent.getSelectedItem();
                displaySongData(song);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_display_song,
                container, false);
        Button button = (Button) view.findViewById(R.id.playSongButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), PlaySongActivity.class);
                intent.putExtra("songData", songData);
                intent.putExtra("songName", songName);
                startActivity(intent);
            }
        });
        return view;
    }

    public void getSelectedSong(View v) {
        //get the song selected from spinner
        Song song = (Song) spinner.getSelectedItem();
        displaySongData(song);
    }

    private void displaySongData(Song song) {
        //Display the selected song details
        songName = song.getName();
        double length = song.getLength();
        String artist = song.getArtist();
        songData = "Name: " + songName + "\nLength(in mins): " + length + "\nArtist: " + artist;
        TextView textView = (TextView) Objects.requireNonNull(getView()).findViewById(R.id.fragMainTextHeader2);
        textView.setText(songData);
    }
}