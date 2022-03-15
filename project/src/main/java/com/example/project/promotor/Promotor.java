package com.example.project.promotor;

import com.example.project.person.Person;
import com.example.project.student.Student;
import com.example.project.topic.Topic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Promotor extends Person {

    @OneToOne
    Topic topic;
    @OneToOne
    Student boostedStudent;


}
