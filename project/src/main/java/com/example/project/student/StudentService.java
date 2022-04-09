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

    public void setPreferrence(Long id, String topicname) {
        List<Student> all = studentRepository.findAll();
        for(Student s: all){
            if(Objects.equals(s.getId(), id)){
                System.out.println(s);
                if (s.getPreferredTopics().contains(topicService.getTopicByString(topicname))) {
                    s.getPreferredTopics().remove(topicService.getTopicByString(topicname));
                    System.out.println("Add: " + topicService.getTopicByString(topicname));
                }
                else {
                    s.getPreferredTopics().add(topicService.getTopicByString(topicname));
                    System.out.println("Remove: " + topicService.getTopicByString(topicname));
                }
            }
            else{
                System.out.println("No student found by id: " + id);

            }
        }
        if (studentRepository.count() == 0) System.out.println("No students");
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
