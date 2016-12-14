package com.example.snackler.snackler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by magneta94 on 12/13/16.
 */

public class RegisterActivity  extends AppCompatActivity{

    SeekBar fatBar;
    SeekBar sugarBar ;
    SeekBar carBar;
    SeekBar calBar;
    SeekBar proBar;
    SeekBar sodBar;


    TextView fatView ;
    TextView sugarView;
    TextView carbView ;
    TextView calView ;
    TextView proView;
    TextView sodView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

         final SnackDay snacks = MainActivity.getDayObject();

        fatBar = (SeekBar)findViewById(R.id.fat_input);
        sugarBar = (SeekBar)findViewById(R.id.sugar_input);
        carBar =(SeekBar)findViewById(R.id.carb_input);
        calBar =(SeekBar)findViewById(R.id.cal_input);
        proBar =(SeekBar)findViewById(R.id.protein_input);
        sodBar = (SeekBar) findViewById(R.id.sod_input);


        fatView = (TextView)findViewById(R.id.fatGoal);
        sugarView = (TextView)findViewById(R.id.sugGoal);
        carbView = (TextView)findViewById(R.id.carbGoal);
        calView = (TextView)findViewById(R.id.calGoal);
        proView = (TextView)findViewById(R.id.protGoal);
        sodView = (TextView)findViewById(R.id.SodGoal);

        Button yourButton = (Button) findViewById(R.id.btn_signup);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                startActivity(new Intent(RegisterActivity.this, ScanActivity.class));

            }
        });


        calBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                calView.setText("Calorie Goal : " + progress);
                snacks.dailyCalories = progress;

            }
        });




        proBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                proView.setText("Protein Goal: " + progress);
                snacks.dailyProtein = progress;
            }
        });





        carBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                carbView.setText("Carb Goal: " + progress);
                snacks.dailyCarbs = progress;
            }
        });



        fatBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                fatView.setText("Fat Goal: " + progress);
                snacks.dailyFat = progress;

            }
        });



        sugarBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sugarView.setText("Sugar Goal: " + progress);
                snacks.dailySugar = progress;
            }
        });




        sodBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sodView.setText("Sodium Goal: " + progress);
                snacks.dailySodium= progress;
            }
        });










    }
}
