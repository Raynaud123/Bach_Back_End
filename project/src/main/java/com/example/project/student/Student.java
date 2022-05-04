package com.example.project.student;

import com.example.project.Master.Master;
import com.example.project.appuser.AppUserRole;
import com.example.project.person.Person;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("student")
public class Student extends Person implements Serializable {

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Master master;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Topic assignedTopic;

    @ManyToMany
    private List<Topic> preferredTopics;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Topic_choice> choices = new ArrayList<>();


    public Student(Master master, Topic assignedTopic, List<Topic> preferredTopics, Topic FirstChoice, Topic SecondChoice, Topic ThirdChoice) {
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
    }

    public Student(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, Topic FirstChoice, Topic SecondChoice, Topic ThirdChoice) {
        super(firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
    }


    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, Topic FirstChoice, Topic SecondChoice, Topic ThirdChoice) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
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


    @Override
    public String toString() {
        return "Student{" +
                "master=" + master +
                ", assignedTopic=" + assignedTopic +
                ", preferredTopics=" + preferredTopics +
                ", choices=" + choices +
                '}';
    }
}
