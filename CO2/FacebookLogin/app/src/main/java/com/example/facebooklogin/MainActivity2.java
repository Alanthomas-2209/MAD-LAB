package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView usernameTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usernameTextView = findViewById(R.id.username_textview);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //key value pair
            String username = extras.getString("username");
            usernameTextView.setText(username);
        }
    }
}
