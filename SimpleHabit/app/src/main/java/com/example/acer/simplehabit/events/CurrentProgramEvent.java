package com.example.acer.simplehabit.events;

import com.example.acer.simplehabit.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by Acer on 5/25/2018.
 */

public class CurrentProgramEvent {
    public CurrentProgramVO loadCurrentProgram;

    public CurrentProgramVO getLoadCurrentProgram() {
        return loadCurrentProgram;
    }
    public CurrentProgramEvent(CurrentProgramVO loadCurrentProgram)
    {
        this.loadCurrentProgram = loadCurrentProgram;
    }
}
