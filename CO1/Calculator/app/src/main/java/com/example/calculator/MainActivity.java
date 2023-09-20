package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText input1, input2, output;
    Button addButton, subButton, mulButton, divButton;
    Double value1, value2, result;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = (EditText) findViewById(R.id.value1);
        input2 = (EditText) findViewById(R.id.value2);
        output = (EditText) findViewById(R.id.result);
        addButton = (Button) findViewById(R.id.add_Button);
        subButton = (Button) findViewById(R.id.sub_Button);
        mulButton = (Button) findViewById(R.id.mul_Button);
        divButton = (Button) findViewById(R.id.div_Button);
    }

    public void add(View v){
//        value1 = Integer.parseInt(input1.getText().toString());
//        value2 = Integer.parseInt(input2.getText().toString());
        value1 = Double.parseDouble(String.valueOf(input1.getText()));
        value2 = Double.parseDouble(String.valueOf(input2.getText()));
        result = value1 + value2;
        output.setText(Double.toString(result));
    }
    public void sub(View v){
        value1 = Double.parseDouble(String.valueOf(input1.getText()));
        value2 = Double.parseDouble(String.valueOf(input2.getText()));
        result = value1 - value2;
        output.setText(Double.toString(result));
    }
    public void mul(View v){

        value1 = Double.parseDouble(String.valueOf(input1.getText()));
        value2 = Double.parseDouble(String.valueOf(input2.getText()));
        result = value1 * value2;
        output.setText(Double.toString(result));
    }
    public void div(View v){

        value1 = Double.parseDouble(String.valueOf(input1.getText()));
        value2 = Double.parseDouble(String.valueOf(input2.getText()));
        result = value1 / value2;
        output.setText(Double.toString(result));
    }
}