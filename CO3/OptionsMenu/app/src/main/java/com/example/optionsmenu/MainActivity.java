// MainActivity.java
package com.example.optionsmenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemHome) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            startActivity( new Intent(MainActivity.this, MainActivity2.class));
        }
        else if(item.getItemId() == R.id.itemProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            startActivity( new Intent(MainActivity.this, MainActivity3.class));
        }
        else if(item.getItemId() == R.id.itemAbout) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            startActivity( new Intent(MainActivity.this, MainActivity1.class));
        }
        else if(item.getItemId() == R.id.itemExit) {
            Toast.makeText(this, "Exiting", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
