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
//    @Bean("keywordbean")
//    CommandLineRunner commandLineRunner(KeywordRepository repository) {
//        return args -> {
//            Keyword k1 = new Keyword( 1L, "Security",false
//            );
//            Keyword k2 = new Keyword( 2L, "Economy",false
//            );
//            Keyword k3 = new Keyword( 3L, "Law",false
//            );
//            Keyword k4 = new Keyword( 4L, "Architecture",false
//            );
//            Keyword k5 = new Keyword( 5L, "IT",false
//            );
//            repository.saveAll(
//                    List.of(k1,k2,k3,k4,k5)
//            );
//        };
//    }
//}
