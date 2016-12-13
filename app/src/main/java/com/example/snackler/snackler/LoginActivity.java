package com.example.snackler.snackler;

/**
 * Created by magneta94 on 12/13/16.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;



/**
 * Created by miftakhul on 26/06/16.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        Button logButton = (Button) findViewById(R.id.login);

        logButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ScanActivity.class));
            }
        });


        Button signUpButton = (Button) findViewById(R.id.signup);
        signUpButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }
}