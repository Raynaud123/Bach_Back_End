package com.example.project.topicprovider;


import com.example.project.appuser.AppUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;


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

    public Company(boolean approved, String typeProvider, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(approved, typeProvider);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String userName, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(userName, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, approved, typeProvider);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String userName, String password, String email, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(userName, password, email, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, approved, typeProvider);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String userName, String password, String email, String phoneNumber, AppUserRole user, boolean approved, String typeProvider, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(userName, password, email, phoneNumber, user, approved, typeProvider);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String userName, String password, String email, AppUserRole user, boolean approved, String typeProvider, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(userName, password, email, user, approved, typeProvider);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }
}
