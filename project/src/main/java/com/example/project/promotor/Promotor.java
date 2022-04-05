package com.example.project.promotor;

import com.example.project.appuser.AppUserRole;
import com.example.project.person.Person;
import com.example.project.student.Student;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Promotor extends Person {

    @OneToOne
    Topic topic;
    @OneToOne
    Student boostedStudent;

    public Promotor(Topic topic, Student boostedStudent) {
        this.topic = topic;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Topic topic, Student boostedStudent) {
        super(firstName, lastName, approved, targetAudience_id);
        this.topic = topic;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(String userName, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Topic topic, Student boostedStudent) {
        super(userName, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.topic = topic;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(String userName, String password, String email, String phoneNumber, AppUserRole user, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, Topic topic, Student boostedStudent) {
        super(userName, password, email, phoneNumber, user, firstName, lastName, approved, targetAudience_id);
        this.topic = topic;
        this.boostedStudent = boostedStudent;
    }


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Student getBoostedStudent() {
        return boostedStudent;
    }

    public void setBoostedStudent(Student boostedStudent) {
        this.boostedStudent = boostedStudent;
    }
}
