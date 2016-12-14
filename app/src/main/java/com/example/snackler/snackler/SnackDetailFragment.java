package com.example.snackler.snackler;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.StringReader;


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
        fakeEntryForDemo.setQuantity(28);
        fakeEntryForDemo.setServingSize(1);
        fakeEntryForDemo.setCalories(159);
        fakeEntryForDemo.setCarbohydrates(8);
        fakeEntryForDemo.setFat(13);
        fakeEntryForDemo.setProtein(6);
        fakeEntryForDemo.setSugar(2);
        fakeEntryForDemo.setSalt(20);

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

        File imageFile = new File(getActivity().getExternalFilesDir(null), "pic.jpg");

        if(imageFile.exists()){

            Matrix matrix = new Matrix();
            matrix.postRotate(90);

            Bitmap imageBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());

            Bitmap rotatedBitmap = Bitmap.createBitmap(imageBitmap , 0, 0, imageBitmap.getWidth(), imageBitmap.getHeight(), matrix, true);

            fakeEntryForDemo.setImage(rotatedBitmap);

            imageView.setImageBitmap(rotatedBitmap);

        }

        Button acceptButton = (Button) rootView.findViewById(R.id.acceptButton);
        Button rescanButton = (Button) rootView.findViewById(R.id.rescanButton);

        Log.i("lkjblk", String.valueOf(((ScanActivity)getActivity()).getNewSnackEntry()));
        if (!((ScanActivity)getActivity()).getNewSnackEntry()) {
            acceptButton.setVisibility(View.GONE);
            rescanButton.setVisibility(View.GONE);
        } else {
            acceptButton.setVisibility(View.VISIBLE);
            rescanButton.setVisibility(View.VISIBLE);
        }


        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todaysSnacks.addEntry(fakeEntryForDemo);
                ScanActivity.onAcceptClick(view);
                ((ScanActivity)getActivity()).setNewSnackEntry(false);
            }
        });

        rescanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanActivity.onRescanClick(view);
                ((ScanActivity)getActivity()).setNewSnackEntry(false);
            }
        });

        return rootView;

    }


}
