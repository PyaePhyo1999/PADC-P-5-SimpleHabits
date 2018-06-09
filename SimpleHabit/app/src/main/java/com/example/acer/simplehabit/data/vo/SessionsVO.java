package com.example.acer.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Acer on 5/25/2018.
 */

public class SessionsVO {
    @SerializedName("session-id")
    public String sessionId;
    @SerializedName("title")
    public String title;
    @SerializedName("length-in-seconds")
    public int lengthInSecond;
    @SerializedName("file-path")
    public String filePath;

    public String getTitle() {
        return title;
    }

    public int getLengthInSecond() {
        return lengthInSecond;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getSessionId() {
        return sessionId;
    }

}
