package com.example.acer.simplehabit.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.adapters.CategoriesAdapter;
import com.example.acer.simplehabit.adapters.SeriesAdapter;
import com.example.acer.simplehabit.data.models.SimpleHabitModel;
import com.example.acer.simplehabit.delegates.CategoryProgramDelegate;
import com.example.acer.simplehabit.delegates.CurrentProgramDelegate;
import com.example.acer.simplehabit.events.CategoryProgramEvent;
import com.example.acer.simplehabit.events.CurrentProgramEvent;
import com.example.acer.simplehabit.events.DataReadyEvent;
import com.example.acer.simplehabit.events.TopicsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/18/2018.
 */

public class SeriesFragment extends Fragment {

    @BindView(R.id.rv_series)
    RecyclerView rvSeries;

    private SeriesAdapter mSeriesAdapter ;
    private CurrentProgramDelegate mCurrentProgramDelegate;
    private CategoryProgramDelegate mCategoryProgramDelegate;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        mSeriesAdapter = new SeriesAdapter(getContext(),mCurrentProgramDelegate,mCategoryProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvSeries.setLayoutManager(linearLayoutManager);
        rvSeries.setAdapter(mSeriesAdapter);
        SimpleHabitModel.getsObjectInstance().loadData();


        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCurrentProgramDelegate = (CurrentProgramDelegate) context;
        mCategoryProgramDelegate = (CategoryProgramDelegate) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadData(DataReadyEvent event){
        mSeriesAdapter.setNewData(event.getData());
    }

}
