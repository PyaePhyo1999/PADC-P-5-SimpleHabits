package com.example.acer.simplehabit.network.responses;

import com.example.acer.simplehabit.data.vo.TopicVO;

import java.util.List;

/**
 * Created by Acer on 5/24/2018.
 */

public class GetTopicsResponse {
    public int code;
    public String message;
    public String apiVersion;
    public String page;
    public List<TopicVO> topics;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TopicVO> getTopics() {
        return topics;
    }
}
