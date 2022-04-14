package com.example.project.topic;

import java.io.Serializable;

public class TopicPostRequest implements Serializable {

    String topicName;
    String description_topic;
    long aantal_studenten;
    long[] targetAudience;
    long[] keywords;
    long provider_id;


    public TopicPostRequest(String topicName, String descriptio_topic, int aantal_studenten, long[] targetAudience, long[] keywords, long provider_id) {
        this.topicName = topicName;
        this.description_topic = descriptio_topic;
        this.aantal_studenten = aantal_studenten;
        this.targetAudience = targetAudience;
        this.keywords = keywords;
        this.provider_id = provider_id;
    }
}
