package com.example.project.topic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UpdateTopicApproveRequest {
    private final Long topic_id;
    private final Boolean approved;

}
