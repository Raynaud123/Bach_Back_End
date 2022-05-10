package com.example.project.topic;

public class UpdateTopicStudentsRequest {

    Long[] student_id;
    int aantalStudenten;

    public UpdateTopicStudentsRequest(Long[] student_id, int aantalStudenten) {
        this.student_id = student_id;
        this.aantalStudenten = aantalStudenten;
    }

    public Long[] getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long[] student_id) {
        this.student_id = student_id;
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public void setAantalStudenten(int aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
    }
}
