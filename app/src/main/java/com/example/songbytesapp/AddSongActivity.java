package com.example.songbytesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddSongActivity extends AppCompatActivity {
    private static final int PICK_FROM_GALLERY = 101;
    Uri URI = null;
    TextView tvAttachment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
    }
    public void uploadSong(View view) {

        //pick song audio file from gallery
        Intent intent = new Intent();
        intent.setType("audio/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //once user id done selecting song audio file to upload
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            tvAttachment = findViewById(R.id.tvAttachment);
            URI = data.getData();
            tvAttachment.setText(URI.getLastPathSegment());
            tvAttachment.setVisibility(View.VISIBLE);
            Toast.makeText(this, "File uploaded", Toast.LENGTH_LONG).show();
        }
    }

    public void addSong(View view) {

        //add the song and its details once all the fields are filled
        EditText editName = (EditText) findViewById(R.id.addSongName);
        EditText editArtist = (EditText) findViewById(R.id.addSongArtist);
        EditText editLength = (EditText) findViewById(R.id.addSongLength);
        String name = editName.getText().toString();
        String artist = editArtist.getText().toString();
        String len = editLength.getText().toString();

        //Check for blank input
        if(name.length()==0||len.length()==0||artist.length()==0||URI==null) {
            Toast.makeText(this, "Please provide all the details!", Toast.LENGTH_LONG).show();
            return;
        }

        //Display toast as feedback to user
        String data = "New Song Added\nName: " + name + "\nLength(in mins): " + len + "\nArtist: " + artist;
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        resetFields();
    }

    public void resetFields() {

        //To make the field empty once a new song is added
        EditText editName = (EditText) findViewById(R.id.addSongName);
        EditText editArtist = (EditText) findViewById(R.id.addSongArtist);
        EditText editLength = (EditText) findViewById(R.id.addSongLength);
        editName.setText("");
        editArtist.setText("");
        editLength.setText("");
        tvAttachment.setText(null);
        tvAttachment.setVisibility(View.INVISIBLE);
    }
}