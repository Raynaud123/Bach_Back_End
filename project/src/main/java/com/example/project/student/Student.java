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
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Master master;

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Topic assignedTopic;

    @ManyToMany
    private List<Topic> preferredTopics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Topic FirstChoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Topic SecondChoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Topic ThirdChoice;



    public Student(Master master, Topic assignedTopic, List<Topic> preferredTopics, Topic FirstChoice, Topic SecondChoice, Topic ThirdChoice) {
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.FirstChoice = FirstChoice;
        this.SecondChoice = SecondChoice;
        this.ThirdChoice = ThirdChoice;
    }

    public Student(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, Topic FirstChoice, Topic SecondChoice, Topic ThirdChoice) {
        super(firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.FirstChoice = FirstChoice;
        this.SecondChoice = SecondChoice;
        this.ThirdChoice = ThirdChoice;
    }



    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics, Topic FirstChoice, Topic SecondChoice, Topic ThirdChoice) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.master = master;
        this.assignedTopic = assignedTopic;
        this.preferredTopics = preferredTopics;
        this.FirstChoice = FirstChoice;
        this.SecondChoice = SecondChoice;
        this.ThirdChoice = ThirdChoice;
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

    public Topic getFirstChoice() {
        return FirstChoice;
    }

    public void setFirstChoice(Topic firstChoice) {
        FirstChoice = firstChoice;
    }

    public Topic getSecondChoice() {
        return SecondChoice;
    }

    public void setSecondChoice(Topic secondChoice) {
        SecondChoice = secondChoice;
    }

    public Topic getThirdChoice() {
        return ThirdChoice;
    }

    public void setThirdChoice(Topic thirdChoice) {
        ThirdChoice = thirdChoice;
    }

    @Override
    public String toString() {
        return "Student{" +
                "master=" + master +
                ", assignedTopic=" + assignedTopic +
                ", preferredTopics=" + preferredTopics +
                ", FirstChoice=" + FirstChoice +
                ", SecondChoice=" + SecondChoice +
                ", ThirdChoice=" + ThirdChoice +
                '}';
    }
}
