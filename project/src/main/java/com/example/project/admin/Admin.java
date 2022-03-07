package com.example.project.admin;

import com.example.project.person.Person;
import com.example.project.topicprovider.TopicProvider;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Entity;
import java.util.List;


@NoArgsConstructor
@Entity
public class Admin extends Person {



}
