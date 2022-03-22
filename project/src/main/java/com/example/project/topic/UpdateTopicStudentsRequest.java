package com.example.project.topic;

import com.example.project.student.Student;

import javax.persistence.OneToMany;
import java.util.List;

public class UpdateTopicStudentsRequest {

    Long student_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
}
