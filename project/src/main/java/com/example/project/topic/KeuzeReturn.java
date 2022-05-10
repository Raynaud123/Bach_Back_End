package com.example.project.topic;

import com.example.project.student.Student;

public class KeuzeReturn {

    int choice;
    Topic t;

    public KeuzeReturn(int choice, Topic t) {
        this.choice = choice;
        this.t = t;
    }


    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Topic getT() {
        return t;
    }

    public void setT(Topic t) {
        this.t = t;
    }
}
