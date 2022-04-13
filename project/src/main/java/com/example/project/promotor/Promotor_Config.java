//package com.example.project.promotor;
//
//import com.example.project.student.Student;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.targetAudience.TargetAudienceRepository;
//import com.example.project.topic.Topic;
//import com.example.project.topic.TopicController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.PROMOTOR;
//
//@Configuration
//public class Promotor_Config {
//
//    @Autowired
//    private TopicController topicController;
//    @Autowired
//    private TargetAudienceController targetAudienceController;
//
//    private final PasswordEncoder passwordEncoder;
//
//
//    public Promotor_Config(PasswordEncoder passwordEncoder) throws ParseException {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(PromotorRepository repository) {
//        Topic t1 = topicController.getTopic(1L);
//        Topic t2 = topicController.getTopic(2L);
//        Topic t3 = topicController.getTopic(3L);
//        Topic t4 = topicController.getTopic(4L);
//        List<Topic> lijstT1 = new ArrayList<>();      lijstT1.add(t1);
//        List<Topic> lijstT2 = new ArrayList<>();      lijstT2.add(t2);
//        List<Topic> lijstT3 = new ArrayList<>();      lijstT3.add(t3);
//        List<Topic> lijstT4 = new ArrayList<>();      lijstT4.add(t4);
//
//        TargetAudience ta1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience ta2 = targetAudienceController.getTargetAudience(10L);
//        TargetAudience ta3 = targetAudienceController.getTargetAudience(19L);
//        List<TargetAudience> lijstTA1 = new ArrayList<>();    lijstTA1.add(ta1);
//        List<TargetAudience> lijstTA2 = new ArrayList<>();    lijstTA1.add(ta2);
//        List<TargetAudience> lijstTA3 = new ArrayList<>();    lijstTA1.add(ta3);
//
//
//        return args -> {
//            Promotor promotor1 = new Promotor(
//                    13L, "promotor1", passwordEncoder.encode("promotor"), "promotor1@gmail.com", "+32400000000", PROMOTOR, false, true, "Belgium", "Ghent", "StreetNamePromotor1", 9000, 99, "PromotorFirstName1", "PromotorLastName1", true, lijstTA1, lijstT1, null
//            );
//            Promotor promotor2 = new Promotor(
//                    14L, "promotor2", passwordEncoder.encode("promotor"), "promotor2@gmail.com", "+32400000000", PROMOTOR, false, true, "Belgium", "Ghent", "StreetNamePromotor2", 9000, 101, "PromotorFirstName2", "PromotorLastName2", true, lijstTA1, lijstT2, null
//            );
//            Promotor promotor3 = new Promotor(
//                    15L, "promotor3", passwordEncoder.encode("promotor"), "promotor3@gmail.com", "+32400000000", PROMOTOR, false, true, "Belgium", "Ghent", "StreetNamePromotor3", 9000, 102, "PromotorFirstName3", "PromotorLastName3", true, lijstTA2, lijstT3, null
//            );
//            Promotor promotor4 = new Promotor(
//                    16L, "promotor4", passwordEncoder.encode("promotor"), "promotor4@gmail.com", "+32400000000", PROMOTOR, false, true, "Belgium", "Ghent", "StreetNamePromotor4", 9000, 103, "PromotorFirstName4", "PromotorLastName4", true, lijstTA3, lijstT4, null
//            );
//
//            repository.saveAll(
//                    List.of(promotor1,promotor2,promotor3,promotor4)
//            );
//        };
//    }
//}
