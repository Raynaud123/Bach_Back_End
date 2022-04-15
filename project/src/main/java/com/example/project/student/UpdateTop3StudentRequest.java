package com.example.project.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UpdateTop3StudentRequest {
    private final Long topic1_id;
    private final Long topic2_id;
    private final Long topic3_id;
}