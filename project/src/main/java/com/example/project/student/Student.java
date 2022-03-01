package com.example.project.student;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Student {

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long student_id;
    private Long top3_id;
    private Long mentor_id;

    public Student(Long top3_id, Long mentor_id) {
        this.top3_id = top3_id;
        this.mentor_id = mentor_id;
    }

    public Long getTop3IdStudent() {
        return top3_id;
    }

    public Long getMentorIdStudent() {
        return mentor_id;
    }

    public void setIdStudent() {this.student_id = student_id;}
}
