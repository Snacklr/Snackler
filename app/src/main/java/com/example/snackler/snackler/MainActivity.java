package com.example.snackler.snackler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.snackler.snackler.ToolBarSetup;
import com.github.mikephil.charting.charts.PieChart;
import android.view.View;
import android.widget.Button;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static PieChart pieChart;
    private Toolbar toolbar;
    public TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager();

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        ToolBarSetup.setupTabIcons(tabLayout);


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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(new SnackStats(), "Progress");
        adapter.addFrag(new TwoFragment(), "Home");
        adapter.addFrag(new ThreeFragment(), "History");
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





}
