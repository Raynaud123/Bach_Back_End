package com.example.project.student;

import com.example.project.keyword.Keyword;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public List<Student> findAllStudents() { return studentRepository.findAll();}

    public boolean findBoolPreferredTopicByID(long id, long topicid) {
        List<Student> all = studentRepository.findAll();
        for(Student s: all){
            if(Objects.equals(s.getId(), id)){
                topicRepository.getById(topicid);
                if (s.getPreferredTopics().contains(topicRepository.getById(topicid)))
                    return true;
            }
        }
        return false;
    }


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
