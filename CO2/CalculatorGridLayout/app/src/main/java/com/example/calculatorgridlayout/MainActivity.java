package com.example.calculatorgridlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean op = true;
    String oper = "+";
    String old = "";
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
    }

    public void NumberEvent(View view) {
        if (op) {
            number.setText("");
        }
        op = false;
        String num = number.getText().toString();

        // Get the ID of the clicked view
        int viewId = view.getId();

        // Use if-else statements instead of switch
        if (viewId == R.id.b1) {
            num += "1";
        } else if (viewId == R.id.b2) {
            num += "2";
        } else if (viewId == R.id.b3) {
            num += "3";
        } else if (viewId == R.id.b4) {
            num += "4";
        } else if (viewId == R.id.b5) {
            num += "5";
        } else if (viewId == R.id.b6) {
            num += "6";
        } else if (viewId == R.id.b7) {
            num += "7";
        } else if (viewId == R.id.b8) {
            num += "8";
        } else if (viewId == R.id.b9) {
            num += "9";
        } else if (viewId == R.id.b0) {
            num += "0";
        } else if (viewId == R.id.clr) {
            num = "";
        }

        number.setText(num);
    }


    public void OperatorEvent(View view) {
        op = true;
        old = number.getText().toString();
        if (view.getId() == R.id.add) {
            oper = "+";
        } else if (view.getId() == R.id.sub) {
            oper = "-";
        } else if (view.getId() == R.id.mul) {
            oper = "*";
        } else if (view.getId() == R.id.div) {
            oper = "/";
        }
    }

    public void EqualEvent(View view) {
        String newNumber = number.getText().toString();
        double res = 0.0;
        switch (oper) {
            case "+":
                res = Double.parseDouble(old) + Double.parseDouble(newNumber);
                break;
            case "-":
                res = Double.parseDouble(old) - Double.parseDouble(newNumber);
                break;
            case "*":
                res = Double.parseDouble(old) * Double.parseDouble(newNumber);
                break;
            case "/":
                res = Double.parseDouble(old) / Double.parseDouble(newNumber);
                break;
        }
        number.setText(res + "");
    }
}
