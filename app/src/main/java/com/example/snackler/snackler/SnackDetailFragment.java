package com.example.snackler.snackler;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class SnackDetailFragment extends Fragment {

    private static SnackDay todaysSnacks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_snack_detail, container, false);

        todaysSnacks = MainActivity.getDayObject();

        TextView snackTitleView = (TextView) rootView.findViewById(R.id.snackTitle);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.snackImage);
        TextView quantityView = (TextView) rootView.findViewById(R.id.snackQuantity);
        TextView servingSizeView = (TextView) rootView.findViewById(R.id.snackServingSize);
//        TextView snackTimeView = (TextView) rootView.findViewById(R.id.snackTime);

        TextView calorieView = (TextView) rootView.findViewById(R.id.calories);
        TextView carbsView = (TextView) rootView.findViewById(R.id.carbs);
        TextView fatView = (TextView) rootView.findViewById(R.id.fat);
        TextView proteinView = (TextView) rootView.findViewById(R.id.protein);
        TextView sugarView = (TextView) rootView.findViewById(R.id.sugar);
        TextView sodiumView = (TextView) rootView.findViewById(R.id.sodium);

//        ImageView oldCalorieBar = (ImageView) rootView.findViewById(R.id.calorieBar);
//        ImageView oldCarbsBar = (ImageView) rootView.findViewById(R.id.carbBar);
//        ImageView oldFatBar = (ImageView) rootView.findViewById(R.id.fatBar);
//        ImageView oldProteinBar = (ImageView) rootView.findViewById(R.id.proteinBar);
//        ImageView oldSugarBar = (ImageView) rootView.findViewById(R.id.sugarBar);
//        ImageView oldSodiumBar = (ImageView) rootView.findViewById(R.id.sodiumBar);

        macroBarView calorieBar = (macroBarView) rootView.findViewById(R.id.calorieBarView);
        macroBarView carbsBar = (macroBarView) rootView.findViewById(R.id.carbsBarView);
        macroBarView fatBar = (macroBarView) rootView.findViewById(R.id.fatBarView);
        macroBarView proteinBar = (macroBarView) rootView.findViewById(R.id.proteinBarView);
        macroBarView sugarBar = (macroBarView) rootView.findViewById(R.id.sugarBarView);
        macroBarView sodiumBar = (macroBarView) rootView.findViewById(R.id.sodiumBarView);

        final SnackEntry fakeEntryForDemo = new SnackEntry("Pistachios");
        fakeEntryForDemo.setQuantity(50);
        fakeEntryForDemo.setServingSize(1.3);
        fakeEntryForDemo.setCalories(200);
        fakeEntryForDemo.setCarbohydrates(30);
        fakeEntryForDemo.setFat(1);
        fakeEntryForDemo.setProtein(3);
        fakeEntryForDemo.setSugar(20);
        fakeEntryForDemo.setSalt(100);

        //String grapeImageURL = "http://www.tpswinegrapes.com/images/660/images//white-grapes.jpg";
        String grapeImageURL = "http://www.trail-running-blog.com/wp-content/uploads/2013/03/pistachios.jpg";
        
        snackTitleView.setText(fakeEntryForDemo.getSnackType());
        //imageView.setImageBitmap(fakeEntryForDemo.getImage());
        quantityView.setText(String.valueOf(fakeEntryForDemo.getQuantity())+" g");
        servingSizeView.setText(String.valueOf(fakeEntryForDemo.getServingSize()));
//        snackTimeView.setText(fakeEntryForDemo.getTimestamp().toString().substring(0,16));

        calorieView.setText(String.valueOf(fakeEntryForDemo.getCalories())+" cal");
        carbsView.setText(String.valueOf(fakeEntryForDemo.getCarbohydrates())+" g");
        fatView.setText(String.valueOf(fakeEntryForDemo.getFat())+" g");
        proteinView.setText(String.valueOf(fakeEntryForDemo.getProtein())+" g");
        sugarView.setText(String.valueOf(fakeEntryForDemo.getSugar())+ "g");
        sodiumView.setText(String.valueOf(fakeEntryForDemo.getSalt())+ "mg");

        calorieBar.setWidth(todaysSnacks.getCalories(),fakeEntryForDemo.getCalories(),todaysSnacks.dailyCalories);
        carbsBar.setWidth(todaysSnacks.getCarbs(),fakeEntryForDemo.getCarbohydrates(),todaysSnacks.dailyCarbs);
        fatBar.setWidth(todaysSnacks.getFat(),fakeEntryForDemo.getFat(),todaysSnacks.dailyFat);
        proteinBar.setWidth(todaysSnacks.getProtein(),fakeEntryForDemo.getProtein(),todaysSnacks.dailyProtein);
        sugarBar.setWidth(todaysSnacks.getSugar(),fakeEntryForDemo.getSugar(),todaysSnacks.dailySugar);
        sodiumBar.setWidth(todaysSnacks.getSodium(),fakeEntryForDemo.getSalt(),todaysSnacks.dailySodium);

        Button acceptButton = (Button) rootView.findViewById(R.id.acceptButton);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todaysSnacks.addEntry(fakeEntryForDemo);
                ScanActivity.onAcceptClick(view);
            }
        });

        return rootView;

    }

}
