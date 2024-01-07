package com.example.validationsonuicontrols;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
                } else {
                    Toast.makeText(MainActivity.this, "Form is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static class FormValidator {

        public static boolean validateForm(EditText nameEditText, EditText emailEditText, EditText phoneEditText,
                                           EditText ageEditText, EditText dobEditText, EditText passwordEditText,
                                           RadioGroup genderRadioGroup, CheckBox termsCheckBox) {

            boolean isValid = true;

            String name = nameEditText.getText().toString().trim();
            if (TextUtils.isEmpty(name) || !name.matches("[a-zA-Z]+")) {
                nameEditText.setError("Please enter a valid name");
                isValid = false;
            }

            String email = emailEditText.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                emailEditText.setError("Please enter your email");
                isValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                emailEditText.setError("Please enter a valid email address");
                isValid = false;
            }

            String phone = phoneEditText.getText().toString().trim();
            if (TextUtils.isEmpty(phone)) {
                phoneEditText.setError("Please enter your phone number");
                isValid = false;
            } else if (!Patterns.PHONE.matcher(phone).matches() || !phone.matches("\\d{10}")) {
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
            if (TextUtils.isEmpty(password) || !password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{6,}$") ) {
                passwordEditText.setError("Please enter a valid password");
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
