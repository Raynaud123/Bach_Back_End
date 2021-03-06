package com.example.project.targetAudience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @OneToOne(cascade = CascadeType.ALL)
    private Campus campus;
    @OneToOne(cascade = CascadeType.ALL)
    private Course course;
    private Boolean hide;


    public TargetAudience(Long targetAudience_id, Campus campus, Course course, Boolean hide) {
        this.targetAudience_id = targetAudience_id;
        this.campus = campus;
        this.course = course;
        this.hide = hide;
    }

    public TargetAudience(Campus campus, Course course, Boolean hide) {
        this.campus = campus;
        this.course = course;
        this.hide = hide;
    }

    public Long getTargetAudience_id() {
        return targetAudience_id;
    }

    public void setTargetAudience_id(Long targetAudience_id) {
        this.targetAudience_id = targetAudience_id;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }
}
