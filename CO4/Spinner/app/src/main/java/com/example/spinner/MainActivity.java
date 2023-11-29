package com.example.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] spinnerItems = {"Action", "Comedy", "Drama"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        if (selectedItem.equals("Action")) {
            Intent intent = new Intent(MainActivity.this, ActionMovieActivity.class);
            startActivity(intent);
        } else if (selectedItem.equals("Comedy")) {
            Intent intent = new Intent(MainActivity.this, ComedyMovieActivity.class);
            startActivity(intent);
        } else if (selectedItem.equals("Drama")) {
            Intent intent = new Intent(MainActivity.this, DramaMovieActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
        Toast.makeText(getApplicationContext(), "Nothing Selected...!", Toast.LENGTH_SHORT).show();
    }

    public void submitForm(View view) {
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String dateOfBirth = editTextDateOfBirth.getText().toString();

    }
}

