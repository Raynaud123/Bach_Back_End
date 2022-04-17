package com.example.project.promotor;

import com.example.project.appuser.AppUserRole;
import com.example.project.person.Person;
import com.example.project.student.Student;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import com.fasterxml.jackson.annotation.*;
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
@DiscriminatorValue("promotor")
public class Promotor extends Person implements Serializable {

    @OneToMany(mappedBy="promotor",cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    List<Topic> topic_lijst;

    @OneToOne
    Student boostedStudent;


    public Promotor(List<Topic> topic_lijst, Student boostedStudent) {
        this.topic_lijst = topic_lijst;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_list){
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_list);
        topic_lijst = null;
        boostedStudent = null;
    }

    public Promotor(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> topic_lijst, Student boostedStudent) {
        super(firstName, lastName, approved, targetAudience_id);
        this.topic_lijst = topic_lijst;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> topic_lijst, Student boostedStudent) {
        super(username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
        this.topic_lijst = topic_lijst;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_list, List<Topic> topic_lijst, Student boostedStudent) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_list);
        this.topic_lijst = topic_lijst;
        this.boostedStudent = boostedStudent;
    }

    public Promotor(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> topic_lijst, Student boostedStudent) {
        super(username, password, email, firstName, lastName, approved, targetAudience_id);
        this.topic_lijst = topic_lijst;
        this.boostedStudent = boostedStudent;
    }

    public List<Topic> getTopic() {
        return topic_lijst;
    }

    public void setTopic(List<Topic> topic_lijst) {
        this.topic_lijst = topic_lijst;
    }

    public Student getBoostedStudent() {
        return boostedStudent;
    }

    public void setBoostedStudent(Student boostedStudent) {
        this.boostedStudent = boostedStudent;
    }
}
