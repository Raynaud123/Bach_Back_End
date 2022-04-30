//package com.example.project.student;
//
//import com.example.project.Master.MasterRepository;
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
//import java.util.ArrayList;
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
//    @Autowired
//    private MasterRepository masterRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public Student_Config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean("studentbean")
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        TargetAudience ta1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience ta2 = targetAudienceController.getTargetAudience(10L);
//        TargetAudience ta3 = targetAudienceController.getTargetAudience(19L);
//        List<TargetAudience> lijstTA1 = new ArrayList<>();    lijstTA1.add(ta1);       lijstTA1.add(ta2);
//        List<TargetAudience> lijstTA2 = new ArrayList<>();    lijstTA2.add(ta1);       lijstTA2.add(ta3);
//        List<TargetAudience> lijstTA3 = new ArrayList<>();    lijstTA3.add(ta3);
//
////        Topic t1 = topicController.getTopic(1L);
////        Topic t2 = topicController.getTopic(2L);
////        Topic t3 = topicController.getTopic(3L);
////        List<Topic> lijstPT1 = new ArrayList<>();       lijstPT1.add(t1);        lijstPT1.add(t3);
////        List<Topic> lijstPT2 = new ArrayList<>();       lijstPT2.add(t2);
////        List<Topic> lijstPT3 = new ArrayList<>();       lijstPT3.add(t3);
////        List<Topic> lijst1Top3 = new ArrayList<>();     lijst1Top3.add(t1);
//
//
//
//        return args -> {
//            Student student1 = new Student(
//                    8L,"RaynaudCornille", passwordEncoder.encode("pwdRC"), "raynaud@gmail.com", "+32400000000", STUDENT, false, false, "Belgium", "Gent", "streetNameRC", 9000, 1, "Raynaud", "Cornille", true, lijstTA1,
//                    masterRepository.getById(1L), null, null, null
//            );
//            Student student2 = new Student(
//                    9L,"MariekeBeke", passwordEncoder.encode("pwdMB"), "marieke@gmail.com", "+32400000000", STUDENT, false, false, "Belgium", "Gent", "streetNameMB", 9000, 2, "Marieke", "Beke", true, lijstTA2,
//                    masterRepository.getById(2L),null, null,null
//            );
//            Student student3 = new Student(
//                    10L,"MartheSpriet", passwordEncoder.encode("pwdMS"), "marthe@gmail.com", "+32400000000", STUDENT, false, false, "Belgium", "Gent", "streetNameMS", 9000, 3, "Marthe", "Spriet", true, lijstTA3,
//                    masterRepository.getById(1L),null, null,null
//            );
//            repository.saveAll(
//                    List.of(student1,student2,student3)
//            );
//        };
//    }
//}
