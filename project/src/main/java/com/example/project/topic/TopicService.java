package com.example.project.topic;

import com.example.project.appuser.AppUserRepository;
import com.example.project.student.Student;
import com.example.project.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void addNewTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public List<Topic> findAllApprovedTopics() {

        List<Topic> appr = new ArrayList<Topic>();
        List<Topic> all = topicRepository.findAll();
        for(Topic top: all){
            if(top.getApproved_topic()){
                appr.add(top);
            }
        }
        return appr;
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
}
