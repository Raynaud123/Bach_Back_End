package com.example.project.topicprovider;


import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@NoArgsConstructor
@Entity
public class Company extends TopicProvider{

    private int phoneContact;
    private String firstNameMentor;
    private String lastNameMentor;
    private String emailMentor;


    public Company(Long id, String typeProvider, int postNumber, String city, String streetName, int streetNumber, boolean approved, String passwordHash, String userName, String email, Long phoneNumber, int phoneContact, String firstNameMentor, String lastNameMentor, String email1) {
        super(id, typeProvider, postNumber, city, streetName, streetNumber, approved, passwordHash, userName, email, phoneNumber);
        this.phoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.emailMentor = email1;
    }

    public int getPhoneContact() {
        return phoneContact;
    }

    public String getFirstNameMentor() {
        return firstNameMentor;
    }

    public String getLastNameMentor() {
        return lastNameMentor;
    }

    public String getEmailMentor() {
        return emailMentor;
    }
}
