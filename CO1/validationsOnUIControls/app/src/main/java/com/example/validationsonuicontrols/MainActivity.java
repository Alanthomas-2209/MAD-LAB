package com.example.validationsonuicontrols;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText name,email,dateOfBirth,phoneNo, age, password;
    CheckBox termsAndCondition, ug, pg;

    RadioButton
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        dateOfBirth = (EditText) findViewById(R.id.dateOfBirth);
        phoneNo = (EditText) findViewById(R.id.Phone);
        age = (EditText) findViewById(R.id.age);
        password = (EditText) findViewById(R.id.password);
        termsAndCondition = (CheckBox) findViewById(R.id.termsAndCondition);
        ug = (CheckBox) findViewById(R.id.checkBoxUG);
        pg = (CheckBox) findViewById(R.id.checkBoxPG);
        submit = (Button) findViewById(R.id.Submit);


    }
}