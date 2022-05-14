package com.example.project.student;

import com.example.project.master.Master;
import com.example.project.appuser.AppUserRole;
import com.example.project.notification.Notification;
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


    private Boolean assignedTopic;

    @ManyToMany
    private List<Topic> preferredTopics;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Topic_choice> choices = new ArrayList<>();


    public Student(Master master, Topic assignedTopic, List<Topic> preferredTopics) {
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
    }

    public Student(String firstName, String lastName,  List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics) {
        super(firstName, lastName, targetAudience_id);
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
    }


    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName,  List<TargetAudience> targetAudience_id, Master master, Topic assignedTopic, List<Topic> preferredTopics) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName,  targetAudience_id);
        this.master = master;

        this.preferredTopics = preferredTopics;
    }

    public Student(Master master, List<Topic> preferredTopics, List<Topic_choice> choices) {
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
        this.choices = choices;
    }

    public Student(String firstName, String lastName, List<TargetAudience> targetAudience, Master master, List<Topic> preferredTopics, List<Topic_choice> choices) {
        super(firstName, lastName, targetAudience);
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
        this.choices = choices;
    }

    public Student(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> targetAudience, Master master, List<Topic> preferredTopics, List<Topic_choice> choices) {
        super(username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience);
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
        this.choices = choices;
    }

    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> targetAudience, Master master, List<Topic> preferredTopics, List<Topic_choice> choices) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience);
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
        this.choices = choices;
    }

    public Student(String username, String password, String email, String firstName, String lastName, List<TargetAudience> targetAudience, Master master, List<Topic> preferredTopics, List<Topic_choice> choices) {
        super(username, password, email, firstName, lastName, targetAudience);
        this.master = master;
        this.assignedTopic = false;
        this.preferredTopics = preferredTopics;
        this.choices = choices;
    }

    public Student(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, String firstName, String lastName, List<TargetAudience> targetAudience, Master master, List<Topic> preferredTopics, List<Topic_choice> choices) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, notification_list, firstName, lastName, targetAudience);
        this.master = master;
        this.preferredTopics = preferredTopics;
        this.choices = choices;
        this.assignedTopic = false;
    }


    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Boolean getAssignedTopic() {
        return assignedTopic;
    }

    public void setAssignedTopic(Boolean assignedTopic) {
        this.assignedTopic = assignedTopic;
    }

    public List<Topic> getPreferredTopics() {
        return preferredTopics;
    }

    public void setPreferredTopics(List<Topic> preferredTopics) {
        this.preferredTopics = preferredTopics;
    }

}
