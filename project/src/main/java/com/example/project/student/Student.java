package com.example.project.student;

import com.example.project.Master.Master;
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

    @ManyToOne
    private Master master;
    @OneToOne
    private Topic assignedTopic;
    @ManyToMany
    private List<Topic> preferredTopics;
    @ManyToMany
    @Column(length = 3)
    private List<Topic> top3Topic;


    public Student(Master master, Topic assignedTopic, List<Topic> preferredTopics, List<Topic> top3Topic) {
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.top3Topic = top3Topic;
    }

    public Student(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, List<Topic> top3Topic) {
        super(firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.top3Topic = top3Topic;
    }

    public Student(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, List<Topic> top3Topic) {
        super(username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.top3Topic = top3Topic;
    }

    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, List<Topic> top3Topic) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.top3Topic = top3Topic;
    }

    public Student(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, List<Topic> top3Topic) {
        super(username, password, email, firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.top3Topic = top3Topic;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Topic getAssignedTopic() {
        return assignedTopic;
    }

    public void setAssignedTopic(Topic assignedTopic) {
        this.assignedTopic = assignedTopic;
    }

    public List<Topic> getPreferredTopics() {
        return preferredTopics;
    }

    public void setPreferredTopics(List<Topic> preferredTopics) {
        this.preferredTopics = preferredTopics;
    }

    public List<Topic> getTop3Topic() {
        return top3Topic;
    }

    public void setTop3Topic(List<Topic> top3Topic) {
        this.top3Topic = top3Topic;
    }


    @Override
    public String toString() {
        return "Student{" +
                "master=" + master +
                ", assignedTopic=" + assignedTopic +
                ", preferredTopics=" + preferredTopics +
                ", top3Topic_ids=" + top3Topic +
                '}';
    }
}
