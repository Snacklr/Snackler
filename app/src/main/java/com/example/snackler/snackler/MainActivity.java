package com.example.snackler.snackler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.content.Intent;

import com.github.mikephil.charting.charts.PieChart;

import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static PieChart pieChart;
    private Toolbar toolbar;
    public TabLayout tabLayout;
    private static ViewPager viewPager;

    private static SnackDay todaysSnacks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);



        todaysSnacks = new SnackDay(new Date(Calendar.DATE));

        todaysSnacks.dailyCalories = 800;
        todaysSnacks.dailyFat = 90;
        todaysSnacks.dailyCarbs = 500;
        todaysSnacks.dailyProtein = 100;
        todaysSnacks.dailySugar = 80;

        SnackEntry testEntry = new SnackEntry("Grape");
        testEntry.setCalories(500);
        testEntry.setFat(40);
        testEntry.setCarbohydrates(50);
        testEntry.setProtein(70);
        testEntry.setSugar(25);

        todaysSnacks.addEntry(testEntry);



        Button logButton = (Button) findViewById(R.id.login);

        logButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ScanActivity.class));
            }
        });

        Button signUpButton = (Button) findViewById(R.id.signup);
        signUpButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }



    public void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        adapter.addFrag(new SnackStats(), "Progress");
        adapter.addFrag(new CameraFragment(), "Home");
        adapter.addFrag(new SnackDetailFragment(), "Recent");
        viewPager.setAdapter(adapter);
    }

    public ViewPager getViewPager() {
        return this.viewPager;
    }

    public static SnackDay getDayObject() {return todaysSnacks;}

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }



        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public static void onAcceptClick(View v) {
        viewPager.setCurrentItem(0);
    }

    public void onRescanClick(View v) {
        viewPager.setCurrentItem(1);
    }


}
