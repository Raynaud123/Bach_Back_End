package com.example.project.subjectprovider;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@NoArgsConstructor
@Entity
public class Company extends SubjectProvider{
    private int PhoneContact;
    private String firstNameMentor;
    private String lastNameMentor;
    private String email;


    public Company(Long id, String typeProvider, int postNumber, String city, String streetName, int streetNumber, boolean approved, String passwordHash, String userName, String email, Long phoneNumber, int phoneContact, String firstNameMentor, String lastNameMentor, String email1) {
        super(id, typeProvider, postNumber, city, streetName, streetNumber, approved, passwordHash, userName, email, phoneNumber);
        PhoneContact = phoneContact;
        this.firstNameMentor = firstNameMentor;
        this.lastNameMentor = lastNameMentor;
        this.email = email1;
    }
}
