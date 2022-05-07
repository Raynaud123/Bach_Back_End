//package com.example.project.topic;
//
//import com.example.project.Master.MasterRepository;
//import com.example.project.keyword.Keyword;
//import com.example.project.keyword.KeywordController;
//import com.example.project.promotor.Promotor;
//import com.example.project.promotor.PromotorController;
//import com.example.project.targetAudience.TargetAudience;
//import com.example.project.targetAudience.TargetAudienceController;
//import com.example.project.topicprovider.TopicProvider;
//import com.example.project.topicprovider.TopicProviderController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class Topic_Config {
//
//    @Autowired
//    private PromotorController promotorController;
//    @Autowired
//    private TargetAudienceController targetAudienceController;
//    @Autowired
//    private KeywordController keywordController;
//    @Autowired
//    private TopicProviderController topicProviderController;
//
//    String dateString1 = "10/03/2022";
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//
//    public Topic_Config() {
//    }
//    @Bean("topicbean")
//    CommandLineRunner commandLineRunner(TopicRepository repository) {
//        TargetAudience t1 = targetAudienceController.getTargetAudience(1L);
//        TargetAudience t2 = targetAudienceController.getTargetAudience(10L);
//        TargetAudience t3 = targetAudienceController.getTargetAudience(19L);
//        List<TargetAudience> lijstTA1 = new ArrayList<>();    lijstTA1.add(t1);
//        List<TargetAudience> lijstTA2 = new ArrayList<>();    lijstTA2.add(t1);       lijstTA2.add(t2);
//        List<TargetAudience> lijstTA3 = new ArrayList<>();    lijstTA3.add(t1);       lijstTA3.add(t2);       lijstTA3.add(t3);
//        List<TargetAudience> lijstTA4 = new ArrayList<>();    lijstTA4.add(t1);       lijstTA4.add(t3);
//        List<TargetAudience> lijstTA5 = new ArrayList<>();    lijstTA5.add(t2);
//
//        Promotor p1 = promotorController.getPromotorById(12);
//        Promotor p2 = promotorController.getPromotorById(13);
//        Promotor p3 = promotorController.getPromotorById(14);
//        Promotor p4 = promotorController.getPromotorById(15);
//
//        Keyword k1 = keywordController.getKeyword(1L);
//        Keyword k2 = keywordController.getKeyword(2L);
//        Keyword k3 = keywordController.getKeyword(3L);
//        Keyword k4 = keywordController.getKeyword(4L);
//        Keyword k5 = keywordController.getKeyword(5L);
//
//
//        TopicProvider ai = topicProviderController.getById(9);
//
//        List<Keyword> lijstK1 = new ArrayList<>();    lijstK1.add(k1);
//        List<Keyword> lijstK2 = new ArrayList<>();    lijstK2.add(k1);    lijstK2.add(k2);
//        List<Keyword> lijstK3 = new ArrayList<>();    lijstK3.add(k1);    lijstK3.add(k2);    lijstK3.add(k3);
//        List<Keyword> lijstK4 = new ArrayList<>();    lijstK4.add(k1);    lijstK4.add(k2);    lijstK4.add(k3);    lijstK4.add(k4);    lijstK4.add(k5);
//        List<Keyword> lijstK5 = new ArrayList<>();
//
//
//        return args -> {
//            Topic topic1 = new Topic(
//                    1L, "Device Security Management",
//                    ai, p1,
//                    2L, lijstK1, null, lijstTA1, true, false,
//
////                    "Steeds meer systemen zijn verbonden met het internet, gaande van een slimme weegschaal of vaatwasmachine tot slimme auto’s.\n" +
////                            "De veiligheid van deze IoT devices is echter vaak onvoldoende gebleken. Een casino werd aangevallen via een slimme thermometer, slim speelgoed misbruikt om de nachtrust van ouders en kinderen te verstoren, gehackte routers en slimme camera’s worden gebruikt om massieve aanvallen (DDoS) op sites uit te voeren en ze plat te leggen.\n" +
////                            "\n" + "Het is dan ook belangrijk om de veiligheid van deze apparaten sterk te verbeteren, zowel tijdens de ontwikkeling, maar ook nadien.\n" + "In deze thesis bestuderen we manieren om de veiligheid van IoT devices te beheren nadat ze in gebruik zijn genomen.\n" +
////                            "Er wordt bestudeerd hoe het veiligheidsniveau van apparaten gedurende de volledige levensloop voldoende hoog kan gehouden worden. Onder andere zullen kritische kwetsbaarheden zo snel mogelijk aangepakt moeten worden. Hierbij moet echter rekening gehouden met de beschikbare resources (bandbreedte, betrouwbaarheid van de communicatie, energieverbruik, …) en het risico die bepaalde kwetsbaarheden met zich meebrengen.\n" +
////                            "Naast het opvolgen van de security status van apparaten en support voor het veilig updaten van apparaten, zoeken we dus naar geavanceerde decision support die rekening kan houden met de toepassing specifieke eigenschappen en resources.",
//                    "Description1",format.parse(dateString1)
//            );
//
//
//            Topic topic2 = new Topic(
//                    2L,"ONTWIKKELING VAN DE AANSTURING VAN EEN MAGNETISCH LAGER IN EEN SMALLSAT REACTIEWIEL/DEVELOPMENT OF A CONTROL SYSTEM FOR MAGNETIC REACTION WHEEL BEARINGS",
//                    ai, p2,
//                    1L, lijstK2, null, lijstTA2, true, false,
//
////                    "Arcsec ontwikkelt standbepaling- en controlesystemen (Attitude Determination and Control System, ADCS) voor satellieten. Het ADCS is het systeem aan boord van de satelliet dat de oriëntatie van de satelliet kan controleren. Hiermee kunnen payloads gericht worden, of kunnen\n" +
////                            "zonnepanelen optimaal in de zon geplaatst worden.\n" + "Een cruciaal onderdeel van een nauwkeurig ADCS zijn de reactiewielen. Dit zijn gemotoriseerde vliegwielen die dankzij het systeem van behoud van impulsmoment de oriëntatie van de satelliet kunnen veranderen. Traditionele reactiewielen hebben conventionele rollagers. Deze hebben\n" +
////                            "echter het grote nadeel dat ze trillingen genereren, die de nauwkeurige controle van de satellietoriëntatie bemoeilijken.\n" +
////                            "Arcsec werkt momenteel – in een project met ESA – aan de ontwikkeling van een actief magnetisch gelagerd reactiewiel. In dit thesisproject zal gewerkt worden aan de aansturing van dit magnetisch lager in het reactiewiel. Hiervoor zal het lagersysteem geanalyseerd worden en zal\n" +
////                            "custom drive elektronica ontwikkeld worden. In het laatste stadium van de thesis wordt het systeem gebouwd en getest.\n" +
////                            "\n" +
////                            "Arcsec develops attitude determination and control systems (ADCS) for satellites. The ADCS is the on-board system that can control the orientation of the satellite. This allows payloads to be directed, or solar panels to be optimally placed in the sun.\n" +
////                            "A crucial part of an accurate ADCS are the reaction wheels. These are motorized flywheels that can change the orientation of the satellite thanks to the system of conservation of angular momentum. Traditional reaction wheels have conventional roller bearings. These have\n" +
////                            "the major disadvantage, however, that they generate vibrations, which make accurate control of satellite orientation difficult.\n" +
////                            "Arcsec is currently working - in a project with ESA - on the development of an active magnetically bearing reaction wheel. In this thesis project we will work on the control of this magnetic bearing in the reaction wheel. The bearing system will be analyzed and custom drive electronics will be developed.",
//                    "Description2",format.parse(dateString1)
//            );
//
//
//            Topic topic3 = new Topic(
//                    3L,"Development of an Efficient Wirelessly Rechargeable Utility Robot",
//                    ai, p3,
//                    2L, lijstK3, null, lijstTA3, true, false,
//
////                    "Ontwikkeling van een draadloos oplaadbare autonome huishoudrobot. Zie bijlage voor meer details.",
//                    "Description3",format.parse(dateString1)
//            );
//
//
//            Topic topic4 = new Topic(
//                    4L,"Security analysis of a digital exam SAAS-platform",
//                    ai, p4,
//                    1L, lijstK4, null, lijstTA4, true, false,
//
////                    "AssessmentQ is a digital exam platform developed and maintained by Televic Education. 250+ customers are using assessmentQ for organizing online and digital (practice) exams.\n" +
////                            "\n" +
////                            "As a company we focus more and more to high stake exams. For those customers the security is becoming increasingly important. So that is way we want to do an security analysis of our applications that are used by the student. And also check our API, Identity server, backoffice,...\n" +
////                            "We want to know what are the security holes in our applications and what can we do to fix them. In a later phase we want to know what we need to comply the ISO/IEC 27001 certificate. How we do the security analyses is still open. But it can be done by security testing, ethical hacking, tooling, …\n" +
////                            "If you are interested in this topic, please also register this on the Televic website at: https://www.televic.com/en/careers/internships-and-students so we can confirm the topic is still available.\n",
//                    "Description4",format.parse(dateString1)
//            );
//
//
//            Topic topic5 = new Topic(
//                    5L,"POWER SAVINGS VIA SMART POWER SETTINGS BASED ON THE ANALYSIS OF NETWORK USAGE",
//                    ai, p1,
//                    1L, lijstK5, null, lijstTA5, true, false,
//
////                    "Networking components, such as modems, routers, access points, are typically permanently active at maximal performance. Energy savings can be achieved by tuning the energy consumption of these devices to the actual needs of the users. Users do not need connectivity 24x7 at every single location in the home. Today's approaches to reduce energy are very coarse grained and include rime-based power reduction options such as disabling a device between midnight and 5AM. Other options require manual interventions such as disabling network components in a study after working hours. The disadvantage of these brute force approaches is that he user QoE can be negatively impacted in case someone wants to use the network outside of the foreseen schedule.\n" +
////                            "\n" +
////                            "\n" +
////                            "We want to design a system that continuously minimizes power consumption and that maximizes user QoE (Quality of Experience). We want to define an approach in which the devices are automatically configured to provide the exact required network performance that people need when they need it and that reduces the power consumption of the device in other cases.\n" +
////                            "\n" +
////                            "\n" +
////                            "So, we need to define an algorithm that identifies when users need which amount of connectivity (e.g., 2.4 and 5Ghz Wifi vs 2.4GHz only), at which location in the home, and when they do no longer need it.\n" +
////                            "\n" +
////                            "\n" +
////                            "We want to base this algorithm on the analysis of actual and historical network traffic in the house. As an example, historical data can reveal when people use their network for video streaming or for less demanding applications. Actual network data can identify which devices are present on the network.",
//                    "Description5",format.parse(dateString1)
//            );
//            repository.saveAll(
//                    List.of(topic1,topic2,topic3,topic4,topic5)
//            );
//        };
//    }
//
//}
