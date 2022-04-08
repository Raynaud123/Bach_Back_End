package com.example.project.student;

import com.example.project.appuser.AppUserRole;
import com.example.project.person.Person;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("student")
public class Student extends Person implements Serializable {
/*
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
    private Long student_id;*/

    //@ManyToOne + Promotor
    private Long mentor_id;
    @ManyToOne
    private Topic assignedTopic_id;
    @OneToMany
    private List<Topic> preferredTopics;
    @OneToMany
    @Column(length = 3)
    private List<Topic> top3Topic_ids;

    public Student(Long mentor_id, Topic assignedTopic_id, List<Topic> preferredTopics, List<Topic> top3Topic_ids) {
        this.mentor_id = mentor_id;
        this.assignedTopic_id = assignedTopic_id;
        this.preferredTopics = preferredTopics;
        this.top3Topic_ids = top3Topic_ids;
    }

    public Student(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Long mentor_id, Topic assignedTopic_id, List<Topic> preferredTopics, List<Topic> top3Topic_ids) {
        super(firstName, lastName, approved, targetAudience_id);
        this.mentor_id = mentor_id;
        this.assignedTopic_id = assignedTopic_id;
        this.preferredTopics = preferredTopics;
        this.top3Topic_ids = top3Topic_ids;
    }

    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Long mentor_id, Topic assignedTopic_id, List<Topic> preferredTopics, List<Topic> top3Topic_ids) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.mentor_id = mentor_id;
        this.assignedTopic_id = assignedTopic_id;
        this.preferredTopics = preferredTopics;
        this.top3Topic_ids = top3Topic_ids;
    }

    public Student(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Long mentor_id, Topic assignedTopic_id, List<Topic> preferredTopics, List<Topic> top3Topic_ids) {
        super(username, password, email, firstName, lastName, approved, targetAudience_id);
        this.mentor_id = mentor_id;
        this.assignedTopic_id = assignedTopic_id;
        this.preferredTopics = preferredTopics;
        this.top3Topic_ids = top3Topic_ids;
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

    public List<Topic> getPreferredTopics() {
        return preferredTopics;
    }

    public void setPreferredTopics(List<Topic> preferredTopics) {
        this.preferredTopics = preferredTopics;
    }

    public List<Topic> getTop3Topic_ids() {
        return top3Topic_ids;
    }

    public void setTop3Topic_ids(List<Topic> top3Topic_ids) {
        this.top3Topic_ids = top3Topic_ids;
    }
}
