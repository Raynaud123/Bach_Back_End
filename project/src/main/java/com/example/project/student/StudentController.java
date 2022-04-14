package com.example.project.student;

import com.example.project.topic.Topic;
import com.example.project.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TopicService topicService;


//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping(path = "/preferred")
//    public List<Topic> getPreferredTopics() { return studentService.findPreferredTopics(); }

    @GetMapping(path = "/topics/{id}")
    public List<Topic> getTopicsById(@PathVariable long id) {
        return topicService.findById(id);
    }

    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable long id) {
        System.out.println(studentRepository.findById(id));
        return studentRepository.getById(id);
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping(path = "/{id}/preferred/all")
    public List<Topic> getAllPreferredTopics(@PathVariable long id) {
        return studentService.findAllPreferredTopics(id);
    }

    @GetMapping(path = "/{id}/preferred/{topicid}")
    public boolean getBoolPreferredTopic(@PathVariable long id, @PathVariable long topicid) {
        return studentService.findBoolPreferredTopicByID(id, topicid);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/{id}/submitpreferrencetopic/{topicid}")
    public void setPreferenceTopic(@PathVariable Long id, @PathVariable Long topicid) { studentService.setPreferrence(id, topicid);
    }

}
