package com.example.project.topicprovider;



import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class TopicProvider{


    @SequenceGenerator(
            name = "subjectProvider_sequence",
            sequenceName = "subjectProvider_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subjectProvider_sequence"
    )

    private boolean Approved;
    private Long TopicProvider_id;
    private String TypeProvider;
    private int PostNumber;
    private String City;
    private String StreetName;
    private int StreetNumber;
    private String PasswordHash;
    private String UserName;
    private String email;
    private Long PhoneNumber;

    public TopicProvider(Long id, String typeProvider, int postNumber, String city, String streetName, int streetNumber, boolean approved, String passwordHash, String userName, String email, Long phoneNumber) {
        this.Approved = approved;
        this.TopicProvider_id = id;
        this.TypeProvider = typeProvider;
        this.PostNumber = postNumber;
        this.City = city;
        this.StreetName = streetName;
        this.StreetNumber = streetNumber;
        this.PasswordHash = passwordHash;
        this.UserName = userName;
        this.email = email;
        this.PhoneNumber = phoneNumber;
    }

    public TopicProvider(String typeProvider, int postNumber, String city, String streetName, int streetNumber, boolean approved, String passwordHash, String userName, String email, Long phoneNumber) {
        this.TypeProvider = typeProvider;
        this.PostNumber = postNumber;
        this.City = city;
        this.StreetName = streetName;
        this.StreetNumber = streetNumber;
        this.PasswordHash = passwordHash;
        this.UserName = userName;
        this.email = email;
        this.PhoneNumber = phoneNumber;
    }


    public Long getId() {
        return TopicProvider_id;
    }

    public void setId(Long id) {
        this.TopicProvider_id = id;
    }

    public String getTypeProvider() {
        return TypeProvider;
    }

    public int getPostNumber() {
        return PostNumber;
    }

    public String getCity() {
        return City;
    }

    public String getStreetName() {
        return StreetName;
    }

    public int getStreetNumber() {
        return StreetNumber;
    }


    public String getPasswordHash() {
        return PasswordHash;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setTypeProvider(String typeProvider) {
        TypeProvider = typeProvider;
    }

    public void setPostNumber(int postNumber) {
        PostNumber = postNumber;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        StreetNumber = streetNumber;
    }


    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean isApproved() {
        return Approved;
    }
}
