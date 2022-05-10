package com.example.project.topic;

public class KeuzeTweeReturn {

    int choiceStudentEen;
    int getChoiceStudentTwee;
    Topic t;

    public KeuzeTweeReturn(int choiceStudentEen, int getChoiceStudentTwee, Topic t) {
        this.choiceStudentEen = choiceStudentEen;
        this.getChoiceStudentTwee = getChoiceStudentTwee;
        this.t = t;
    }

    public int getChoiceStudentEen() {
        return choiceStudentEen;
    }

    public void setChoiceStudentEen(int choiceStudentEen) {
        this.choiceStudentEen = choiceStudentEen;
    }

    public int getGetChoiceStudentTwee() {
        return getChoiceStudentTwee;
    }

    public void setGetChoiceStudentTwee(int getChoiceStudentTwee) {
        this.getChoiceStudentTwee = getChoiceStudentTwee;
    }

    public Topic getT() {
        return t;
    }

    public void setT(Topic t) {
        this.t = t;
    }
}
