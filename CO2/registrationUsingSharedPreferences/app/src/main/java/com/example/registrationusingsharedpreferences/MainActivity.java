package com.example.registrationusingsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    EditText nameEditText;
    EditText emailEditText;
    EditText phoneEditText;
    EditText ageEditText;
    EditText dobEditText;
    EditText passwordEditText;
    RadioGroup genderRadioGroup;
    CheckBox termsCheckBox;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.Phone);
        ageEditText = findViewById(R.id.age);
        dobEditText = findViewById(R.id.dateOfBirth);
        passwordEditText = findViewById(R.id.password);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        termsCheckBox = findViewById(R.id.termsAndCondition);
        submitButton = findViewById(R.id.Submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FormValidator.validateForm(nameEditText, emailEditText, phoneEditText, ageEditText,
                        dobEditText, passwordEditText, genderRadioGroup, termsCheckBox)) {
                    Toast.makeText(MainActivity.this, "Form is Submitted Successfully", Toast.LENGTH_SHORT).show();
                    navigateToNextActivity();
                } else {
                    Toast.makeText(MainActivity.this, "Form is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameEditText.getText().toString());
        editor.putString("email", emailEditText.getText().toString());
        editor.putString("phone", phoneEditText.getText().toString());
        editor.putString("age", ageEditText.getText().toString());
        editor.putString("dob", dobEditText.getText().toString());
        editor.putString("password", passwordEditText.getText().toString());
        editor.putInt("gender", genderRadioGroup.getCheckedRadioButtonId());
        editor.putBoolean("terms", termsCheckBox.isChecked());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameEditText.setText(sharedPreferences.getString("name", ""));
        emailEditText.setText(sharedPreferences.getString("email", ""));
        phoneEditText.setText(sharedPreferences.getString("phone", ""));
        ageEditText.setText(sharedPreferences.getString("age", ""));
        dobEditText.setText(sharedPreferences.getString("dob", ""));
        passwordEditText.setText(sharedPreferences.getString("password", ""));
        genderRadioGroup.check(sharedPreferences.getInt("gender", -1));
        termsCheckBox.setChecked(sharedPreferences.getBoolean("terms", false));
    }


    private void navigateToNextActivity() {
//        Intent intent = new Intent(MainActivity.this, com.example.registrationusingsharedpreferences.MainActivity2.class);
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }

    public static class FormValidator {

        public static boolean validateForm(EditText nameEditText, EditText emailEditText, EditText phoneEditText,
                                           EditText ageEditText, EditText dobEditText, EditText passwordEditText,
                                           RadioGroup genderRadioGroup, CheckBox termsCheckBox) {

            boolean isValid = true;

            String name = nameEditText.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                nameEditText.setError("Please enter your name");
                isValid = false;
            }

            String email = emailEditText.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                emailEditText.setError("Please enter your email");
                isValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("Please enter a valid email address");
                isValid = false;
            }

            String phone = phoneEditText.getText().toString().trim();
            if (TextUtils.isEmpty(phone)) {
                phoneEditText.setError("Please enter your phone number");
                isValid = false;
            } else if (!Patterns.PHONE.matcher(phone).matches()) {
                phoneEditText.setError("Please enter a valid phone number");
                isValid = false;
            }

            String age = ageEditText.getText().toString().trim();
            if (TextUtils.isEmpty(age)) {
                ageEditText.setError("Please enter your age");
                isValid = false;
            }

            String dob = dobEditText.getText().toString().trim();
            if (TextUtils.isEmpty(dob)) {
                dobEditText.setError("Please enter your date of birth");
                isValid = false;
            }

            String password = passwordEditText.getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                passwordEditText.setError("Please enter a password");
                isValid = false;
            }

            int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
            if (selectedGenderId == -1) {
                isValid = false;
            }

            if (!termsCheckBox.isChecked()) {
                termsCheckBox.setError("Please accept the terms and conditions");
                isValid = false;
            }

            return isValid;
        }
    }
}
