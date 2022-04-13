//package com.example.project.Master;
//
//import com.example.project.appuser.AppUserRole;
//import com.example.project.promotor.Promotor;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.topic.Topic;
//import com.example.project.topic.TopicController;
//import com.example.project.topicprovider.TopicProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.ADMIN;
//import static com.example.project.appuser.AppUserRole.MASTER;
//
//@Configuration
//public class Master_Config {
//
//    @Autowired
//    private TopicController topicController;
//    @Autowired
//    private TargetAudienceController targetAudienceController;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public Master_Config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(MasterRepository repository) {
//        Topic t5 = topicController.getTopic(5L);
//
//        List<Topic> lijstasP1 = new ArrayList<>();      lijstasP1.add(t5);
//
//        TargetAudience ta1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience ta2 = targetAudienceController.getTargetAudience(10L);
//
//        List<TargetAudience> lijstTA1 = new ArrayList<>();    lijstTA1.add(ta1);
//        List<TargetAudience> lijstTA2 = new ArrayList<>();    lijstTA1.add(ta2);
//
//        return args -> {
//            Master master1 = new Master(
//                        5L, "master1", passwordEncoder.encode("master"), "master1@gmail.com", "+32400000000", MASTER, false, true, "Belgium", "Gent", "StreetNameMaster1", 9000, 100, "MasterFirstName1", "MasterLastName1", true, lijstTA1, lijstasP1, null, null, null
//
//            );
//            Master master2 = new Master(
//                    6L, "master2", passwordEncoder.encode("master"), "master2@gmail.com", "+32400000000", MASTER, false, true, "Belgium", "Gent", "StreetNameMaster2", 9000, 100, "MasterFirstName2", "MasterLastName2", true, lijstTA2, null, null, null, null
//
//            );
//
//            repository.saveAll(
//                    List.of(master1, master2)
//            );
//        };
//    }
//}