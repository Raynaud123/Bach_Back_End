package com.example.project.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@ToString
public class UpdateStudentRequest {
    private final String firstName;
    private final String lastName;
    private final Long[] targetAudience;
    private final String streetName;
    private final Long streetNumber;
    private final Long postNumber;
    private final Long phoneNumber;
    private final String city;
    private final String country;
    private final String email;
    private final Long assignedTopic;
    private final Long master;
    private final Boolean approved;

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

    public Long getStreetNumber() {
        return streetNumber;
    }

    public Long getPostNumber() {
        return postNumber;
    }

    public Long getPhoneNumber() {
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

    public Long getAssignedTopic() {
        return assignedTopic;
    }

    public Long getMaster() {
        return master;
    }

    public Boolean getApproved() {
        return approved;
    }

    @Override
    public String toString() {
        return "UpdateStudentRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", targetAudience=" + Arrays.toString(targetAudience) +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", postNumber=" + postNumber +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", assignedTopic=" + assignedTopic +
                ", master=" + master +
                ", approved=" + approved +
                '}';
    }
}

