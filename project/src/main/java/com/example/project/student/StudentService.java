package com.example.project.student;

import com.example.project.topic.TopicRepository;
import com.example.project.topicprovider.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


//    public List<Topic> findPreferredTopics() {
//        List<Topic> pref = new ArrayList<>();
//        List<Topic> all = topicRepository.findAll();
//
//        for(Topic top: all){
//            if(top.isPreferred()){
//                pref.add(top);
//            }
//        }
//        return pref;
//    }
}
