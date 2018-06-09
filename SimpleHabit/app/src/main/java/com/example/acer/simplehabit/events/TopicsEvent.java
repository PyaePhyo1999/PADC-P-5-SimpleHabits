package com.example.acer.simplehabit.events;

import com.example.acer.simplehabit.data.vo.TopicVO;

import java.util.List;

/**
 * Created by Acer on 5/24/2018.
 */

public class TopicsEvent {
    private List<TopicVO> loadTopics;

    public List<TopicVO> getLoadTopics() {
        return loadTopics;
    }

    public TopicsEvent(List<TopicVO> loadTopics) {

        this.loadTopics = loadTopics;
    }
}
