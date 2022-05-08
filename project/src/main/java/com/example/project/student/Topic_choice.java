package com.example.project.student;

import com.example.project.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Topic_choice")
public class Topic_choice implements Serializable {

    @SequenceGenerator(
            name = "choice_sequence",
            sequenceName = "choice_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "choice_sequence"
    )
    private long choice_id;

    @ManyToOne
    @JoinColumn(name="topic_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "topic_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name="student_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Student student;

    @Column(name = "choice")
    private int choice;


    public Topic_choice(Student student, Topic topic, int choice) {
        this.student = student;
        this.topic = topic;
        this.choice = choice;
    }

    public Topic_choice() {

    }


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic_choice that = (Topic_choice) o;
        return choice == that.choice && Objects.equals(topic, that.topic) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, student, choice);
    }

}