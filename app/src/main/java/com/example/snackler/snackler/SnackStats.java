package com.example.snackler.snackler;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.snackler.snackler.ToolBarSetup;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by magneta94 on 12/5/16.
 */


//CODE THAT SUPPORTS THE GRAPH;

public class SnackStats extends Fragment {

    private static String TAG = "MainActivity";
    public FragmentActivity mainStats;
    private float[] yData = {30f, 70f};
    private String[] xData = {"Remaining", "Used"};
    PieChart pieChart ;
    SnackDay data;
    private View menuInflater;
    View rootView;
    TextView calorieText;
    TextView fatText;
    TextView carbsText;
    TextView proteinText;
    TextView sugarText;
    float caloriePercentage;
    float fatPercentage;
    float carbsPercentage;
    float proteinPercentage;
    float sugarPercentage;




    public SnackStats() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView =  inflater.inflate(R.layout.activity_stats, container, false);
        pieChart = (PieChart) rootView.findViewById(R.id.idPieChart);

        System.err.println("working");
        init();
        calorieButtonPressed();


        calorieText = (TextView) rootView.findViewById(R.id.caloriesPer);
        fatText = (TextView) rootView.findViewById(R.id.fatPer);
        carbsText = (TextView) rootView.findViewById(R.id.carbsPer);
        proteinText = (TextView) rootView.findViewById(R.id.proteinPer);
        sugarText = (TextView) rootView.findViewById(R.id.sugarPer);


        caloriePercentage = (data.getCalories() / data.dailyCalories) * 100;
        fatPercentage = (data.getFat() / data.dailyFat) * 100;
        carbsPercentage = (data.getCarbs() / data.dailyCarbs) * 100;
        proteinPercentage = (data.getProtein() / data.dailyProtein) * 100;
        sugarPercentage = (data.getSugar() / data.dailySugar) * 100;

        System.err.println("Calorie Percentage: " + caloriePercentage);
        if(data.getCalories() == 0 && data.getFat() == 0 && data.getCarbs() == 0
                && data.getProtein() == 0 && data.getSugar() == 0){
            calorieText.setText(0 + "%");
            fatText.setText(0 + "%");
            carbsText.setText(0 + "%");
            proteinText.setText(0 + "%");
            sugarText.setText(0 + "%");
        } else{
            calorieText.setText(Math.round(caloriePercentage) + "%");
            fatText.setText(Math.round(fatPercentage) + "%");
            carbsText.setText(Math.round(carbsPercentage) + "%");
            proteinText.setText(Math.round(proteinPercentage) + "%");
            sugarText.setText(Math.round(sugarPercentage) + "%");
        }






        final Button calorieButton = (Button) rootView.findViewById(R.id.Calories);
        calorieButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.err.println("button pressed");
                calorieButtonPressed();
            }
        });

        final Button fatButton = (Button) rootView.findViewById(R.id.Fat);
        fatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.err.println("button pressed");
                fatButtonPressed();
            }
        });

        final Button carbButton = (Button) rootView.findViewById(R.id.Carbs);
        carbButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.err.println("button pressed");
                carbButtonPressed();
            }
        });

        final Button proteinButton = (Button) rootView.findViewById(R.id.Protein);
        proteinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.err.println("button pressed");
                proteinButtonPressed();
            }
        });

        final Button sugarButton = (Button) rootView.findViewById(R.id.Sugar);
        sugarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.err.println("button pressed");
                sugarButtonPressed();
            }
        });

        return rootView;


    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    }

    public void init(){
        data = MainActivity.getDayObject();
        Log.d(TAG, "onCreate: starting to create chart");
    }

    public void calorieButtonPressed(){
        float used = data.getCalories();
        float remaining = data.dailyCalories - used;

        yData = new float[2];
        yData[0] = remaining;
        yData[1] = used;

        System.err.println("STARTING CALORE: " + (data.getCalories() / data.dailySugar) * 100);
        setUpChart("Calories");
    }

    public void carbButtonPressed(){

        float used = data.getCarbs();
        float remaining = data.dailyCarbs - used;

        yData = new float[2];
        yData[0] = remaining;
        yData[1] = used;

        setUpChart("Carbs");
    }

    public void proteinButtonPressed(){

        float used = data.getProtein();
        float remaining = data.dailyProtein - used;

        yData = new float[2];
        yData[0] = remaining;
        yData[1] = used;

        setUpChart("Protein");
    }

    public void sugarButtonPressed(){

        float used = data.getSugar();
        float remaining = data.dailySugar - used;

        yData = new float[2];
        yData[0] = remaining;
        yData[1] = used;

        setUpChart("Sugar");
    }

    public void fatButtonPressed(){

        float used = data.getFat();
        float remaining = data.dailyFat - used;

        yData = new float[2];
        yData[0] = remaining;
        yData[1] = used;

        setUpChart("Fat");
    }


    private void setUpChart(String macroType){
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(60f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Remaining Snack Calories");
        pieChart.setCenterTextSize(10);
        pieChart.setDrawSliceText(false);
        pieChart.setTransparentCircleRadius(20f);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!

        addDataSet();
        TextView titleTextView = (TextView) rootView.findViewById(R.id.snackTypeTitle);
        titleTextView.setText(macroType);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d(TAG, "onValueSelected: Value select from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());

                int pos1 = e.toString().indexOf("(sum): ");
                String sales = e.toString().substring(pos1 + 7);

                for(int i = 0; i < yData.length; i++){
                    if(yData[i] == Float.parseFloat(sales)){
                        pos1 = i;
                        break;
                    }
                }
                String employee = xData[pos1 + 1];

            }

            @Override
            public void onNothingSelected() {

            }
        });




    }



    private void addDataSet() {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i] , xData[i]));
        }

        for(int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setSliceSpace(4);
        pieDataSet.setValueTextSize(12);


        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.argb(255,81,149,72));
        colors.add(Color.argb(255,136,196,37));


        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        pieChart.postInvalidate();
    }

}

