package com.example.project.admin;

import com.example.project.appuser.AppUserRole;
import com.example.project.person.Person;
import com.example.project.targetAudience.TargetAudience;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;



@Entity
public class Admin extends Person {

    public Admin() {
    }

    public Admin(String firstName, String lastName, List<TargetAudience> targetAudience_id) {
        super(firstName, lastName,targetAudience_id);
    }

    public Admin(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> targetAudience_id) {
        super(username, password, email, phoneNumber, appUserRole,  country, city, streetName, postNumber, streetNumber, firstName, lastName,  targetAudience_id);
    }

    public Admin(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole,  String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, List<TargetAudience> targetAudience_id) {
        super(id, username, password, email, phoneNumber, appUserRole,  country, city, streetName, postNumber, streetNumber, firstName, lastName,  targetAudience_id);
    }

    public Admin(String username, String password, String email, String firstName, String lastName, List<TargetAudience> targetAudience_id) {
        super(username, password, email, firstName, lastName, targetAudience_id);
    }
}
