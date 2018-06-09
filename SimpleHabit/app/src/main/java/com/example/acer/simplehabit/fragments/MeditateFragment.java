package com.example.acer.simplehabit.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.adapters.MeditateCategoryAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/18/2018.
 */

public class MeditateFragment extends Fragment {

    @BindView(R.id.vp_meditate)
    ViewPager vpMeditate;

    @BindView(R.id.tl_meditate)
    TabLayout mTabLayout;

    private MeditateCategoryAdapter mMeditateCategoryAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditate,container,false);
        ButterKnife.bind(this,view);
        mMeditateCategoryAdapter = new MeditateCategoryAdapter(getFragmentManager());
        mMeditateCategoryAdapter.addTap(new OnTheGoFragment(),"ON THE GO");
        mMeditateCategoryAdapter.addTap(new SeriesFragment(),"SERIES");
        mMeditateCategoryAdapter.addTap(new TeachersFragment(),"TEACHERS");
        vpMeditate.setAdapter(mMeditateCategoryAdapter);
        mTabLayout.setupWithViewPager(vpMeditate);
        return view;
    }
}
