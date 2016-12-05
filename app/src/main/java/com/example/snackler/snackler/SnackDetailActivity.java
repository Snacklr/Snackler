package com.example.snackler.snackler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class SnackDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_detail);

        TextView snackTitleView = (TextView) findViewById(R.id.snackTitle);
        ImageView snackImageView = (ImageView) findViewById(R.id.snackImage);
        TextView snackQuantityView = (TextView) findViewById(R.id.snackQuantity);

        SnackEntry fakeEntryForDemo = new SnackEntry("Grapes");
        fakeEntryForDemo.setQuantity(100);

        String grapeImageURL = "http://www.tpswinegrapes.com/images/660/images//white-grapes.jpg";


        snackTitleView.setText(fakeEntryForDemo.getSnackType());
        snackImageView.setImageBitmap(fakeEntryForDemo.getImage());
        snackQuantityView.setText(String.valueOf(fakeEntryForDemo.getQuantity()));



    }

}
