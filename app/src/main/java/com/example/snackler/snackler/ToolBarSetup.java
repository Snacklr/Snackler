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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magneta94 on 12/5/16.
 */

public class ToolBarSetup {


    public static void setupTabIcons(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setIcon( R.drawable.ic_insert_chart_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_add_a_photo_black_24dp);
        tabLayout.getTabAt(2).setIcon( R.drawable.ic_watch_later_black_24dp);
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
