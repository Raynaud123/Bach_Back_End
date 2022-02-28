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

    private Long id;
    private String TypeProvider;
    private int PostNumber;
    private String City;
    private String StreetName;
    private int StreetNumber;
    private boolean Approved;
    private String PasswordHash;
    private String UserName;
    private String Email;
    private Long PhoneNumber;

    public SubjectProvider(Long id) {
        this.id = id;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }







}
