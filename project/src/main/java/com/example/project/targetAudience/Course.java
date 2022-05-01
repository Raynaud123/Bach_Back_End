package com.example.project.targetAudience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long course_id;
    private String course_name;
    private String abbriviationName;

    public Course(String course_name, String abbriviationName) {
        this.course_name = course_name;
        this.abbriviationName = abbriviationName;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getAbbriviationName() {
        return abbriviationName;
    }

    public void setAbbriviationName(String abbriviationName) {
        this.abbriviationName = abbriviationName;
    }
}
