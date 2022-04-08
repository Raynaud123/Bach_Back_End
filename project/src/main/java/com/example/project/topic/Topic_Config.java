//package com.example.project.topic;
//
//import com.example.project.keyword.Keyword;
//import com.example.project.keyword.KeywordController;
//import com.example.project.student.Student;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.targetAudience.TargetAudienceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//public class Topic_Config {
//    @Autowired
//    private TargetAudienceController targetAudienceController;
//    @Autowired
//    private KeywordController keywordController;
//
//    String dateString1 = "10/03/2022";
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//    public Topic_Config() throws ParseException {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(TopicRepository repository) {
//        TargetAudience t1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience t2 = targetAudienceController.getTargetAudience(2L);
//        TargetAudience t3 = targetAudienceController.getTargetAudience(3L);
//        Keyword k1 = keywordController.getKeyword(1L);
//        Keyword k2 = keywordController.getKeyword(2L);
//        Keyword k3 = keywordController.getKeyword(3L);
//        Keyword k4 = keywordController.getKeyword(4L);
//        Keyword k5 = keywordController.getKeyword(5L);
//
//
//        return args -> {
//            Topic topic1 = new Topic(
//
//                    1L,"Topic1", 20L, 10L, null, 2L, List.of(k1), null, List.of(t1), true, false, "Description1", format.parse(dateString1)
//            );
//            Topic topic2 = new Topic(
//                    2L,"Topic2", 20L, 11L, null, 1L, List.of(k1, k2), null, List.of(t1, t2), true, false, "Description2", format.parse(dateString1)
//            );
//            Topic topic3 = new Topic(
//                    3L,"Topic3", 20L, 12L, null, 2L, List.of(k1, k3, k4), null, List.of(t1, t2, t3), true, false, "Description3", format.parse(dateString1)
//            );
//            Topic topic4 = new Topic(
//                    4L,"Topic4", 21L, 13L, null, 1L, List.of(k1, k2, k3, k4, k5), null, List.of(t1, t3), true, false, "Description4TestTestTestTestTestTestTestTestTestTestTestTest", format.parse(dateString1)
//            );
//            Topic topic5 = new Topic(
//                    5L,"Topic5TestTestTestTestTestTestTestTestTestTestTestv", 21L, 14L, null, 1L, null, null, List.of(t2), true, false, "Description5TestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTestTest", format.parse(dateString1)
//            );
//            repository.saveAll(
//                    List.of(topic1,topic2,topic3, topic4, topic5)
//            );
//        };
//    }
//
//}
