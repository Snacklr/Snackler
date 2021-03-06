package com.example.snackler.snackler;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.charts.PieChart;

import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by magneta94 on 12/13/16.
 */

public class ScanActivity extends AppCompatActivity{

    public static PieChart pieChart;
    private Toolbar toolbar;
    public TabLayout tabLayout;
    public static ViewPager viewPager;
    private boolean newSnackEntry;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager();

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        ToolBarSetup.setupTabIcons(tabLayout);

        newSnackEntry = false;

        // Button scanButton = (Button) findViewById(R.id.scanItemButton);
       /* scanButton.setOnClickListener(new View.OnClickListener() {

            @Override
             public void onClick(View view) {

              //We ned to decide how to do scanning, but for now I am just passing a "snack search term" to the downloader
             Intent searchSnackIntent = new Intent(MainActivity.this, NutritionDownloaderActivity.class);
             searchSnackIntent.putExtra(NutritionDownloaderActivity.SNACK_TO_SEARCH, "Grape");
             startActivity(searchSnackIntent);
                               }

        });*/


    }


    public void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        adapter.addFrag(new SnackStats(), "Progress");
        adapter.addFrag(new CameraFragment(), "Home");
        adapter.addFrag(new SnackDetailFragment(), "Recent");
        viewPager.setAdapter(adapter);
    }


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

    public void setNewSnackEntry(Boolean bool) {
        newSnackEntry = bool;
    }

    public boolean getNewSnackEntry() {
        return newSnackEntry;
    }

    public static void onAcceptClick(View v) {viewPager.setCurrentItem(0);}


    public static void onRescanClick(View v) {
        viewPager.setCurrentItem(1);
    }

    public ViewPager getViewPager() {
        return this.viewPager;
    }




}