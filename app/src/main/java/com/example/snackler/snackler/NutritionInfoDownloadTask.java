package com.example.snackler.snackler;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NutritionInfoDownloadTask extends AsyncTask<String, Void, SnackEntry> {

    @Override
    protected SnackEntry doInBackground(String... snack) {

        String urlBase = "https://api.nutritionix.com/v1_1/search";

        return null;
    }
}
