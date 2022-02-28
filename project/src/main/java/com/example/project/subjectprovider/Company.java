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

    public Company(Long id) {
        super(id);
    }
}
