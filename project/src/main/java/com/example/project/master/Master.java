package com.example.project.Master;

import com.example.project.appuser.AppUserRole;
import com.example.project.notification.Notification;
import com.example.project.person.Person;
import com.example.project.promotor.Promotor;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import com.example.project.topicprovider.TopicProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue("master")
public class Master extends Person implements Serializable {

    public Master() {
    }

    public Master(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(firstName, lastName, approved, targetAudience);
    }

    public Master(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience);
    }

    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole,country, city, streetName, postNumber, streetNumber, firstName, lastName, targetAudience);
    }

    public Master(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(username, password, email, firstName, lastName, approved, targetAudience);
    }

    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole, country, city, streetName, postNumber, streetNumber, notification_list, firstName, lastName,  targetAudience);
    }

}
