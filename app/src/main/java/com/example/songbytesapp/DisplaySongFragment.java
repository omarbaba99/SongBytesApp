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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplaySongFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplaySongFragment extends Fragment {
    private Spinner spinner;
    String songData, songName;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DisplaySongFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplaySongFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        spinner = (Spinner) Objects.requireNonNull(getView()).findViewById(R.id.spinner);
        List<Song> songList = new ArrayList<>();
        Song song1 = new Song("Baby Shark", 5, "Pinkfong");
        songList.add(song1);
        Song song2 = new Song("Despacito", 3, "Luis Fonsi Daddy Yankee");
        songList.add(song2);
        Song song3 = new Song("Waka Waka", 4, "Shakira");
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
        Button button = (Button) view.findViewById(R.id.button_select);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Play Song
            }
        });
        return view;
    }
    public void getSelectedSong(View v) {
        Song song = (Song) spinner.getSelectedItem();
        displaySongData(song);
    }

    private void displaySongData(Song song) {
        songName = song.getName();
        int length = song.getLength();
        String artist = song.getArtist();
        songData = "Name: " + songName + "\nLength(in mins): " + length + "\nArtist: " + artist;
//        Toast.makeText(this, songData, Toast.LENGTH_LONG).show();
        TextView textView = (TextView) Objects.requireNonNull(getView()).findViewById(R.id.songmainTextHeader4);
        textView.setText(songData);
    }
}