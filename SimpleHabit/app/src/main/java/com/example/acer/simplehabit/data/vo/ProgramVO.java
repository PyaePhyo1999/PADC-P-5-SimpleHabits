package com.example.acer.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Acer on 5/26/2018.
 */

public class ProgramVO {
    @SerializedName("program-id")
    public String programId;
    @SerializedName("title")
    public String title;
    @SerializedName("current-period")
    public String currentPeriod;
    @SerializedName("background")
    public String backGround;
    @SerializedName("average-lengths")
    public List<Integer> averageLengths;
    @SerializedName("description")
    public String description;
    public List<SessionsVO> sessions;

    public List<Integer> getAverageLengths() {
        return averageLengths;
    }

    public String getBackGround() {
        return backGround;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public List<SessionsVO> getSessions() {
        return sessions;
    }
    
}
