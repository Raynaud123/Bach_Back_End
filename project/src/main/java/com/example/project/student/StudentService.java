package com.example.project.student;

import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRepository;
import com.example.project.keyword.Keyword;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import com.example.project.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicService topicService;

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

    public boolean findBoolPreferredTopicByName(long id, String topicname) {
        List<Student> all = studentRepository.findAll();
        for(Student s: all){
            if(Objects.equals(s.getId(), id)){
                if (s.getPreferredTopics().contains(topicService.getTopicByString(topicname)))
                    return true;
            }
        }
        return false;
    }

    public void setPreferrence(Long id, Long topicid) {
        System.out.println("Student id: " + id + " and topicid: " + topicid);
        Topic t = topicService.getTopic(topicid);
        for(Student s: studentRepository.findAll()){
            if(Objects.equals(s.getId(), id)){
                System.out.println("Student found: " + s);
                System.out.println("Student contains: " + topicid + " = " + s.getPreferredTopics().contains(t));
                if (s.getPreferredTopics().contains(t)) {
                    s.getPreferredTopics().remove(t);
                    System.out.println("Remove topicid: " + t.toString());
                }
                else {
                    s.getPreferredTopics().add(t);
                    System.out.println("Add topicid: " + t.toString());
                }
                studentRepository.save(s);
//                System.out.println("Student contains: " + t.toString() + " = " + s.getPreferredTopics().contains(t));
//                if (preferred && !s.getPreferredTopics().contains(t)) {
//                    s.getPreferredTopics().add(t);
//                    System.out.println("Add topicid: " + t.toString());
//                }
//                else {
//                    s.getPreferredTopics().remove(t);
//                    System.out.println("Remove topicid: " + t.toString());
//                    System.out.println("Student without topic: " + s);
//
//                }
            }
        }
        if (studentRepository.count() == 0) System.out.println("No students");
    }

    public List<Topic> findAllPreferredTopics(long id) {
        for(Student s: studentRepository.findAll()){
            if(Objects.equals(s.getId(), id)){
                return s.getPreferredTopics();
            }
        }
        return null;
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
