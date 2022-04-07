//package com.example.project.phase;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//public class Phase_Config {
//
//    String dateString1 = "08/02/2022";
//    String dateString2 = "30/03/2022";
//    String dateString3 = "31/03/2022";
//    String dateString4 = "01/04/2022";
//    String dateString5 = "30/04/2022";
//    String dateString6 = "01/05/2022";
//    String dateString7 = "15/05/2022";
//    String dateString8 = "16/05/2022";
//    String dateString9 = "20/05/2022";
//
//
//    String dateString10 = "15/08/2022";
//    String dateString11 = "10/09/2022";
//    String dateString12 = "12/09/2022";
//    String dateString13 = "18/09/2022";
//    String dateString14 = "19/09/2022";
//    String dateString15 = "28/09/2022";
//
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//    //Date date = format.parse(dateString);
//
//    public Phase_Config() throws ParseException {
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(PhaseRepository repository) {
//        return args -> {
//            Phase fase1 = new Phase(
//                    "Submit topics", format.parse(dateString1), format.parse(dateString2),true
//            );
//            Phase fase2 = new Phase(
//                    "Accepting topics", format.parse(dateString1), format.parse(dateString3),true
//            );
//            Phase fase3 = new Phase(
//                    "Preferences Students", format.parse(dateString4), format.parse(dateString5),true
//            );
//            Phase fase4 = new Phase(
//                    "Preferences Promotors", format.parse(dateString6), format.parse(dateString7),true
//            );
//            Phase fase5 = new Phase(
//                    "Assignment Topic to Students", format.parse(dateString8), format.parse(dateString9),true
//            );
//            Phase fase6 = new Phase(
//                    "Preferences Students", format.parse(dateString10), format.parse(dateString11),false
//            );
//            Phase fase7 = new Phase(
//                    "Preferences Promotors", format.parse(dateString12), format.parse(dateString13),false
//            );
//            Phase fase8 = new Phase(
//                    "Assignment Topic to Students", format.parse(dateString14), format.parse(dateString15),false
//            );
//            repository.saveAll(
//                    List.of(fase1,fase2,fase3,fase4,fase5,fase6,fase7,fase8)
//            );
//        };
//    }
//}