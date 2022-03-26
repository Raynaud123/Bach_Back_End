package com.example.project.targetAudience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TargetAudience {
    @SequenceGenerator(
            name = "targetAudience_sequence",
            sequenceName = "targetAudience_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "targetAudience_sequence"
    )
    private Long targetAudience_id;
    @OneToMany
    private List<Campus> campus;
    @OneToMany
    private List<Course> course;
    private Boolean hide_targetAudience;


    public TargetAudience(Long targetAudience_id, List<Campus> campus, List<Course> course, Boolean hide_targetAudience) {
        this.targetAudience_id = targetAudience_id;
        this.campus = campus;
        this.course = course;
        this.hide_targetAudience = hide_targetAudience;
    }

    public void addCampus(Campus c){
        campus.add(c);
    }
    public void addCourse(Course c){
        course.add(c);
    }
    public Long getTargetAudience_id() {
        return targetAudience_id;
    }

    public void setTargetAudience_id(Long targetAudience_id) {
        this.targetAudience_id = targetAudience_id;
    }

    public List<Campus> getCampus() {
        return campus;
    }

    public void setCampus(List<Campus> campus) {
        this.campus = campus;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Boolean getHide_targetAudience() {
        return hide_targetAudience;
    }

    public void setHide_targetAudience(Boolean hide_targetAudience) {
        this.hide_targetAudience = hide_targetAudience;
    }
}
