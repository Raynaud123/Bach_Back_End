package com.example.project.promotor;

import com.example.project.person.Person;
import com.example.project.student.Student;
import com.example.project.topic.Topic;

import javax.persistence.OneToOne;

public class Promotor extends Person {

    @OneToOne
    Topic topic;
    @OneToOne
    Student boostedStudent;


}
