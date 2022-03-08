package com.example.project.student;

import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private TopicRepository topicRepository;

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

}
