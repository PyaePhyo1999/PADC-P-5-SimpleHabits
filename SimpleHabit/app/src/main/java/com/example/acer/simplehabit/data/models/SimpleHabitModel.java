package com.example.acer.simplehabit.data.models;

import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.HomeScreenVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.events.CategoryProgramEvent;
import com.example.acer.simplehabit.events.CurrentProgramEvent;
import com.example.acer.simplehabit.events.DataReadyEvent;
import com.example.acer.simplehabit.events.TopicsEvent;
import com.example.acer.simplehabit.network.SimpleHabitDataAgent;
import com.example.acer.simplehabit.network.SimpleHabitRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 5/24/2018.
 */

public class SimpleHabitModel {
    private static SimpleHabitModel sObjectInstance;
    private List<HomeScreenVO> mData;


    private SimpleHabitDataAgent mSimpleHabitDataAgent;

    private SimpleHabitModel() {
        mSimpleHabitDataAgent = SimpleHabitRetrofitDataAgent.getsObjectInstance();
        EventBus.getDefault().register(this);
        mData = new ArrayList<>();

    }
    public CurrentProgramVO getCurrentProgram(){
        for(HomeScreenVO data : mData){
            if (data instanceof CurrentProgramVO){
                return (CurrentProgramVO)data;
            }
        }
        return null;
    }
    public ProgramVO getProgram(String categoryId, String categoryProgramId){
        for(int i=0; i<mData.size(); i++){
            if(mData.get(i) instanceof CategoriesProgramsVO){
                if(((CategoriesProgramsVO) mData.get(i)).getCategoryId().equals(categoryId)){
                    for(int j = 0; j < ((CategoriesProgramsVO) mData.get(i)).getPrograms().size(); j++){
                        if(((CategoriesProgramsVO) mData.get(i)).getPrograms().get(j).getProgramId().equals(categoryProgramId)){
                            return ((CategoriesProgramsVO) mData.get(i)).getPrograms().get(j);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static SimpleHabitModel getsObjectInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new SimpleHabitModel();
        }

        return sObjectInstance;
    }

    public void loadData() {
        SimpleHabitRetrofitDataAgent.getsObjectInstance().onLoadCurrentProgram();
    }
    @Subscribe
    public void onCurrentDataLoaded(CurrentProgramEvent event){
        mData.add(event.getLoadCurrentProgram());
        SimpleHabitRetrofitDataAgent.getsObjectInstance().onLoadCategoryProgram();
    }
    @Subscribe
    public void onCategoryDataLoaded(CategoryProgramEvent event) {
        mData.addAll(event.getLoadCategory());
        SimpleHabitRetrofitDataAgent.getsObjectInstance().onLoadTopics();

    }

    @Subscribe
    public void onTopicDataLoaded(TopicsEvent event) {
        mData.addAll(event.getLoadTopics());
        DataReadyEvent dataReadyEvent = new DataReadyEvent(mData);
        EventBus.getDefault().post(dataReadyEvent);

    }
}

