package com.example.project.topic;

import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRepository;
import com.example.project.appuser.AppUserRole;
import com.example.project.exceptions.*;
import com.example.project.keyword.Keyword;
import com.example.project.keyword.KeywordRepository;
import com.example.project.notification.Notification;
import com.example.project.notification.NotificationObjectSort;
import com.example.project.notification.NotificationRepository;
import com.example.project.notification.NotificationSort;
import com.example.project.person.PersonRepository;
import com.example.project.promotor.PromotorRepository;
import com.example.project.student.*;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.targetAudience.TargetAudienceRepository;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PromotorRepository promotorRepository;
    @Autowired
    private TopicProviderRepository providerRepository;
    @Autowired
    private KeywordRepository keywordRepository;
    @Autowired
    private TargetAudienceRepository targetAudienceRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private Topic_choiceRepository topic_choiceRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    public void addNewTopic(TopicPostRequest request) {

        List<Keyword> keywords = new ArrayList<>();
        List<TargetAudience> targetAudiences = new ArrayList<>();

        Topic topic;

        for(int i = 0; i < request.keywords.length; i++){
            keywords.add(keywordRepository.getById(request.keywords[i]));
        }

        for(int i = 0; i < request.targetAudience.length; i++){
            targetAudiences.add(targetAudienceRepository.getById(request.targetAudience[i]));
        }
//        Optional<AppUser> tp = appUserRepository.findById(request.provider_id);
        if(keywords.isEmpty() && targetAudiences.isEmpty()){
            topic = new Topic(request.topicName, request.description_topic, request.aantal_studenten,request.provider_id);
        }
        else if(keywords.isEmpty()){
            topic = new Topic(request.topicName, request.description_topic, request.aantal_studenten,null,targetAudiences,request.provider_id);
        }else if(targetAudiences.isEmpty()){
            topic = new Topic(request.topicName, request.description_topic, request.aantal_studenten,keywords,null,request.provider_id);
        }else{
            topic = new Topic(request.topicName,request.description_topic,request.aantal_studenten, keywords, targetAudiences,request.provider_id);
        }
        topicRepository.save(topic);
    }

    public List<Topic> findAllApprovedTopics() {
        List<Topic> all = topicRepository.findAll();
        ArrayList<Topic> app = new ArrayList<>();
        for(Topic top: all){

            AppUser test = appUserRepository.findById(top.getProvider()).get();
            if(test.getAppUserRole() == AppUserRole.PROMOTOR){
                if(Boolean.TRUE.equals(top.getApproved_topic()) && Boolean.TRUE.equals(!top.getHide_topic())){
                    app.add(top);
                }
            }else if(test.getAppUserRole() == AppUserRole.COMPANY){
                TopicProvider topicP = providerRepository.findById(top.getProvider()).get();
                if(topicP.getCompany()){
                    if(Boolean.TRUE.equals(top.getApproved_topic()) && Boolean.TRUE.equals(!top.getHide_topic()) && topicP.isApproved()){
                        app.add(top);
                    }
                }else{
                    if(Boolean.TRUE.equals(top.getApproved_topic()) && Boolean.TRUE.equals(!top.getHide_topic())){
                        app.add(top);
                    }
                }
            }

        }
        return app;
//            if(top.getApproved_topic() != null && top.getApproved_topic()){
//                app.add(top);
//            }
        }


    public String updateApprove(UpdateTopicApproveRequest request) {
        Long id = request.getTopic_id();
        if (topicRepository.findById(id).isPresent()) {
            Topic testObject = topicRepository.getById(id);
            testObject.setApproved_topic(request.getApproved());
            topicRepository.save(testObject);
            return "Topic approved status is updated";
        }
        else return "Topic not found";
    }

    public ResponseEntity<Object> updateTopicAssignment(Long topic_id, UpdateTopicStudentsRequest request) throws NietTop3TopicExceptionRequest, IdNotFoundRequestException, NietApprovedRequestException {
        if (topicRepository.findById(topic_id).isPresent()){
            Topic storedTopic = topicRepository.getById(topic_id);
            if(request.getAantalStudenten() == 1){
                Long storedID = request.getStudent_id()[0];
                if(studentRepository.findById(storedID).isPresent() && storedTopic.getApproved_topic()){
                    Student s = studentRepository.findById(storedID).get();
                    List<Topic_choice> choices = topic_choiceRepository.findAllByStudent(s);
                    int keuze = 0;
                    for (Topic_choice topic_choice : choices){
                        if(topic_choice.getTopic().getTopic_id() == topic_id){
                            keuze = topic_choice.getChoice();
                        }
                    }
                    if(keuze != 0){
                        Student k = studentRepository.getById(storedID);
                        k.setAssignedTopic(true);
                        storedTopic.addStudent(k);
                        Topic updated = topicRepository.save(storedTopic);
                        addNotificationAssignment(k);
                        studentRepository.save(k);
                        KeuzeReturn object = new KeuzeReturn(keuze,updated);
                        return new ResponseEntity(object, HttpStatus.OK);
                    }else if (keuze == 0){
                        throw new NietTop3TopicExceptionRequest("Dit is geen topic uit de top 3 van de student");
                    }
                }else if (!storedTopic.getApproved_topic()){
                    throw new NietApprovedRequestException("Topic is niet approved");
                }
                else{
                    throw new IdNotFoundRequestException(storedID + "is niet present in de database");
                }
            }else if(request.getAantalStudenten()==2){
                Long storedIDéén = request.getStudent_id()[0];
                Long storedIDtwee = request.getStudent_id()[1];
                if(studentRepository.findById(storedIDéén).isPresent() && storedTopic.getApproved_topic() && studentRepository.findById(storedIDtwee).isPresent()){
                    Student één = studentRepository.findById(storedIDéén).get();
                    Student twee= studentRepository.findById(storedIDtwee).get();
                    List<Topic_choice> éénchoices = topic_choiceRepository.findAllByStudent(één);
                    int keuze = 0;
                    for (Topic_choice topic_choice : éénchoices){
                        if(topic_choice.getTopic().getTopic_id() == topic_id){
                            keuze = topic_choice.getChoice();
                        }
                    }
                    List<Topic_choice> choices = topic_choiceRepository.findAllByStudent(twee);
                    int keuzetwee = 0;
                    for (Topic_choice topic_choice : choices){
                        if(topic_choice.getTopic().getTopic_id() == topic_id){
                            keuzetwee = topic_choice.getChoice();
                        }
                    }
                    if(keuze != 0 && keuzetwee != 0){
                        Student k = studentRepository.getById(storedIDéén);
                        k.setAssignedTopic(true);
                        Student l = studentRepository.getById(storedIDtwee);
                        l.setAssignedTopic(true);
                        storedTopic.addStudent(k);
                        storedTopic.addStudent(l);
                        Topic updated = topicRepository.save(storedTopic);
                        addNotificationAssignment(k);
                        addNotificationAssignment(l);
                        studentRepository.save(k);
                        studentRepository.save(l);
                        KeuzeTweeReturn object = new KeuzeTweeReturn(keuze,keuzetwee,updated);
                        return new ResponseEntity(object, HttpStatus.OK);
                    }else if (keuze == 0 || keuzetwee == 0){
                        throw new NietTop3TopicExceptionRequest("Dit is geen topic uit de top 3 van de student");
                    }
                }

            }}
            else {
                throw new IdNotFoundRequestException("Topic is niet aanwezig in db");
            }
            return null;
            }

    private void addNotificationAssignment(Student s) {
        Notification n = new Notification(NotificationSort.ASSIGNED, NotificationObjectSort.STUDENT, s.getId(), new Date());
        notificationRepository.save(n);
        s.getNotification_list().add(n);
    }


    public List<Topic> findById(long id) {
        return topicRepository.findAllById(Collections.singleton(id));
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }


    public Topic getTopic(Long id) throws IdNotFoundRequestException, NietApprovedRequestException {
        if(topicRepository.findById(id).isPresent()){
            //Nog checken als topicprovider is enabled.
            Topic t = topicRepository.findById(id).get();
            if(appUserRepository.findById(t.getProvider()).isPresent()){
                AppUser test = appUserRepository.findById(t.getProvider()).get();
                if(test.getAppUserRole() == AppUserRole.PROMOTOR){
                    if(Boolean.TRUE.equals(t.getApproved_topic()) && Boolean.TRUE.equals(!t.getHide_topic())){
                        return t;
                    }else {
                        throw new NietApprovedRequestException("Je bent niet approved");
                    }
                }else if(test.getAppUserRole() == AppUserRole.COMPANY){
                    TopicProvider topicP = providerRepository.findById(t.getProvider()).get();
                    if(topicP.getCompany()){
                        if(Boolean.TRUE.equals(t.getApproved_topic()) && Boolean.TRUE.equals(!t.getHide_topic()) && topicP.isApproved()){
                            return t;
                        }else {
                            throw new NietApprovedRequestException("Je bent niet approved");
                        }
                    }else{
                        if(Boolean.TRUE.equals(t.getApproved_topic()) && Boolean.TRUE.equals(!t.getHide_topic())){
                            return t;
                        }else {
                            throw new NietApprovedRequestException("Je bent niet approved");
                        }
                    }
                }
            }
        }else {
            throw new IdNotFoundRequestException("Dit id: "+ id +" is niet gevonden");
        }
//        List<Topic> all = topicRepository.findAll();
//        for(Topic top: all){
//            if(Objects.equals(top.getTopic_id(), id)){
//                return top;
//            }
//        }
        return null;
    }

    public Topic getTopicByString(String topicName) {
        List<Topic> all = topicRepository.findAll();
        for(Topic top: all){
            if(Objects.equals(top.getTopicName(), topicName)){
                return top;
            }
        }
        return null;
    }

    public List<Topic> getTopicPromotorId(long promotor_id) {

        List<Topic> allTopics = topicRepository.findByPromotor(promotorRepository.findById(promotor_id));
        List<Topic> returnTopics = new ArrayList<Topic>();

        for (Topic p: allTopics){
            if(p.getApproved_topic() && !p.getHide_topic()){
                returnTopics.add(p);
            }
        }

         return returnTopics;
    }

    public Topic boostStudent(int id, BoostStudentRequest request) throws IdNotFoundRequestException {
        if (topicRepository.findById((long)id).isPresent()) {
            Topic topic = topicRepository.getById((long) id);
            if(request.getStudentId().length == 1){
                if(studentRepository.findById((long)request.getStudentId()[0]).isPresent()){


                    Student k = studentRepository.getById((long) request.getStudentId()[0]);
                    k.setAssignedTopic(true);
                    topic.addStudent(k);
                    Topic updated = topicRepository.save(topic);
                    addNotificationAssignment(k);
                    studentRepository.save(k);
                    return updated;
                }
                else{
                    throw new IdNotFoundRequestException("Student Id klopt niet");
                }
            }
            else if (request.getStudentId().length == 2){
                if(studentRepository.findById((long)request.getStudentId()[0]).isPresent() && studentRepository.findById((long) request.getStudentId()[1]).isPresent()){
                    Student k = studentRepository.getById((long)request.getStudentId()[0]);
                    k.setAssignedTopic(true);
                    Student l = studentRepository.getById((long) request.getStudentId()[1]);
                    l.setAssignedTopic(true);
                    topic.addStudent(k);
                    topic.addStudent(l);
                    Topic updated = topicRepository.save(topic);
                    addNotificationAssignment(k);
                    addNotificationAssignment(l);
                    studentRepository.save(k);
                    studentRepository.save(l);
                }
                else {
                    throw new IdNotFoundRequestException("Student Id klopt niet");
                }
            }
            }
        else {
            throw new IdNotFoundRequestException("Topic id klopt niet");
        }
        return null;
    }


    public List<Topic> getTopicsByMasterWithoutStudents(long id) throws IdNotFoundRequestException {
        if (personRepository.findById(id).isPresent()){
            List<TargetAudience> targetAudiences = personRepository.findById(id).get().getTargetAudience();
            List<Topic> topics = new ArrayList<>();
            for (TargetAudience t: targetAudiences){
                List<Topic> opgehaald = topicRepository.findByTargetAudiences(t);
                for(Topic top: opgehaald){
                    if(Boolean.TRUE.equals(!top.getHide_topic() && top.getApproved_topic()) && !topics.contains(top) && (top.getStudent_list().size() != top.getAantal_studenten())){
                        topics.add(top);
                    }
                }
            }

        return topics;
        }else{
            throw new IdNotFoundRequestException("Id van master is niet gevonden");
        }
    }

    public Topic getTopicForMaster(Long id) throws IdNotFoundRequestException {
        if(topicRepository.findById(id).isPresent()){
            return topicRepository.findById(id).get();
        }else {
            throw new IdNotFoundRequestException("Dit id: "+ id +" is niet gevonden");
        }
    }

    public Topic getAssignedTopic(Long studentid) throws IdNotFoundRequestException, NietApprovedRequestException {
        if(appUserRepository.findById(studentid).isPresent()){
            AppUser test = appUserRepository.findById(studentid).get();
            if(test.getAppUserRole() == AppUserRole.STUDENT){
                for (Topic t: topicRepository.findAll()){
                    for (Student s: t.getStudent_list()){
                        if(Objects.equals(s.getId(), studentid)){
                            return t;
                        }else {
                            throw new NietApprovedRequestException("Je bent niet approved");
                        }
                    }
                }
            }
        }
        else {
            throw new IdNotFoundRequestException("Dit id: "+ studentid +" is niet gevonden");
     }
        return null;
    }

    public List<Topic> getTopicsByMasterWithPromotor(long id) throws IdNotFoundRequestException {
        if (personRepository.findById(id).isPresent()){
            List<TargetAudience> targetAudiences = personRepository.findById(id).get().getTargetAudience();
            List<Topic> topics = new ArrayList<>();
            for (TargetAudience t: targetAudiences){
                List<Topic> opgehaald = topicRepository.findByTargetAudiences(t);
                for(Topic top: opgehaald){
                    if(Boolean.TRUE.equals(!top.getHide_topic() && top.getApproved_topic()) && !topics.contains(top) && top.getPromotor() == null){
                        topics.add(top);
                    }
                }
            }

            return topics;
        }else{
            throw new IdNotFoundRequestException("Id van master is niet gevonden");
        }
    }
}
