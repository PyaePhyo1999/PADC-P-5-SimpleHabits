package com.example.acer.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.adapters.SeriesAdapter;
import com.example.acer.simplehabit.data.models.SimpleHabitModel;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.delegates.CurrentProgramDelegate;
import com.example.acer.simplehabit.events.CurrentProgramEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/23/2018.
 */

public class StartHereViewHolder extends BaseViewHolder<CurrentProgramVO>{
    @BindView(R.id.tv_simple_habit_starter)
    TextView tvSimpleHabitStarter;

    @BindView(R.id.tv_day)
    TextView tvDay;

    @BindView(R.id.tv_time_for_habit_starter)
    TextView tvTFHStarter;
    @BindView(R.id.rl_current)
    RelativeLayout rlCurrent;
    private CurrentProgramDelegate mCurrentProgramDelegate;
    public StartHereViewHolder(View itemView,CurrentProgramDelegate currentProgramDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mCurrentProgramDelegate = currentProgramDelegate;
        rlCurrent.setOnClickListener(this);
    }

    @Override
    public void setData(CurrentProgramVO data) {
        tvSimpleHabitStarter.setText(data.getTitle());
        tvDay.setText(data.getCurrentPeriod());
        String avgLength="";
        for(int length: data.getAverageLengths()){
            avgLength += length+",";
        }
        tvTFHStarter.setText(avgLength+" mins");
    }



    @Override
    public void onClick(View view) {
        mCurrentProgramDelegate.onTapCurrentProgramDelegate();

    }
}
