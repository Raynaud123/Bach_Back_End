//package com.example.project.keyword;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.util.List;
//
//@Configuration
//public class Keyword_Config {
//
//
//    public Keyword_Config() {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(KeywordRepository repository) {
//        return args -> {
//            Keyword k1 = new Keyword( 1L, "Keyword1"
//            );
//            Keyword k2 = new Keyword( 2L, "Keyword2"
//            );
//            Keyword k3 = new Keyword( 3L, "Keyword3"
//            );
//            Keyword k4 = new Keyword( 4L, "Keyword4"
//            );
//            Keyword k5 = new Keyword( 5L, "Keyword5"
//            );
//            repository.saveAll(
//                    List.of(k1,k2,k3,k4,k5)
//            );
//        };
//    }
//}
