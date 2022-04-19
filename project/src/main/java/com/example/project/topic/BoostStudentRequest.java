package com.example.project.topic;

import java.io.Serializable;

public class BoostStudentRequest implements Serializable {
    int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
