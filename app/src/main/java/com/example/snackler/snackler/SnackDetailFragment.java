package com.example.snackler.snackler;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SnackDetailFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_snack_detail, container, false);

        TextView snackTitleView = (TextView) rootView.findViewById(R.id.snackTitle);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.snackImage);
        TextView quantityView = (TextView) rootView.findViewById(R.id.snackQuantity);
        TextView servingSizeView = (TextView) rootView.findViewById(R.id.snackServingSize);
        TextView snackTimeView = (TextView) rootView.findViewById(R.id.snackTime);

        TextView calorieView = (TextView) rootView.findViewById(R.id.calories);
        TextView carbsView = (TextView) rootView.findViewById(R.id.carbs);
        TextView fatView = (TextView) rootView.findViewById(R.id.fat);
        TextView proteinView = (TextView) rootView.findViewById(R.id.protein);
        TextView sugarView = (TextView) rootView.findViewById(R.id.sugar);
        TextView sodiumView = (TextView) rootView.findViewById(R.id.sodium);

        SnackEntry fakeEntryForDemo = new SnackEntry("Grapes");
        fakeEntryForDemo.setQuantity(50);
        fakeEntryForDemo.setServingSize(1.3);
        fakeEntryForDemo.setCalories(200);
        fakeEntryForDemo.setCarbohydrates(30);
        fakeEntryForDemo.setFat(1);
        fakeEntryForDemo.setProtein(3);
        fakeEntryForDemo.setSugar(20);
        fakeEntryForDemo.setSalt(100);

        String grapeImageURL = "http://www.tpswinegrapes.com/images/660/images//white-grapes.jpg";


        snackTitleView.setText(fakeEntryForDemo.getSnackType());
        //imageView.setImageBitmap(fakeEntryForDemo.getImage());
        quantityView.setText(String.valueOf(fakeEntryForDemo.getQuantity())+" g");
        servingSizeView.setText(String.valueOf(fakeEntryForDemo.getServingSize()));
        snackTimeView.setText(fakeEntryForDemo.getTimestamp().toString().substring(0,16));

        calorieView.setText(String.valueOf(fakeEntryForDemo.getCalories())+" cal");
        carbsView.setText(String.valueOf(fakeEntryForDemo.getCarbohydrates())+" g");
        fatView.setText(String.valueOf(fakeEntryForDemo.getFat())+" g");
        proteinView.setText(String.valueOf(fakeEntryForDemo.getProtein())+" g");
        sugarView.setText(String.valueOf(fakeEntryForDemo.getSugar())+ "g");
        sodiumView.setText(String.valueOf(fakeEntryForDemo.getSalt())+ "mg");


        return rootView;

    }

}
