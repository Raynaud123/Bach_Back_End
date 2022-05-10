//package com.example.project.targetAudience;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class TargetAudience_Config {
//
//    public TargetAudience_Config() {
//    }
//
//    @Bean("targetaudiencebean")
//    CommandLineRunner commandLineRunner(TargetAudienceRepository repository, CampusRepository campusRepository, CourseRepository courseRepository) {
//        return args -> {
//            Campus c1 = new Campus("Technologiecampus", "Belgie", 9000, "Gent", "Gebroeders de Smetstraat",1);
//            Campus c2 = new Campus("Campus Sint-Lucas", "Belgie", 9000, "Gent", "Hoogstraat",51);
//            Campus c3 = new Campus("Campus Diepenbeek", "Belgie", 3590, "Diepenbeek", "Agoralaan",1);
//            Campus c4 = new Campus("Campus Leuven", "Belgie", 3000, "Leuven", "Oude markt",13);
//            Campus c5 = new Campus("Campus Groep T", "Belgie", 3000, "Leuven", "Andreas Vesaliusstraat",13);
//            Campus c6 = new Campus("Campus Arenberg III", "Belgie", 3001, "Leuven", "Celestijnenlaan",200);
//            Campus c7 = new Campus("Campus Brussel", "Belgie", 1000, "Brussel", "Warmoesberg",26);
//            Campus c8 = new Campus("Campus Sint-Lucas Brussel", "Belgie", 1030, "Schaarbeek", "Paleizenstraat",65);
//            Campus c9 = new Campus("Campus Kulak Kortrijk", "Belgie", 8500, "Kortrijk", "Etienne Sabbelaan",53);
//            Campus c10 = new Campus("Campus De Nayer", "Belgie", 2860, "Sint-Katelijne-Waver", "Jan Pieter de Nayerlaan",5);
//            Campus c11 = new Campus("Campus Brugge", "Belgie", 8200, "Brugge", "Spoorwegstraat",12);
//            Campus c12 = new Campus("Campus Geel", "Belgie", 2440, "Geel", "Kleinhoefstraat",4);
//            Campus c13 = new Campus("Campus Antwerpen - Carolus", "Belgie", 2000, "Antwerpen", "Hendrik Conscienceplein",8);
//            Campus c14 = new Campus("Campus Aalst", "Belgie", 9320, "Aalst", "Kwalestraat",154);
//
//            Course co1 = new Course("Elektronica ICT - Smart application", "ELICTsa");
//            Course co2 = new Course("Elektronica ICT - Embedded systems", "ELICTes");
//            Course co3 = new Course("Elektronica ICT - Connected systems", "ELICTcs");
//            Course co4 = new Course("Elektromechanica", "EM");
//            Course co5 = new Course("Chemie", "CH");
//            Course co6 = new Course("Bouwkunde", "BW");
//
//            campusRepository.saveAll(
//                    List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14)
//            );
//            courseRepository.saveAll(
//                    List.of(co1,co2,co3,co4,co5,co6)
//            );
//
//
//            repository.saveAll(
//                    List.of(
//                            new TargetAudience(1L, c1,co1,false),
//                            new TargetAudience(2L, c1,co2,false),
//                            new TargetAudience(3L, c1,co3,false),
//                            new TargetAudience(4L, c1,co4,false),
//                            new TargetAudience(5L, c1,co5,false),
//                            new TargetAudience(6L, c1,co6,false),
//
//                            new TargetAudience(7L, c2,co1,false),
//                            new TargetAudience(8L, c2,co2,false),
//                            new TargetAudience(9L, c2,co3,false),
//                            new TargetAudience(10L, c2,co4,false),
//                            new TargetAudience(11L, c2,co5,false),
//                            new TargetAudience(12L, c2,co6,false),
//
//                            new TargetAudience(13L, c3,co1,false),
//                            new TargetAudience(14L, c3,co2,false),
//                            new TargetAudience(15L, c3,co3,false),
//                            new TargetAudience(16L, c3,co4,false),
//                            new TargetAudience(17L, c3,co5,false),
//                            new TargetAudience(18L, c3,co6,false),
//
//                            new TargetAudience(19L, c4,co1,false),
//                            new TargetAudience(20L, c4,co2,false),
//                            new TargetAudience(21L, c4,co3,false),
//                            new TargetAudience(22L, c4,co4,false),
//                            new TargetAudience(23L, c4,co5,false),
//                            new TargetAudience(24L, c4,co6,false),
//
//                            new TargetAudience(25L, c5,co1,false),
//                            new TargetAudience(26L, c5,co2,false),
//                            new TargetAudience(27L, c5,co3,false),
//                            new TargetAudience(28L, c5,co4,false),
//                            new TargetAudience(29L, c5,co5,false),
//                            new TargetAudience(30L, c5,co6,false),
//
//                            new TargetAudience(31L, c6,co1,false),
//                            new TargetAudience(32L, c6,co2,false),
//                            new TargetAudience(33L, c6,co3,false),
//                            new TargetAudience(34L, c6,co4,false),
//                            new TargetAudience(35L, c6,co5,false),
//                            new TargetAudience(36L, c6,co6,false),
//
//                            new TargetAudience(37L, c7,co1,false),
//                            new TargetAudience(38L, c7,co2,false),
//                            new TargetAudience(39L, c7,co3,false),
//                            new TargetAudience(40L, c7,co4,false),
//                            new TargetAudience(41L, c7,co5,false),
//                            new TargetAudience(42L, c7,co6,false),
//
//                            new TargetAudience(43L, c8,co1,false),
//                            new TargetAudience(44L, c8,co2,false),
//                            new TargetAudience(45L, c8,co3,false),
//                            new TargetAudience(46L, c8,co4,false),
//                            new TargetAudience(47L, c8,co5,false),
//                            new TargetAudience(48L, c8,co6,false),
//
//                            new TargetAudience(49L, c9,co1,false),
//                            new TargetAudience(50L, c9,co2,false),
//                            new TargetAudience(51L, c9,co3,false),
//                            new TargetAudience(52L, c9,co4,false),
//                            new TargetAudience(53L, c9,co5,false),
//                            new TargetAudience(54L, c9,co6,false),
//
//                            new TargetAudience(55L, c10,co1,false),
//                            new TargetAudience(56L, c10,co2,false),
//                            new TargetAudience(57L, c10,co3,false),
//                            new TargetAudience(58L, c10,co4,false),
//                            new TargetAudience(59L, c10,co5,false),
//                            new TargetAudience(60L, c10,co6,false),
//
//                            new TargetAudience(61L, c11,co1,false),
//                            new TargetAudience(62L, c11,co2,false),
//                            new TargetAudience(63L, c11,co3,false),
//                            new TargetAudience(64L, c11,co4,false),
//                            new TargetAudience(65L, c11,co5,false),
//                            new TargetAudience(66L, c11,co6,false),
//
//                            new TargetAudience(67L, c12,co1,false),
//                            new TargetAudience(68L, c12,co2,false),
//                            new TargetAudience(69L, c12,co3,false),
//                            new TargetAudience(70L, c12,co4,false),
//                            new TargetAudience(71L, c12,co5,false),
//                            new TargetAudience(72L, c12,co6,false),
//
//                            new TargetAudience(73L, c13,co1,false),
//                            new TargetAudience(74L, c13,co2,false),
//                            new TargetAudience(75L, c13,co3,false),
//                            new TargetAudience(76L, c13,co4,false),
//                            new TargetAudience(77L, c13,co5,false),
//                            new TargetAudience(78L, c13,co6,false),
//
//                            new TargetAudience(79L, c14,co1,false),
//                            new TargetAudience(80L, c14,co2,false),
//                            new TargetAudience(81L, c14,co3,false),
//                            new TargetAudience(82L, c14,co4,false),
//                            new TargetAudience(83L, c14,co5,false),
//                            new TargetAudience(84L, c14,co6,false)
//                    )
//            );
//        };
//    }
//}
