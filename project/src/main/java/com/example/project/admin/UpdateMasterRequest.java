package com.example.project.admin;

import com.example.project.targetAudience.TargetAudience;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UpdateMasterRequest {
    private final String firstName;
    private final String lastName;
    private final Long[] targetAudience;
    private final String streetName;
    private final Integer streetNumber;
    private final Integer postNumber;
    private final String phoneNumber;
    private final String city;
    private final String country;
    private final String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long[] getTargetAudience() {
        return targetAudience;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UpdateMasterRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", targetAudience=" + targetAudience +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", postNumber=" + postNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

