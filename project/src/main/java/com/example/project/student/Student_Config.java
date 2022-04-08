//package com.example.project.student;
//
//import com.example.project.appuser.AppUserRole;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.topic.Topic;
//import com.example.project.topic.TopicController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.STUDENT;
//
//@Configuration
//public class Student_Config {
//
//    @Autowired
//    private TopicController topicController;
//    @Autowired
//    private TargetAudienceController targetAudienceController;
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        Topic t1 = topicController.getTopic(1L);
//        Topic t2 = topicController.getTopic(2L);
//        Topic t3 = topicController.getTopic(3L);
//        TargetAudience ta1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience ta2 = targetAudienceController.getTargetAudience(2L);
//        TargetAudience ta3 = targetAudienceController.getTargetAudience(3L);
//
//        return args -> {
//            Student student1 = new Student(
//                        1L, "RaynaudCornille", "passwordRC", "raynaud@gmail.com", "0000000000", STUDENT, false, false, "Belgium", "Gent", "streetName1", 9000, 1, "Raynaud", "Cornille", true, List.of(ta1, ta3),null,null, List.of(t1, t2),null
//            );
//            Student student2 = new Student(
//                    2L, "MariekeBeke", "passwordMB", "marieke@gmail.com", "0000000000", STUDENT, false, false, "Belgium", "Gent", "streetName2", 9000, 1, "Marieke", "Beke", true, List.of(ta1, ta2),null,null,List.of(t1),null
//            );
//            Student student3 = new Student(
//                    3L, "MartheSpriet", "passwordMS", "marthe@gmail.com", "0000000000", STUDENT, false, false, "Belgium", "Gent", "streetName3", 9000, 1, "Marthe", "Spriet", true, List.of(ta3),null,null, List.of(t3),null
//            );
//            repository.saveAll(
//                    List.of(student1,student2,student3)
//            );
//        };
//    }
//}
