//package com.example.project.topic;
//
//import com.example.project.keyword.Keyword;
//import com.example.project.keyword.KeywordController;
//import com.example.project.master.MasterController;
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
//    @Autowired
//    private MasterController masterController;
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
//        Promotor p1 = promotorController.getPromotorById(4L);
//        Promotor p2 = promotorController.getPromotorById(5L);
//        Promotor p3 = promotorController.getPromotorById(6L);
//        Promotor p4 = promotorController.getPromotorById(7L);
//
//        Keyword k1 = keywordController.getKeyword(1L);
//        Keyword k2 = keywordController.getKeyword(2L);
//        Keyword k3 = keywordController.getKeyword(3L);
//        Keyword k4 = keywordController.getKeyword(4L);
//        Keyword k5 = keywordController.getKeyword(5L);
//
//
//        Long ai = 11L;
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
//                    "Description1",format.parse(dateString1)
//            );
//
//
//            Topic topic2 = new Topic(
//                    2L,"ONTWIKKELING VAN DE AANSTURING VAN EEN MAGNETISCH LAGER IN EEN SMALLSAT REACTIEWIEL/DEVELOPMENT OF A CONTROL SYSTEM FOR MAGNETIC REACTION WHEEL BEARINGS",
//                    ai, p2,
//                    1L, lijstK2, null, lijstTA2, true, false,
//        "Description2",format.parse(dateString1)
//            );
//
//
//            Topic topic3 = new Topic(
//                    3L,"Development of an Efficient Wirelessly Rechargeable Utility Robot",
//                    ai, p3,
//                    2L, lijstK3, null, lijstTA3, true, false,
//                    "Description3",format.parse(dateString1)
//            );
//
//
//            Topic topic4 = new Topic(
//                    4L,"Security analysis of a digital exam SAAS-platform",
//                    ai, p4,
//                    1L, lijstK4, null, lijstTA4, true, false,
//
//                    "Description4",format.parse(dateString1)
//            );
//
//
//            Topic topic5 = new Topic(
//                    5L,"POWER SAVINGS VIA SMART POWER SETTINGS BASED ON THE ANALYSIS OF NETWORK USAGE",
//                    ai, p1,
//                    1L, lijstK5, null, lijstTA5, true, false,
//                    "Description5",format.parse(dateString1)
//            );
//            Topic t6 = new Topic(
//                    6L, "TopicName6",
//                    ai, p1,
//                    2L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t7 = new Topic(
//                    7L, "TopicName7",
//                    ai, p2,
//                    1L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t8 = new Topic(
//                    8L, "TopicName8",
//                    ai, p3,
//                    1L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t9 = new Topic(
//                    9L, "TopicName9",
//                    ai, p4,
//                    1L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t10 = new Topic(
//                    10L, "TopicName10",
//                    ai, p1,
//                    2L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t11 = new Topic(
//                    11L, "TopicName11",
//                    ai, p2,
//                    2L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t12 = new Topic(
//                    12L, "TopicName12",
//                    ai, p3,
//                    1L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t13 = new Topic(
//                    13L, "TopicName13",
//                    ai, p4,
//                    1L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t14 = new Topic(
//                    14L, "TopicName14",
//                    ai, p1,
//                    2L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
//            Topic t15 = new Topic(
//                    15L, "TopicName15",
//                    ai, p2,
//                    1L, lijstK1, null, lijstTA1, false, false,
//                    "Description",format.parse(dateString1)
//            );
////            Topic topic1 = new Topic(
////                    1L, "Device Security Management",
////                    ai, null,
////                    2L, lijstK1, null, lijstTA1, true, false,
////                    "Description1",format.parse(dateString1)
////            );
////
////
////            Topic topic2 = new Topic(
////                    2L,"ONTWIKKELING VAN DE AANSTURING VAN EEN MAGNETISCH LAGER IN EEN SMALLSAT REACTIEWIEL/DEVELOPMENT OF A CONTROL SYSTEM FOR MAGNETIC REACTION WHEEL BEARINGS",
////                    ai, null,
////                    1L, lijstK2, null, lijstTA2, true, false,
////                    "Description2",format.parse(dateString1)
////            );
////
////
////            Topic topic3 = new Topic(
////                    3L,"Development of an Efficient Wirelessly Rechargeable Utility Robot",
////                    ai, null,
////                    2L, lijstK3, null, lijstTA3, true, false,
////                    "Description3",format.parse(dateString1)
////            );
////
////
////            Topic topic4 = new Topic(
////                    4L,"Security analysis of a digital exam SAAS-platform",
////                    ai, null,
////                    1L, lijstK4, null, lijstTA4, true, false,
////
////                    "Description4",format.parse(dateString1)
////            );
////
////
////            Topic topic5 = new Topic(
////                    5L,"POWER SAVINGS VIA SMART POWER SETTINGS BASED ON THE ANALYSIS OF NETWORK USAGE",
////                    ai, null,
////                    1L, lijstK5, null, lijstTA5, true, false,
////                    "Description5",format.parse(dateString1)
////            );
////            Topic t6 = new Topic(
////                    6L, "TopicName6",
////                    ai, null,
////                    2L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t7 = new Topic(
////                    7L, "TopicName7",
////                    ai, null,
////                    1L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t8 = new Topic(
////                    8L, "TopicName8",
////                    ai, null,
////                    1L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t9 = new Topic(
////                    9L, "TopicName9",
////                    ai, null,
////                    1L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t10 = new Topic(
////                    10L, "TopicName10",
////                    ai, null,
////                    2L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t11 = new Topic(
////                    11L, "TopicName11",
////                    ai, null,
////                    2L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t12 = new Topic(
////                    12L, "TopicName12",
////                    ai, null,
////                    1L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t13 = new Topic(
////                    13L, "TopicName13",
////                    ai, null,
////                    1L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t14 = new Topic(
////                    14L, "TopicName14",
////                    ai, null,
////                    2L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
////            Topic t15 = new Topic(
////                    15L, "TopicName15",
////                    ai, null,
////                    1L, lijstK1, null, lijstTA1, false, false,
////                    "Description",format.parse(dateString1)
////            );
//            repository.saveAll(
//                    List.of(topic1,topic2,topic3,topic4,topic5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15)
//            );
//        };
//    }
//
//}
