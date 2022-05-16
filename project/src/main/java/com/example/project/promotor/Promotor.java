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
import java.util.ArrayList;
import java.util.List;

import static com.example.project.appuser.AppUserRole.MASTER;
import static com.example.project.appuser.AppUserRole.PROMOTOR;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("promotor")
public class Promotor extends Person implements Serializable {

//    @OneToMany(mappedBy="promotor")
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "topic_id")
//    @JsonIdentityReference(alwaysAsId = true)
//    List<Topic> topic_lijst;

//    @OneToOne
//    Student boostedStudent;


    boolean approved;

    public Promotor(List<Topic> topic_lijst, Student boostedStudent) {
 //       this.topic_lijst = topic_lijst;
    //    this.boostedStudent = boostedStudent;
    }

    public Promotor(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_list){
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience_list);
        this.approved = approved;
    }

    public Promotor(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> topic_lijst, Student boostedStudent) {
        super(firstName, lastName, targetAudience_id);
        approved = true;;
    }

    public Promotor(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> topic_lijst, Student boostedStudent) {
        super(username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience_id);
        approved = true;
    }

//    public Promotor(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_list) {
//        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience_list);
//        approved = true;
//    }

    public Promotor(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> topic_lijst, Student boostedStudent) {
        super(username, password, email, firstName, lastName, targetAudience_id);
        approved = true;
    }

    public Promotor(String firstName, String lastName, String streetName, Integer streetNumber, String phoneNumber, Integer postNumber, String country, String city, String email, List<TargetAudience> ta, Boolean approve) {
        super(email, phoneNumber, PROMOTOR, country, city, streetName, postNumber, streetNumber, firstName, lastName,  ta);
        approved = approve;
    }

    public List<Topic> getTopic() {
        List<Topic> test = new ArrayList<>();
        return test;
   //     return topic_lijst;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        approved = approved;
    }

//    public void setTopic(List<Topic> topic_lijst) {
  //      this.topic_lijst = topic_lijst;
    //}
//
//    public Student getBoostedStudent() {
//        return boostedStudent;
//    }
//
//    public void setBoostedStudent(Student boostedStudent) {
//        this.boostedStudent = boostedStudent;
//    }
}
