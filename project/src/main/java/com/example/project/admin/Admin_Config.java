//package com.example.project.admin;
//
//import com.example.project.appuser.AppUserRole;
//import com.example.project.targetAudience.TargetAudience;
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
//public class Admin_Config {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public Admin_Config(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean("adminbean")
//    CommandLineRunner commandLineRunner(AdminRepository repository) {
//        return args -> {
//            Admin admin1 = new Admin(
//                        3L, "admin1", passwordEncoder.encode("admin"), "admin1@gmail.com", "+32400000000", ADMIN, "Belgium", "Ghent", "StreetNameAdmin1", 9000, 10, "AdminFirstName", "AdminLastName", null
//            );
//
//            repository.saveAll(
//                    List.of(admin1)
//            );
//        };
//    }
//}