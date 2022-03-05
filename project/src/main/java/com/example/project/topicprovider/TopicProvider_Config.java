//package com.example.project.topicprovider;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class TopicProvider_Config {
//    @Bean
//    CommandLineRunner commandLineRunner(TopicProviderRepository repository) {
//        return args -> {
//            TopicProvider raynaud = new TopicProvider(
//                    "Admin",800,"Veldegem","Rembertstraat",99, true, "test", "raynaud", "raynaud@gmail.com",9L
//            );
//            TopicProvider marieke = new TopicProvider(
//                    "user",900,"Brugge","Zilverpand",99, false, "iets", "marieke", "marieke@gmail.com",8L
//            );
//            TopicProvider marthe = new TopicProvider(
//                    "Mast",600,"Gent","Korenmarkt",99, false, "see", "marthe", "marthe@gmail.com",7L
//            );
//            repository.saveAll(
//                    List.of(raynaud,marieke,marthe)
//            );
//        };
//    }
//
//}
