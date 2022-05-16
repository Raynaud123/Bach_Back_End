//package com.example.project.master;
//
//import com.example.project.notification.Notification;
//import com.example.project.notification.NotificationController;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.topic.TopicController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.MASTER;
//
//@Configuration
//public class Master_Config {
//
//    @Autowired
//    private TopicController topicController;
//    @Autowired
//    private TargetAudienceController targetAudienceController;
//    @Autowired
//    private NotificationController notificationController;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public Master_Config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean("masterbean")
//    CommandLineRunner commandLineRunner(MasterRepository repository) {
//        Notification n1 = notificationController.getNotification(1L);
//        Notification n2 = notificationController.getNotification(2L);
//        Notification n3 = notificationController.getNotification(3L);
//
//        List<Notification> lijstNotification1 = new ArrayList<>();      lijstNotification1.add(n1);  lijstNotification1.add(n2);  lijstNotification1.add(n3);
//
//
//        TargetAudience ta1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience ta2 = targetAudienceController.getTargetAudience(10L);
//
//        List<TargetAudience> lijstTA1 = new ArrayList<>();    lijstTA1.add(ta1);
//        List<TargetAudience> lijstTA2 = new ArrayList<>();    lijstTA2.add(ta2);
//
//        return args -> {
//            Master master1 = new Master(
//                    1L, "master1", passwordEncoder.encode("master"), "master1@gmail.com", "+32400000000", MASTER, false, true, "Belgium", "Ghent", "StreetNameMaster1", 9000, 100, lijstNotification1, "MasterFirstName1", "MasterLastName1", true, lijstTA1
//            );
//            Master master2 = new Master(
//                    2L, "master2", passwordEncoder.encode("master"), "master2@gmail.com", "+32400000000", MASTER, false, true, "Belgium", "Ghent", "StreetNameMaster2", 9000, 100, "MasterFirstName2", "MasterLastName2", true, lijstTA2
//            );
//
//            repository.saveAll(
//                    List.of(master1, master2)
//            );
//        };
//    }
//}