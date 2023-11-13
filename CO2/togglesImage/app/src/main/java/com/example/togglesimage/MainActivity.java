package com.example.togglesimage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1, img2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img1.setOnClickListener(this::onClick);
        img2.setOnClickListener(this::onClick);
    }

    protected void onClick(View view) {
        if (view.getId() == R.id.imageView2) {
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
        } else {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
        }
    }
}
