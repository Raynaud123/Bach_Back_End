package com.example.project.person;

import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import com.example.project.targetAudience.TargetAudience;
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
@DiscriminatorValue("person")
//@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.INTEGER)
public class Person extends AppUser implements Serializable {
    /*@SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long person_id;*/
    private String firstName;

    private String lastName;

    private Boolean approved;

    @ManyToMany
    private List<TargetAudience> targetAudience_id;

    public Person(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.approved = approved;
        this.targetAudience_id = targetAudience_id;
    }

    public Person(String userName, String password, String email, Integer phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id) {
        super(userName, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.approved = approved;
        this.targetAudience_id = targetAudience_id;
    }

    public Person(String userName, String password, String email, Integer phoneNumber, AppUserRole user, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id) {
        super(userName, password, email, phoneNumber, user);
        this.firstName = firstName;
        this.lastName = lastName;
        this.approved = approved;
        this.targetAudience_id = targetAudience_id;
    }

    //getters en setters
    /*public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public List<TargetAudience> getTargetAudience_id() {
        return targetAudience_id;
    }

    public void setTargetAudience_id(List<TargetAudience> targetAudience_id) {
        this.targetAudience_id = targetAudience_id;
    }


}
