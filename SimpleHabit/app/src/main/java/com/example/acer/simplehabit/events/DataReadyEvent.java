package com.example.acer.simplehabit.events;

import com.example.acer.simplehabit.data.vo.HomeScreenVO;

import java.util.List;

/**
 * Created by Acer on 5/26/2018.
 */

public class DataReadyEvent {
    private List<HomeScreenVO> mData;

    public List<HomeScreenVO> getData() {
        return mData;
    }

    public DataReadyEvent(List<HomeScreenVO> data)
    {
        this.mData = data;
    }
}
