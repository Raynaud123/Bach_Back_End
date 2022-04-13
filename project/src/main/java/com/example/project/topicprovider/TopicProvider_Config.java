//package com.example.project.topicprovider;
//
//import com.example.project.appuser.AppUserRole;
//import com.example.project.targetAudience.Campus;
//import com.example.project.targetAudience.CampusRepository;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.COMPANY;
//
//@Configuration
//public class TopicProvider_Config {
//    @Autowired
//    private CampusRepository campusRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public TopicProvider_Config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean("topicproviderbean")
//    CommandLineRunner commandLineRunner(TopicProviderRepository repository) {
//        Campus c1 = campusRepository.getById(1L);
//        Campus c2 = campusRepository.getById(5L);
//        Campus c3 = campusRepository.getById(9L);
//
//
//        return args -> {
//            TopicProvider topicprovider1 = new TopicProvider(
//                        7L, "Research1", passwordEncoder.encode("research"), "research1@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameReseach1", 9000, 2, true, false, "ReseachGroup1", c1
//            );
//            TopicProvider topicprovider2 = new TopicProvider(
//                    8L, "Research2", passwordEncoder.encode("research"), "research2@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameReseach2", 9000, 3, true, false, "ReseachGroup2", c2
//            );
//            TopicProvider topicprovider3 = new TopicProvider(
//                    9L, "Research3", passwordEncoder.encode("research"), "research3@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameReseach3", 9000, 4, true, false, "ReseachGroup3", c3
//            );
//            TopicProvider topicprovider4 = new TopicProvider(
//                    10L, "Company1", passwordEncoder.encode("company"), "company1@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameCompany1", 9000, 5, true, true, "Company1", null
//            );
//            TopicProvider topicprovider5 = new TopicProvider(
//                    11L, "Company2", passwordEncoder.encode("company"), "company2@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameCompany2", 9000, 6, true, true, "Company2", null
//            );
//            TopicProvider topicprovider6 = new TopicProvider(
//                    12L, "Company3", passwordEncoder.encode("company"), "company3@gmail.com", "+32400000000", COMPANY, false, true, "Belgium", "Ghent", "StreetNameCompany3", 9000, 7, true, true, "Company3", null
//            );
//            repository.saveAll(
//                    List.of(topicprovider1,topicprovider2,topicprovider3,topicprovider4,topicprovider5,topicprovider6)
//            );
//        };
//    }
//
//}
