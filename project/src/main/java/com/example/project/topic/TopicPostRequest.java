package com.example.project.topic;

import java.io.Serializable;
import java.util.Arrays;

public class TopicPostRequest implements Serializable {

    String topicName;
    String description_topic;
    long aantal_studenten;
    long[] targetAudience;
    long[] keywords;
    long provider_id;


    public TopicPostRequest(String topicName, String description_topic, int aantal_studenten, long[] targetAudience, long[] keywords, long provider_id) {
        this.topicName = topicName;
        this.description_topic = description_topic;
        this.aantal_studenten = aantal_studenten;
        this.targetAudience = targetAudience;
        this.keywords = keywords;
        this.provider_id = provider_id;
    }

    @Override
    public String toString() {
        return "TopicPostRequest{" +
                "topicName='" + topicName + '\'' +
                ", description_topic='" + description_topic + '\'' +
                ", aantal_studenten=" + aantal_studenten +
                ", targetAudience=" + Arrays.toString(targetAudience) +
                ", keywords=" + Arrays.toString(keywords) +
                ", provider_id=" + provider_id +
                '}';
    }
}
