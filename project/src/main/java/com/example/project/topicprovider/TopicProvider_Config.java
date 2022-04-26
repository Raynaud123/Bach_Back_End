package com.example.project.topicprovider;

import com.example.project.targetAudience.Campus;
import com.example.project.targetAudience.CampusRepository;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static com.example.project.appuser.AppUserRole.COMPANY;

@Configuration
public class TopicProvider_Config {
    @Autowired
    private CampusRepository campusRepository;
    @Autowired
    private TopicRepository topicRepository;

    private final PasswordEncoder passwordEncoder;

    public TopicProvider_Config(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean("topicproviderbean")
    CommandLineRunner commandLineRunner(TopicProviderRepository repository) {
        Campus c1 = campusRepository.getById(1L);
        Campus c2 = campusRepository.getById(5L);
        Campus c3 = campusRepository.getById(9L);

        Topic t1 = topicRepository.getById(11L);
        Topic t2 = topicRepository.getById(12L);
        Topic t3 = topicRepository.getById(13L);
        Topic t4 = topicRepository.getById(14L);
        Topic t5 = topicRepository.getById(15L);

        List<Topic> lijstT1 = new ArrayList<>();    lijstT1.add(t1);
        List<Topic> lijstT2 = new ArrayList<>();    lijstT2.add(t2);
        List<Topic> lijstT3 = new ArrayList<>();    lijstT3.add(t3);
        List<Topic> lijstT4 = new ArrayList<>();    lijstT4.add(t4);
        List<Topic> lijstT5 = new ArrayList<>();    lijstT5.add(t5);


        return args -> {
            TopicProvider topicprovider1 = new TopicProvider(
                        "Research1", passwordEncoder.encode("research"), "research1@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameReseach1", 9000, 2, true, false, "ReseachGroup1", c1, lijstT1
            );
            TopicProvider topicprovider2 = new TopicProvider(
                    "Research2", passwordEncoder.encode("research"), "research2@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameReseach2", 9000, 3, true, false, "ReseachGroup2", c2, lijstT2
            );
            TopicProvider topicprovider3 = new TopicProvider(
                    "Research3", passwordEncoder.encode("research"), "research3@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameReseach3", 9000, 4, true, false, "ReseachGroup3", c3, lijstT3
            );
            TopicProvider topicprovider4 = new TopicProvider(
                    "Company1", passwordEncoder.encode("company"), "company1@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameCompany1", 9000, 5, true, true, "Company1", null, lijstT4
            );
            TopicProvider topicprovider5 = new TopicProvider(
                    "Company2", passwordEncoder.encode("company"), "company2@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameCompany2", 9000, 6, true, true, "Company2", null, lijstT5
            );
            TopicProvider topicprovider6 = new TopicProvider(
                    "Company3", passwordEncoder.encode("company"), "company3@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameCompany3", 9000, 7, true, true, "Company3", null, null
            );
            repository.saveAll(
                    List.of(topicprovider1,topicprovider2,topicprovider3,topicprovider4,topicprovider5,topicprovider6)
            );
        };
    }

}
