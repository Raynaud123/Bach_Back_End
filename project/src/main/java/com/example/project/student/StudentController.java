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
    private TopicService topicService;


//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping(path = "/preferred")
//    public List<Topic> getPreferredTopics() { return studentService.findPreferredTopics(); }

    @GetMapping(path = "/{id}")
    public List<Topic> getById(@PathVariable long id) {
        return topicService.findById(id);
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

//    @GetMapping(path = "/{id}/preferred/{topicid}")
//    public boolean getBoolPreferredTopic(@PathVariable long id, @PathVariable long topicid) {
//        return studentService.findBoolPreferredTopicByID(id, topicid);
//    }

    @GetMapping(path = "/{id}/preferred/{topicname}")
    public boolean getBoolPreferredTopicWithName(@PathVariable long id, @PathVariable String topicname) {
        return studentService.findBoolPreferredTopicByName(id, topicname);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/{id}/submitpreferrencetopic/{topicName}")
    public void setPreferenceTopic(@PathVariable Long id, @PathVariable String topicName) { studentService.setPreferrence(id, topicName);
        System.out.println("Topic: " + topicName);
    }



}
