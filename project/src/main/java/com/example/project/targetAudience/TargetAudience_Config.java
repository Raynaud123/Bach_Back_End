//package com.example.project.targetAudience;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Configuration
//public class TargetAudience_Config {
//
//    public TargetAudience_Config() throws ParseException {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(TargetAudienceRepository repository) {
//        return args -> {
//            Campus c1 = new Campus("Technologiecampus", "België", 9000, "Gent", "straat",1);
//            Campus c2 = new Campus("Campus Diepenbeek", "België", 9000, "Gent", "straat2",1);
//            Campus c3 = new Campus("Campus Lauven", "België", 9000, "Leuven", "straat",1);
//            Course co1 = new Course("Electronica-ict");
//            Course co2 = new Course("Electromechanica");
//            Course co3 = new Course("Chemie");
//            Course co4 = new Course("Bouwkunde");
//            List<Campus> listcampus = new ArrayList<>();
//            listcampus.add(c1);
//            listcampus.add(c2);
//            listcampus.add(c3);
//            List<Course> listcourse = new ArrayList<>();
//            listcourse.add(co1);
//            listcourse.add(co2);
//            listcourse.add(co3);
//            listcourse.add(co4);
//            TargetAudience ta1 = new TargetAudience(
//                    1L, listcampus,listcourse,false
//            );
//            repository.saveAll(
//                    List.of(ta1)
//            );
//        };
//    }
//}
