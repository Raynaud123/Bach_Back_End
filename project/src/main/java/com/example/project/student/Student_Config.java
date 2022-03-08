//package com.example.project.student;
//
//import com.example.project.appuser.AppUserRole;
//import com.example.project.person.Person;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.topic.Topic;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.ADMIN;
//import static com.example.project.appuser.AppUserRole.USER;
//
//@Configuration
//public class Student_Config {
//
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//    public Student_Config() throws ParseException {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//            Student student1 = new Student(
//                        "RaynaudCornille", "passwordRC", "raynaud@gmail.com", 0000000000, USER, false, false, "Belgium", "Gent", "streetName1", 9000, 1, "Raynaud", "Cornille", true, null,null,null,null,null
//            );
//            Student student2 = new Student(
//                    "MariekeBeke", "passwordMB", "marieke@gmail.com", 0000000000, USER, false, false, "Belgium", "Gent", "streetName2", 9000, 1, "Marieke", "Beke", true, null,null,null,null,null
//            );
//            Student student3 = new Student(
//                    "MartheSpriet", "passwordMS", "marthe@gmail.com", 0000000000, USER, false, false, "Belgium", "Gent", "streetName3", 9000, 1, "Marthe", "Spriet", true, null,null,null,null,null
//            );
//            Student student4 = new Student(
//                    "DemoUser", "passwordDemo", "demo@gmail.com", 0000000000, USER, false, false, "Belgium", "Gent", "streetNameDemo", 9000, 1, "Demo", "User", true, null,null,null,null,null
//            );
//            repository.saveAll(
//                    List.of(student1,student2,student3,student4)
//            );
//        };
//    }
//}