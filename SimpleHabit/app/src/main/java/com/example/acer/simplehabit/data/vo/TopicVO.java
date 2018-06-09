package com.example.acer.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Acer on 5/24/2018.
 */

public class TopicVO implements HomeScreenVO
{
    @SerializedName("topic-name")
    public String topicName;
    @SerializedName("topic-desc")
    public String topicDesc;
    @SerializedName("icon")
    public String icon;
    @SerializedName("background")
    public String backGround;

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public String getBackGround() {
        return backGround;
    }
}
