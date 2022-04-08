package com.example.project.person;

import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import com.example.project.targetAudience.TargetAudience;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("person")
public class Person extends AppUser implements Serializable {

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

    public Person(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.approved = approved;
        this.targetAudience_id = targetAudience_id;
    }

    public Person(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.approved = approved;
        this.targetAudience_id = targetAudience_id;
    }

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
