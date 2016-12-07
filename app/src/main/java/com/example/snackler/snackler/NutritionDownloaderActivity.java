package com.example.snackler.snackler;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class NutritionDownloaderActivity extends Activity {

    protected static final String SNACK_TO_SEARCH = "Nutritionix_Query";

        @Override
        protected void onCreate( Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_nutrition_info_download_task);

            Intent detailIntent = new Intent(this, SnackDetailFragment.class);
            startActivity(detailIntent);

//           String snackSearchTerm = getIntent().getExtras().getString(SNACK_TO_SEARCH);
//
//            new NutritionInfoDownloadTask().execute(snackSearchTerm);
        }



    public class NutritionInfoDownloadTask extends AsyncTask<String, Void, SnackEntry> {


        private String urlBase = "https://api.nutritionix.com/v1_1/search";
        private String snacklerAppID = "5626502a";
        private String snacklerAppKey = "d45131dabedacac7e87305671ffe1d69";


        @Override
        protected SnackEntry doInBackground(String... searchTerms) {


            HashMap<String, String> parameters = new HashMap<String, String>();
            parameters.put("appId", snacklerAppID);
            parameters.put("appKey", snacklerAppKey);
            parameters.put("query", searchTerms[0]);

            JsonObjectRequest req = new JsonObjectRequest(urlBase, new JSONObject(parameters),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.i("ONREPSONSE: ", response.toString());
                                VolleyLog.v("Response:%n %s", response.toString(4));
                            } catch (JSONException e) {
                                Log.i("catch: ", ".....");
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("error: ", "...");
                    VolleyLog.e("Error: ", error.getMessage());
                }
            });

            
            Log.i("above return null: ", "....");
            return null;
        }

        @Override
        protected void onPostExecute(SnackEntry newSnack) {
            return;
        }

    }
}