package com.example.project.subjectprovider;



import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class SubjectProvider{

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

    private Long SubjectProvider_id;
    private String TypeProvider;
    private int PostNumber;
    private String City;
    private String StreetName;
    private int StreetNumber;
    private boolean Approved;
    private String PasswordHash;
    private String UserName;
    private String email;
    private Long PhoneNumber;

    public SubjectProvider(Long id, String typeProvider, int postNumber, String city, String streetName, int streetNumber, boolean approved, String passwordHash, String userName, String email, Long phoneNumber) {
        this.SubjectProvider_id = id;
        this.TypeProvider = typeProvider;
        this.PostNumber = postNumber;
        this.City = city;
        this.StreetName = streetName;
        this.StreetNumber = streetNumber;
        this.Approved = approved;
        this.PasswordHash = passwordHash;
        this.UserName = userName;
        this.email = email;
        this.PhoneNumber = phoneNumber;
    }


    public Long getId() {
        return SubjectProvider_id;
    }

    public void setId(Long id) {
        this.SubjectProvider_id = id;
    }

}
