package com.example.songbytesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View view) {
        EditText editEmail = (EditText) findViewById(R.id.mainEmail);
        EditText editPassword = (EditText) findViewById(R.id.mainPassword);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        if(email.equals("admin@gmail.com") && password.equals("admin"))
        {
            openAdminActivity();
        }
        else if(email.equals("user@gmail.com") && password.equals("user")){
            openUserActivity();
        }
        else {
            Toast.makeText(this, "Invalid Username or Password!" , Toast.LENGTH_LONG).show();
        }
    }

    public void openUserActivity(){
        Intent intent = new Intent(this, SongsActivity.class);
        startActivity(intent);
    }

    public void openAdminActivity(){
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}