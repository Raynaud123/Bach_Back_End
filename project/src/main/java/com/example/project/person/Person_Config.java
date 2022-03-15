package com.example.project.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Person_Config {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Person_Config() throws ParseException {
    }
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            Person person1 = new Person("Raynaud", "Cornille", true, new ArrayList<>()
            );
            Person person2 = new Person("Marieke", "Beke", false, new ArrayList<>()
            );
            Person person3 = new Person("Marthe", "Spriet", true, new ArrayList<>()
            );
            Person person4 = new Person("Demo", "User", false, new ArrayList<>()
            );
            repository.saveAll(
                    List.of(person1,person2,person3,person4)
            );
        };
    }
}