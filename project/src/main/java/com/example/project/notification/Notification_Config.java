//package com.example.project.notification;
//
//import com.example.project.master.Master;
//import com.example.project.master.MasterRepository;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.topic.Topic;
//import com.example.project.topic.TopicController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//
//@Configuration
//public class Notification_Config {
//
//    private final PasswordEncoder passwordEncoder;
//
//    String dateString1 = "07/05/2022 23:55:55";
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//
//    public Notification_Config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean("notificationbean")
//    CommandLineRunner commandLineRunner(NotificationRepository repository) {
//
//        return args -> {
//            Notification n1 = new Notification(
//                    1L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 6L, format.parse(dateString1));
//            Notification n2 = new Notification(
//                    2L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 7L,format.parse(dateString1));
//            Notification n3 = new Notification(
//                    3L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 8L,format.parse(dateString1));
//            Notification n4 = new Notification(
//                    4L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 9L,format.parse(dateString1));
//            Notification n5 = new Notification(
//                    5L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 10L,format.parse(dateString1));
//            Notification n6 = new Notification(
//                    6L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 11L,format.parse(dateString1));
//            Notification n7 = new Notification(
//                    7L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 12L,format.parse(dateString1));
//            Notification n8 = new Notification(
//                    8L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 13L,format.parse(dateString1));
//            Notification n9 = new Notification(
//                    9L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 14L,format.parse(dateString1));
//            Notification n10 = new Notification(
//                    10L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.TOPIC, 15L,format.parse(dateString1));
//
//            repository.saveAll(
//                    List.of(n1, n2,n3,n4,n5,n6,n7,n8,n9,n10)
//            );
//        };
//    }
//}