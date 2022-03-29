//package com.example.project.topic;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//@Configuration
//public class Topic_Config {
//
//    String dateString1 = "29/03/2022";
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//    public Topic_Config() {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(TopicRepository repository) {
//        return args -> {
//            Topic topic1 = new Topic(
//                    6L,"Topic6", 5L,null,  null, null, null, null, null, true, false, "Description6", format.parse(dateString1)
//            );
//            Topic topic2 = new Topic(
//                    7L,"Topic7", 5L, null,null, null, null, null, null, false, false, "Description7", format.parse(dateString1)
//            );
//            Topic topic3 = new Topic(
//                    8L,"Topic8", null, null, null, null, null, null, null, true, true, "Description8", format.parse(dateString1)
//            );
//            Topic topic4 = new Topic(
//                    9L,"Topic9", null, null, null, null, null, null, null, true, true, "Description9", format.parse(dateString1)
//            );
//            Topic topic5 = new Topic(
//                    10L,"Topic10", 5L, null, null, null, null, null, null, true, true, "Description10", format.parse(dateString1)
//            );
//            repository.saveAll(
//                    List.of(topic1,topic2,topic3,topic4,topic5)
//            );
//        };
//    }
//}
