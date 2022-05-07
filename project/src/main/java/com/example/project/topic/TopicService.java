package com.example.project.topic;

import com.example.project.keyword.Keyword;
import com.example.project.keyword.KeywordRepository;
import com.example.project.promotor.PromotorRepository;
import com.example.project.student.Student;
import com.example.project.student.StudentRepository;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.targetAudience.TargetAudienceRepository;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addNewTopic(TopicPostRequest request) {

        List<Keyword> keywords = new ArrayList<>();
        List<TargetAudience> targetAudiences = new ArrayList<>();

        for(int i = 0; i < request.keywords.length; i++){
            keywords.add(keywordRepository.getById(request.keywords[i]));
        }

        for(int i = 0; i < request.targetAudience.length; i++){
            targetAudiences.add(targetAudienceRepository.getById(request.targetAudience[i]));
        }
        Topic topic = new Topic(request.topicName,request.description_topic,request.aantal_studenten, keywords, targetAudiences,request.provider_id);

        topicRepository.save(topic);
    }

    public List<Topic> findAllApprovedTopics() {
        List<Topic> all = topicRepository.findAll();
        ArrayList<Topic> app = new ArrayList<>();
        for(Topic top: all){
            if(top.getApproved_topic() != null && top.getApproved_topic()){
                app.add(top);
            }
        }
        return app;
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

    public Topic updateTopicAssignment(Long topic_id, UpdateTopicStudentsRequest request) {
        Topic storedTopic = topicRepository.getById(topic_id);
        Long storedID = request.getStudent_id();
        storedTopic.addStudent(studentRepository.getById(storedID));

        topicRepository.save(storedTopic);
        return storedTopic;
    }

    public List<Topic> findById(long id) {
        return topicRepository.findAllById(Collections.singleton(id));
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }


    public Topic getTopic(Long id) {
        List<Topic> all = topicRepository.findAll();
        for(Topic top: all){
            if(Objects.equals(top.getTopic_id(), id)){
                return top;
            }
        }
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
//        if (!promotorRepository.existsById(promotor_id)) {
//            return null;
//        }

 //       promotorRepository.getById(promotor_id);

         return topicRepository.findByPromotor(promotorRepository.getById(promotor_id));
    }

    public Topic boostStudent(int id, BoostStudentRequest request) {
        if (topicRepository.findById((long)id).isPresent()) {
            Topic topic = topicRepository.getById((long) id);
            if(studentRepository.findById((long) request.studentId).isPresent()){
                Student student = studentRepository.getById((long) request.studentId);
                topic.setBoostedStudent(student);
                topicRepository.saveAndFlush(topic);
            }
            else{
                System.out.println("Studnet id fout");
                return null;
            }

            return topic;
        }
        else {
            System.out.println("toic id fout");
            return null;
        }
    }

//    public void addStudentToChoice1List(Student student, Long topicId) {
//        if (topicRepository.findById(topicId).isPresent()) {
//            Topic topic = topicRepository.getById(topicId);
//            if (!topic.getStudentsWithChoice1_list().contains(student)) {
//                topic.getStudentsWithChoice1_list().add(student);
//                topicRepository.save(topic);
//            }
//        }
//    }
}
