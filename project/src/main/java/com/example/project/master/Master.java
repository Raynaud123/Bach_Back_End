package com.example.project.master;

import com.example.project.appuser.AppUserRole;
import com.example.project.notification.Notification;
import com.example.project.person.Person;
import com.example.project.targetAudience.TargetAudience;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static com.example.project.appuser.AppUserRole.MASTER;

@Getter
@Setter
@Entity
@DiscriminatorValue("master")
public class Master extends Person implements Serializable {

    public Master() {
    }

    public Master(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(firstName, lastName,  targetAudience);
    }

    public Master(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, firstName, lastName,  targetAudience);
    }

    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole,country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience);
    }

    public Master(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(username, password, email, firstName, lastName, targetAudience);
    }

    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, notification_list, firstName, lastName,  targetAudience);
    }

    public Master(String firstName, String lastName, String streetName, Integer streetNumber, String phoneNumber, Integer postNumber, String country, String city, String email, List<TargetAudience> ta) {
        super(email, phoneNumber, MASTER, country, city, streetName, postNumber, streetNumber, firstName, lastName,  ta);
    }
}
