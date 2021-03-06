package com.example.project.topic;

import java.io.Serializable;

public class BoostStudentRequest implements Serializable {
    private int[] studentId;

    public BoostStudentRequest(){
        this.studentId = new int[10];
    }

    public BoostStudentRequest(int[] studentId) {
        this.studentId = studentId;
    }

    public int[] getStudentId() {
        return studentId;
    }

    public void setStudentId(int[] studentId) {
        this.studentId = studentId;
    }
}
