package com.example.snackler.snackler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Temporary intent to start snack detail activity
        //Eventually main activity will be implemented with camera feed for landing screen
        Intent tempIntent = new Intent(this, SnackDetailActivity.class);
        startActivity(tempIntent);
    }
}
