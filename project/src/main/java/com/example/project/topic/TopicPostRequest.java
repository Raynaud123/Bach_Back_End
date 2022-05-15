package com.example.project.topic;

import java.io.Serializable;
import java.util.Arrays;

public class TopicPostRequest implements Serializable {

    private String topicName;
    private String description_topic;
    private long aantal_studenten;
    private long[] targetAudience;
    private long[] keywords;
    private long promotor_id;
    private long provider_id;
    private String firstname;
    private String lastname;
    private String email;
    private String tel;

    public TopicPostRequest(){

    }
    public TopicPostRequest(String topicName, String description_topic, long aantal_studenten, long[] targetAudience, long[] keywords, long provider_id, String firstname, String lastname, String email, String tel) {
        this.topicName = topicName;
        this.description_topic = description_topic;
        this.aantal_studenten = aantal_studenten;
        this.targetAudience = targetAudience;
        this.keywords = keywords;
        this.provider_id = provider_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.tel = tel;
        this.promotor_id = Long.MAX_VALUE;
    }
    public TopicPostRequest(String topicName, String description_topic, int aantal_studenten, long[] targetAudience, long[] keywords, long provider_id) {
        this.topicName = topicName;
        this.description_topic = description_topic;
        this.aantal_studenten = aantal_studenten;
        this.targetAudience = targetAudience;
        this.keywords = keywords;
        this.provider_id = provider_id;
        this.firstname = null;
        this.lastname = null;
        this.email = null;
        this.tel = null;
        this.promotor_id = Long.MAX_VALUE;
    }

    public TopicPostRequest(String topicName, String description_topic, long aantal_studenten, long[] targetAudience, long[] keywords, long promotor_id, long provider_id) {
        this.topicName = topicName;
        this.description_topic = description_topic;
        this.aantal_studenten = aantal_studenten;
        this.targetAudience = targetAudience;
        this.keywords = keywords;
        this.promotor_id = promotor_id;
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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription_topic() {
        return description_topic;
    }

    public void setDescription_topic(String description_topic) {
        this.description_topic = description_topic;
    }

    public long getAantal_studenten() {
        return aantal_studenten;
    }

    public void setAantal_studenten(long aantal_studenten) {
        this.aantal_studenten = aantal_studenten;
    }

    public long[] getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(long[] targetAudience) {
        this.targetAudience = targetAudience;
    }

    public long[] getKeywords() {
        return keywords;
    }

    public void setKeywords(long[] keywords) {
        this.keywords = keywords;
    }

    public long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(long provider_id) {
        this.provider_id = provider_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getPromotor_id() {
        return promotor_id;
    }

    public void setPromotor_id(long promotor_id) {
        this.promotor_id = promotor_id;
    }
}
