package com.example.project.student;

import com.example.project.topic.Topic;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Student {

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long student_id;
    //@ManyToOne + Promotor
    private Long mentor_id;
    @ManyToOne
    private Topic assignedTopic_id;
    @OneToMany
    private List<Topic> prefferedTopics;
    @OneToMany
    @Column(length = 3)
    private List<Topic> top3Topic_ids;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(Long mentor_id) {
        this.mentor_id = mentor_id;
    }

    public Topic getAssignedTopic_id() {
        return assignedTopic_id;
    }

    public void setAssignedTopic_id(Topic assignedTopic_id) {
        this.assignedTopic_id = assignedTopic_id;
    }

    public List<Topic> getPrefferedTopics() {
        return prefferedTopics;
    }

    public void setPrefferedTopics(List<Topic> prefferedTopics) {
        this.prefferedTopics = prefferedTopics;
    }

    public List<Topic> getTop3Topic_ids() {
        return top3Topic_ids;
    }

    public void setTop3Topic_ids(List<Topic> top3Topic_ids) {
        this.top3Topic_ids = top3Topic_ids;
    }
}
