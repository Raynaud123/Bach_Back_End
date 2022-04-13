package com.example.project.targetAudience;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TargetAudience_Config {

    public TargetAudience_Config() {
    }

    @Bean("targetaudiencebean")
    CommandLineRunner commandLineRunner(TargetAudienceRepository repository, CampusRepository campusRepository, CourseRepository courseRepository) {
        return args -> {
            Campus c1 = new Campus("Technologiecampus", "Belgie", 9000, "Gent", "Gebroeders de Smetstraat",1);
            Campus c2 = new Campus("Campus Sint-Lucas", "Belgie", 9000, "Gent", "Hoogstraat",51);
            Campus c3 = new Campus("Campus Diepenbeek", "Belgie", 3590, "Diepenbeek", "Agoralaan",1);
            Campus c4 = new Campus("Campus Leuven", "Belgie", 3000, "Leuven", "Oude markt",13);
            Campus c5 = new Campus("Campus Groep T", "Belgie", 3000, "Leuven", "Andreas Vesaliusstraat",13);
            Campus c6 = new Campus("Campus Arenberg III", "Belgie", 3001, "Leuven", "Celestijnenlaan",200);
            Campus c7 = new Campus("Campus Brussel", "Belgie", 1000, "Brussel", "Warmoesberg",26);
            Campus c8 = new Campus("Campus Sint-Lucas Brussel", "Belgie", 1030, "Schaarbeek", "Paleizenstraat",65);
            Campus c9 = new Campus("Campus Kulak Kortrijk", "Belgie", 8500, "Kortrijk", "Etienne Sabbelaan",53);
            Campus c10 = new Campus("Campus De Nayer", "Belgie", 2860, "Sint-Katelijne-Waver", "Jan Pieter de Nayerlaan",5);
            Campus c11 = new Campus("Campus Brugge", "Belgie", 8200, "Brugge", "Spoorwegstraat",12);
            Campus c12 = new Campus("Campus Geel", "Belgie", 2440, "Geel", "Kleinhoefstraat",4);
            Campus c13 = new Campus("Campus Antwerpen - Carolus", "Belgie", 2000, "Antwerpen", "Hendrik Conscienceplein",8);
            Campus c14 = new Campus("Campus Aalst", "Belgie", 9320, "Aalst", "Kwalestraat",154);

            Course co1 = new Course("Elektronica ICT - Smart application");
            Course co2 = new Course("Elektronica ICT - Embedded systems");
            Course co3 = new Course("Elektronica ICT - Connected systems");
            Course co4 = new Course("Elektromechanica - Elektromechanica");
            Course co5 = new Course("Elektromechanica - Energie");
            Course co6 = new Course("Chemie - Chemie");
            Course co7 = new Course("Chemie - Biochemie");
            Course co8 = new Course("Bouwkunde - Bouwkunde");
            Course co9 = new Course("Bouwkunde - Landmeten");

            campusRepository.saveAll(
                    List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14)
            );
            courseRepository.saveAll(
                    List.of(co1,co2,co3,co4,co5,co6,co7,co8,co9)
            );


            repository.saveAll(
                    List.of(
                            new TargetAudience(1L, c1,co1,false),
                            new TargetAudience(2L, c1,co2,false),
                            new TargetAudience(3L, c1,co3,false),
                            new TargetAudience(4L, c1,co4,false),
                            new TargetAudience(5L, c1,co5,false),
                            new TargetAudience(6L, c1,co6,false),
                            new TargetAudience(7L, c1,co7,false),
                            new TargetAudience(8L, c1,co8,false),
                            new TargetAudience(9L, c1,co9,false),

                            new TargetAudience(10L, c2,co1,false),
                            new TargetAudience(11L, c2,co2,false),
                            new TargetAudience(12L, c2,co3,false),
                            new TargetAudience(13L, c2,co4,false),
                            new TargetAudience(14L, c2,co5,false),
                            new TargetAudience(15L, c2,co6,false),
                            new TargetAudience(16L, c2,co7,false),
                            new TargetAudience(17L, c2,co8,false),
                            new TargetAudience(18L, c2,co9,false),

                            new TargetAudience(19L, c3,co1,false),
                            new TargetAudience(20L, c3,co2,false),
                            new TargetAudience(21L, c3,co3,false),
                            new TargetAudience(22L, c3,co4,false),
                            new TargetAudience(23L, c3,co5,false),
                            new TargetAudience(24L, c3,co6,false),
                            new TargetAudience(25L, c3,co7,false),
                            new TargetAudience(26L, c3,co8,false),
                            new TargetAudience(27L, c3,co9,false),

                            new TargetAudience(28L, c4,co1,false),
                            new TargetAudience(29L, c4,co2,false),
                            new TargetAudience(30L, c4,co3,false),
                            new TargetAudience(31L, c4,co4,false),
                            new TargetAudience(32L, c4,co5,false),
                            new TargetAudience(33L, c4,co6,false),
                            new TargetAudience(34L, c4,co7,false),
                            new TargetAudience(35L, c4,co8,false),
                            new TargetAudience(36L, c4,co9,false),

                            new TargetAudience(37L, c5,co1,false),
                            new TargetAudience(38L, c5,co2,false),
                            new TargetAudience(39L, c5,co3,false),
                            new TargetAudience(40L, c5,co4,false),
                            new TargetAudience(41L, c5,co5,false),
                            new TargetAudience(42L, c5,co6,false),
                            new TargetAudience(43L, c5,co7,false),
                            new TargetAudience(44L, c5,co8,false),
                            new TargetAudience(45L, c5,co9,false),

                            new TargetAudience(46L, c6,co1,false),
                            new TargetAudience(47L, c6,co2,false),
                            new TargetAudience(48L, c6,co3,false),
                            new TargetAudience(49L, c6,co4,false),
                            new TargetAudience(50L, c6,co5,false),
                            new TargetAudience(51L, c6,co6,false),
                            new TargetAudience(52L, c6,co7,false),
                            new TargetAudience(53L, c6,co8,false),
                            new TargetAudience(54L, c6,co9,false),

                            new TargetAudience(55L, c7,co1,false),
                            new TargetAudience(56L, c7,co2,false),
                            new TargetAudience(57L, c7,co3,false),
                            new TargetAudience(58L, c7,co4,false),
                            new TargetAudience(59L, c7,co5,false),
                            new TargetAudience(60L, c7,co6,false),
                            new TargetAudience(61L, c7,co7,false),
                            new TargetAudience(62L, c7,co8,false),
                            new TargetAudience(63L, c7,co9,false),

                            new TargetAudience(64L, c8,co1,false),
                            new TargetAudience(65L, c8,co2,false),
                            new TargetAudience(66L, c8,co3,false),
                            new TargetAudience(67L, c8,co4,false),
                            new TargetAudience(68L, c8,co5,false),
                            new TargetAudience(69L, c8,co6,false),
                            new TargetAudience(70L, c8,co7,false),
                            new TargetAudience(71L, c8,co8,false),
                            new TargetAudience(72L, c8,co9,false),

                            new TargetAudience(73L, c9,co1,false),
                            new TargetAudience(74L, c9,co2,false),
                            new TargetAudience(75L, c9,co3,false),
                            new TargetAudience(76L, c9,co4,false),
                            new TargetAudience(77L, c9,co5,false),
                            new TargetAudience(78L, c9,co6,false),
                            new TargetAudience(79L, c9,co7,false),
                            new TargetAudience(80L, c9,co8,false),
                            new TargetAudience(81L, c9,co9,false),

                            new TargetAudience(82L, c10,co1,false),
                            new TargetAudience(83L, c10,co2,false),
                            new TargetAudience(84L, c10,co3,false),
                            new TargetAudience(85L, c10,co4,false),
                            new TargetAudience(86L, c10,co5,false),
                            new TargetAudience(87L, c10,co6,false),
                            new TargetAudience(88L, c10,co7,false),
                            new TargetAudience(89L, c10,co8,false),
                            new TargetAudience(90L, c10,co9,false),

                            new TargetAudience(91L, c11,co1,false),
                            new TargetAudience(92L, c11,co2,false),
                            new TargetAudience(93L, c11,co3,false),
                            new TargetAudience(94L, c11,co4,false),
                            new TargetAudience(95L, c11,co5,false),
                            new TargetAudience(96L, c11,co6,false),
                            new TargetAudience(97L, c11,co7,false),
                            new TargetAudience(98L, c11,co8,false),
                            new TargetAudience(99L, c11,co9,false),

                            new TargetAudience(100L, c12,co1,false),
                            new TargetAudience(101L, c12,co2,false),
                            new TargetAudience(102L, c12,co3,false),
                            new TargetAudience(103L, c12,co4,false),
                            new TargetAudience(104L, c12,co5,false),
                            new TargetAudience(105L, c12,co6,false),
                            new TargetAudience(106L, c12,co7,false),
                            new TargetAudience(107L, c12,co8,false),
                            new TargetAudience(108L, c12,co9,false),

                            new TargetAudience(109L, c13,co1,false),
                            new TargetAudience(110L, c13,co2,false),
                            new TargetAudience(111L, c13,co3,false),
                            new TargetAudience(112L, c13,co4,false),
                            new TargetAudience(113L, c13,co5,false),
                            new TargetAudience(114L, c13,co6,false),
                            new TargetAudience(115L, c13,co7,false),
                            new TargetAudience(116L, c13,co8,false),
                            new TargetAudience(117L, c13,co9,false),

                            new TargetAudience(118L, c14,co1,false),
                            new TargetAudience(119L, c14,co2,false),
                            new TargetAudience(120L, c14,co3,false),
                            new TargetAudience(121L, c14,co4,false),
                            new TargetAudience(122L, c14,co5,false),
                            new TargetAudience(123L, c14,co6,false),
                            new TargetAudience(124L, c14,co7,false),
                            new TargetAudience(125L, c14,co8,false),
                            new TargetAudience(126L, c14,co9,false)
                    )
            );
        };
    }
}
