package com.example.acer.simplehabit.adapters;

import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 5/18/2018.
 */

public class MeditateCategoryAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentsList;
    private List<String>  mTabTitleList;

    public MeditateCategoryAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
        mFragmentsList = new ArrayList<>();
        mTabTitleList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    public CharSequence getPageTitle(int position)
    {
        return mTabTitleList.get(position);
    }

    public void addTap(Fragment fragment, String title){
        mFragmentsList.add(fragment);
        mTabTitleList.add(title);
        notifyDataSetChanged();

    }

}
