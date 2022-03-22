package com.example.project.topic;

import com.sun.xml.bind.v2.model.impl.RuntimeBuiltinLeafInfoImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class Topic_Config {

    String dateString1 = "10/03/2022";
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Topic_Config() throws ParseException {
    }
    @Bean
    CommandLineRunner commandLineRunner(TopicRepository repository) {
        return args -> {
            Topic topic1 = new Topic(
                    1L,"Topic1", 1L, null, null, null, null, null, true, false, "Description1", format.parse(dateString1)
            );
            Topic topic2 = new Topic(
                    2L,"Topic2", 2L, null, null, null, null, null, false, false, "Description2", format.parse(dateString1)
            );
            Topic topic3 = new Topic(
                    3L,"Topic3", 3L, null, null, null, null, null, true, true, "Description3", format.parse(dateString1)
            );
            repository.saveAll(
                    List.of(topic1,topic2,topic3)
            );
        };
    }
}
