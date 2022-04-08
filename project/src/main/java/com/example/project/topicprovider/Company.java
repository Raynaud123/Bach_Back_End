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

    public Company(boolean approved, String typeProvider, String name, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(approved, typeProvider, name);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(Long id, String username, String password, String email, String phoneNumber, AppUserRole appUserRole, Boolean locked, Boolean enabled, String country, String city, String streetName, Integer postNumber, Integer streetNumber, boolean approved, String typeProvider, String name, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(id, username, password, email, phoneNumber, appUserRole, locked, enabled, country, city, streetName, postNumber, streetNumber, approved, typeProvider, name);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }

    public Company(String username, String password, String email, boolean approved, String typeProvider, String name, int phoneContact, String firstNameMentor, String lastNameMentor, String emailMentor) {
        super(username, password, email, approved, typeProvider, name);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = emailMentor;
    }
}
