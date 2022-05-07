package com.example.project.master;

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
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience);
    }

    public Master(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(username, password, email, firstName, lastName, approved, targetAudience);
    }

    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, notification_list, firstName, lastName, approved, targetAudience);
    }

    //
//    @ManyToMany
//    private List<Topic> asPromotor_topic_list;
//    @OneToMany
//    private List<Topic> awaitApproved_topic_list;
//    @OneToMany
//    private List<TopicProvider> awaitApproved_topicProvider_list;
//    @OneToMany
//    private List<Promotor> awaitApproved_promotor_list;
//
//
//    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience_id, List<Topic> asPromotor_topic_list, List<Topic> awaitApproved_topic_list, List<TopicProvider> awaitApproved_topicProvider_list, List<Promotor> awaitApproved_promotor_list) {
//        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience_id);
//        this.asPromotor_topic_list = asPromotor_topic_list;
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
//
//    public Master(String username, String password, String email, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience, List<Topic> asPromotor_topic_list, List<Topic> awaitApproved_topic_list, List<TopicProvider> awaitApproved_topicProvider_list, List<Promotor> awaitApproved_promotor_list) {
//        super(username, password, email, firstName, lastName, approved, targetAudience);
//        this.asPromotor_topic_list = asPromotor_topic_list;
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
//
//    public Master(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, List<Notification> notification_list, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience, List<Topic> asPromotor_topic_list, List<Topic> awaitApproved_topic_list, List<TopicProvider> awaitApproved_topicProvider_list, List<Promotor> awaitApproved_promotor_list) {
//        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, notification_list, firstName, lastName, approved, targetAudience);
//        this.asPromotor_topic_list = asPromotor_topic_list;
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
//
//    public Master(List<Topic> asPromotor_topic_list, List<Topic> awaitApproved_topic_list, List<TopicProvider> awaitApproved_topicProvider_list, List<Promotor> awaitApproved_promotor_list) {
//        this.asPromotor_topic_list = asPromotor_topic_list;
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
//
//    public Master(String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience, List<Topic> asPromotor_topic_list, List<Topic> awaitApproved_topic_list, List<TopicProvider> awaitApproved_topicProvider_list, List<Promotor> awaitApproved_promotor_list) {
//        super(firstName, lastName, approved, targetAudience);
//        this.asPromotor_topic_list = asPromotor_topic_list;
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
//
//    public Master(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, String firstName, String lastName, Boolean approved, List<TargetAudience> targetAudience, List<Topic> asPromotor_topic_list, List<Topic> awaitApproved_topic_list, List<TopicProvider> awaitApproved_topicProvider_list, List<Promotor> awaitApproved_promotor_list) {
//        super(username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, firstName, lastName, approved, targetAudience);
//        this.asPromotor_topic_list = asPromotor_topic_list;
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
//
//    public List<Topic> getAsPromotor_topic_list() {
//        return asPromotor_topic_list;
//    }
//
//    public void setAsPromotor_topic_list(List<Topic> asPromotor_topic_list) {
//        this.asPromotor_topic_list = asPromotor_topic_list;
//    }
//
//    public List<Topic> getAwaitApproved_topic_list() {
//        return awaitApproved_topic_list;
//    }
//
//    public void setAwaitApproved_topic_list(List<Topic> awaitApproved_topic_list) {
//        this.awaitApproved_topic_list = awaitApproved_topic_list;
//    }
//
//    public List<TopicProvider> getAwaitApproved_topicProvider_list() {
//        return awaitApproved_topicProvider_list;
//    }
//
//    public void setAwaitApproved_topicProvider_list(List<TopicProvider> awaitApproved_topicProvider_list) {
//        this.awaitApproved_topicProvider_list = awaitApproved_topicProvider_list;
//    }
//
//    public List<Promotor> getAwaitApproved_promotor_list() {
//        return awaitApproved_promotor_list;
//    }
//
//    public void setAwaitApproved_promotor_list(List<Promotor> awaitApproved_promotor_list) {
//        this.awaitApproved_promotor_list = awaitApproved_promotor_list;
//    }
}
