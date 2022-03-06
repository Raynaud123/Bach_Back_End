package com.example.project.student;

import com.example.project.topic.Topic;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
    private Long top3_student_id;
    private Long mentor_student_id;
    //private Long topic_student_id;

    @ManyToOne
    @JoinColumn(name = "topic_id_student_id")
    private Topic topic_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getTop3_student_id() {
        return top3_student_id;
    }

    public void setTop3_student_id(Long top3_student_id) {
        this.top3_student_id = top3_student_id;
    }

    public Long getMentor_student_id() {
        return mentor_student_id;
    }

    public void setMentor_student_id(Long mentor_student_id) {
        this.mentor_student_id = mentor_student_id;
    }

    public Topic getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Topic topic_id) {
        this.topic_id = topic_id;
    }
}
