//package com.example.project.promotor;
//import com.example.project.appuser.AppUserRole;
//import com.example.project.student.Student;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceRepository;
//import com.example.project.topic.Topic;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.MASTER;
//import static com.example.project.appuser.AppUserRole.PROMOTOR;
//
//@Configuration
//public class Promotor_Config {
//
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//    public Promotor_Config() throws ParseException {
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(PromotorRepository repository, TargetAudienceRepository targetAudienceRepository) {
//        return args -> {
//            Promotor promotor1 = new Promotor(1L, "promotor", "1234", "promotor@gmail.com", "000000", PROMOTOR, false, false, "Belgie", "Gent", "Rembertstraat", 8820, 99, "prom", "otor", false, List.of(targetAudienceRepository.getById(52L)));
//            repository.saveAll(
//                    List.of(promotor1)
//            );
//        };
//    }
//}
