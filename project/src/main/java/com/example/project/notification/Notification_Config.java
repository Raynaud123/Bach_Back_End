//package com.example.project.notification;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//
//@Configuration
//public class Notification_Config {
//
//
//    String dateString1 = "07/05/2022 23:55:55";
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
//                    3L, NotificationSort.AWAITAPPROVED, NotificationObjectSort.COMPANY, 16L,format.parse(dateString1));
//            repository.saveAll(
//                    List.of(n1, n2,n3)
//            );
//        };
//    }
//}