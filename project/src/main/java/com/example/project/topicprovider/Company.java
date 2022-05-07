package com.example.project.topicprovider;


import com.example.project.appuser.AppUserRole;
import com.example.project.targetAudience.Campus;
import com.example.project.topic.Topic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("company")
public class Company extends TopicProvider implements Serializable {

    private int phoneContact;
    private String firstNameMentor;
    private String lastNameMentor;
    private String emailMentor;

    public Company(int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(boolean approved, Boolean isCompany, String name, Campus campus, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(approved, isCompany, name, campus);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, approved, isCompany, name, campus, topic_list);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, approved, isCompany, name, campus, topic_list);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String username, String password, String email, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(username, password, email, approved, isCompany, name, campus, topic_list);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public int getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(int phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getFirstNameMentor() {
        return firstNameMentor;
    }

    public void setFirstNameMentor(String firstNameMentor) {
        this.firstNameMentor = firstNameMentor;
    }

    public String getLastNameMentor() {
        return lastNameMentor;
    }

    public void setLastNameMentor(String lastNameMentor) {
        this.lastNameMentor = lastNameMentor;
    }

    public String getEmailMentor() {
        return emailMentor;
    }

    public void setEmailMentor(String emailMentor) {
        this.emailMentor = emailMentor;
    }
}
