package com.example.project.topicprovider;


import com.example.project.appuser.AppUserRole;
import com.example.project.targetAudience.Campus;
import com.example.project.topic.Topic;
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
@DiscriminatorValue("company")
public class Company implements Serializable {

    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private long id;

    private String phoneContact;
    private String firstNameMentor;
    private String lastNameMentor;
    private String emailMentor;

    public Company(String phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(boolean approved, Boolean isCompany, String name, Campus campus, String phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String username, String password, String email, String phoneNumber, AppUserRole appUserRole,  String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list, String phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list, String phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String username, String password, String email, boolean approved, Boolean isCompany, String name, Campus campus, List<Topic> topic_list, String phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
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
