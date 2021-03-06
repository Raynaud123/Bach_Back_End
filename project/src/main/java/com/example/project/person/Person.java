package com.example.project.person;

import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRole;
import com.example.project.notification.Notification;
import com.example.project.targetAudience.TargetAudience;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

import static com.example.project.appuser.AppUserRole.STUDENT;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("person")
public class Person extends AppUser implements Serializable {

    private String firstName;
    private String lastName;
    @ManyToMany
    private List<TargetAudience> targetAudience;


    public Person(String firstName, String lastName, List<TargetAudience> targetAudience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetAudience = targetAudience;
    }

    public Person(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> targetAudience) {
        super(username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetAudience = targetAudience;
    }

    public Person(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole,  String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetAudience = targetAudience;
    }

    public Person(String username, String password, String email, String firstName, String lastName,List<TargetAudience> targetAudience) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetAudience = targetAudience;
    }

    public Person(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole,String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, String firstName, String lastName,  List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole,country, city, streetName, postNumber, streetNumber, notification_list);
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetAudience = targetAudience;
    }

    public Person(String email, String phoneNumber, AppUserRole apr, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> ta) {
        super(email, phoneNumber, apr ,country, city, streetName, postNumber, streetNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.targetAudience = ta;
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


    public List<TargetAudience> getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(List<TargetAudience> targetAudience) {
        this.targetAudience = targetAudience;
    }

}
