package com.example.project.person;

import com.example.project.targetAudience.TargetAudience;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.INTEGER)
public class Person implements Serializable {           // extends AppUser

    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long person_id;

    private String firstName;

    private String lastName;

    private Boolean approved;

    @ManyToMany
    private List<TargetAudience> targetAudience_id;

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public List<TargetAudience> getTargetAudience_id() {
        return targetAudience_id;
    }

    public void setTargetAudience_id(List<TargetAudience> targetAudience_id) {
        this.targetAudience_id = targetAudience_id;
    }
}
