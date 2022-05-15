package com.example.project.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@ToString
public class UpdateTopicRequest {
    private final String topicName;
    private final Long aantal_studenten;
    private final Boolean approved_topic;
    private final Long boostedStudent;
    private final String description_topic;
    private final Boolean hide_topic;
    private final Long[] keyword_list;
    private final Long promotor;
    private final Long provider;
    private final String release_date;
    private final Long[] student_list;
    private final Long[] tags;
    private final Long[] targetAudiences;


    public String getTopicName() {
        return topicName;
    }

    public Long getAantal_studenten() {
        return aantal_studenten;
    }

    public Boolean getApproved_topic() {
        return approved_topic;
    }

    public Long getBoostedStudent() {
        return boostedStudent;
    }

    public String getDescription_topic() {
        return description_topic;
    }

    public Boolean getHide_topic() {
        return hide_topic;
    }

    public Long[] getKeyword_list() {
        return keyword_list;
    }

    public Long getPromotor() {
        return promotor;
    }

    public Long getProvider() {
        return provider;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Long[] getStudent_list() {
        return student_list;
    }

    public Long[] getTags() {
        return tags;
    }

    public Long[] getTargetAudiences() {
        return targetAudiences;
    }

    @Override
    public String toString() {
        return "CreateTopicRequest{" +
                "topicName='" + topicName + '\'' +
                ", aantal_studenten=" + aantal_studenten +
                ", approved_topic=" + approved_topic +
                ", boostedStudent=" + boostedStudent +
                ", description_topic='" + description_topic + '\'' +
                ", hide_topic=" + hide_topic +
                ", keyword_list=" + Arrays.toString(keyword_list) +
                ", promotor=" + promotor +
                ", provider=" + provider +
                ", release_date='" + release_date + '\'' +
                ", student_list=" + Arrays.toString(student_list) +
                ", tags=" + Arrays.toString(tags) +
                ", targetAudiences=" + Arrays.toString(targetAudiences) +
                '}';
    }
}

