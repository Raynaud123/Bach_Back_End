//package com.example.project.targetAudience;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class TargetAudience_Config {
//
//    public TargetAudience_Config() {
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(TargetAudienceRepository repository, CampusRepository campusRepository, CourseRepository courseRepository) {
//        return args -> {
//            Campus c1 = new Campus("Technologiecampus", "Belgie", 9000, "Gent", "straat",1);
//            Campus c2 = new Campus("Campus Diepenbeek", "Belgie", 9000, "Gent", "straat2",1);
//            Campus c3 = new Campus("Campus Lauven", "Belgie", 9000, "Leuven", "straat",1);
//            Course co1 = new Course("Electronica-ict");
//            Course co2 = new Course("Electromechanica");
//            Course co3 = new Course("Chemie");
//            Course co4 = new Course("Bouwkunde");
//            campusRepository.saveAll(
//                    List.of(c1,c2,c3)
//            );
//            courseRepository.saveAll(
//                    List.of(co1,co2,co3,co4)
//            );
////            List<Campus> listcampus = new ArrayList<>();
////            listcampus.add(c1);
////            listcampus.add(c2);
////            listcampus.add(c3);
////            List<Course> listcourse = new ArrayList<>();
////            listcourse.add(co1);
////            listcourse.add(co2);
////            listcourse.add(co3);
////            listcourse.add(co4);
//            TargetAudience ta1 = new TargetAudience(
//                    1L, c1,co1,false
//            );
//            TargetAudience ta2 = new TargetAudience(
//                    1L, c1,co2,false
//            );
//            TargetAudience ta3 = new TargetAudience(
//                    1L, c1,co3,false
//            );
//            TargetAudience ta4 = new TargetAudience(
//                    1L, c1,co4,false
//            );
//            TargetAudience ta5 = new TargetAudience(
//                    1L, c2,co1,false
//            );
//            TargetAudience ta6 = new TargetAudience(
//                    1L, c2,co2,false
//            );
//            TargetAudience ta7 = new TargetAudience(
//                    1L, c2,co3,false
//            );
//            TargetAudience ta8 = new TargetAudience(
//                    1L, c2,co4,false
//            );
//            TargetAudience ta9 = new TargetAudience(
//                    1L, c3,co1,false
//            );
//            TargetAudience ta10 = new TargetAudience(
//                    1L, c3,co2,false
//            );
//            TargetAudience ta11 = new TargetAudience(
//                    1L, c3,co3,false
//            );
//            TargetAudience ta12 = new TargetAudience(
//                    1L, c3,co4,false
//            );
//            repository.saveAll(
//                    List.of(ta1,ta2,ta3,ta4,ta5,ta6,ta7,ta8,ta9,ta10,ta11,ta12)
//            );
//        };
//    }
//}
