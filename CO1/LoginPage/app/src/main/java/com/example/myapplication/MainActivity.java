package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.button);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().equals("user") && Password.getText().toString().equals("123")){
                    Toast.makeText(MainActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Failed...!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}