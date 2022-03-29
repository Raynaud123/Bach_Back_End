//package com.example.project.appuser;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.List;
//
//import static com.example.project.appuser.AppUserRole.ADMIN;
//
//@Configuration
//public class AppUser_config {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public AppUser_config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(AppUserRepository repository) {
//        return args -> {
//            AppUser raynaud = new AppUser("raynaud",passwordEncoder.encode("1234"),"raynaud.cornille@gmail.com","585858",ADMIN, false,true,"Belgium","Veldegem","Rembertstraat",8,99
//            );
//            AppUser marieke = new AppUser(
//                    "marieke",passwordEncoder.encode("1234"),"marieke.beke@gmail.com","585858",ADMIN, false,true,"Belgium","Veldegem","Rembertstraat",8,99
//            );
//            AppUser marthe = new AppUser(
//                    "marthe",passwordEncoder.encode("1234"),"marthe.spriet@gmail.com","585858",ADMIN, false,true,"Belgium","Veldegem","Rembertstraat",8,99
//            );
//            repository.saveAll(
//                    List.of(raynaud,marieke,marthe)
//            );
//        };
//    }

//}