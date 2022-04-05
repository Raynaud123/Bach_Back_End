//package com.example.project.promotor;
//import com.example.project.appuser.AppUserRole;
//import com.example.project.student.Student;
//import com.example.project.targetAudience.TargetAudience;
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
//
//@Configuration
//public class Promotor_Config {
//
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//    public Promotor_Config() throws ParseException {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(PromotorRepository repository) {
//        return args -> {
//            Promotor promotor1 = new Promotor(
//                    "userName1", "password", "prom1@email.com", null, MASTER, false, true, "Belgium", "Gent", "street2", 9000, 1, "Prom2", "otor2", true, null, null, null);
//            Promotor promotor2 = new Promotor(
//                    "userProm2", "Prompassword21", "prom2@email.com", null, MASTER, false, true, "Belgium", "Gent", "street2", 9000, 1, "Prom2", "otor2", true, null, null, null
//            );
//            repository.saveAll(
//                    List.of(promotor1, promotor2)
//            );
//        };
//    }
//}
