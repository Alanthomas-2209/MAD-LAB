// MainActivity.java
package com.example.optionsmenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_item1) {
            navigateToItem1();
//            startActivity(new Intent(this, MainActivity2.class));
            return true;
        } else if (itemId == R.id.action_item2) {
            navigateToItem2();
//            startActivity(new Intent(this, MainActivity3.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_item1:
//                navigateToItem1();
//                return true;
//            case R.id.action_item2:
//                navigateToItem2();
//                return true;
//            case R.id.action_item3:
//                navigateToItem3();
//                return true;
//            case R.id.action_item4:
//                navigateToItem4();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToItem1() {
        showToast("Navigating to Item 1");
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    private void navigateToItem2() {
        showToast("Navigating to Item 2");
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

//    private void navigateToItem3() {
//        showToast("Navigating to Item 3");
//        Intent intent = new Intent(this, Item3Activity.class);
//        startActivity(intent);
//    }
//
//    private void navigateToItem4() {
//        showToast("Navigating to Item 4");
//        Intent intent = new Intent(this, Item4Activity.class);
//        startActivity(intent);
//    }
}
