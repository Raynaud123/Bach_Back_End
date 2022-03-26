package com.example.project.targetAudience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Campus {
    @SequenceGenerator(
            name = "campus_sequence",
            sequenceName = "campus_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "campus_sequence"
    )
    private Long campus_id;
    private String campus_name;
    private String country;
    private Integer postNumber;
    private String City;
    private String streetName;
    private Integer streetNumber;


    public Campus(Long campus_id, String campus_name, String country, Integer postNumber, String city, String streetName, Integer streetNumber) {
        this.campus_id = campus_id;
        this.campus_name = campus_name;
        this.country = country;
        this.postNumber = postNumber;
        City = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Campus(String campus_name, String country, Integer postNumber, String city, String streetName, Integer streetNumber) {
        this.campus_name = campus_name;
        this.country = country;
        this.postNumber = postNumber;
        City = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Long getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(Long campus_id) {
        this.campus_id = campus_id;
    }

    public String getCampus_name() {
        return campus_name;
    }

    public void setCampus_name(String campus_name) {
        this.campus_name = campus_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }
}
