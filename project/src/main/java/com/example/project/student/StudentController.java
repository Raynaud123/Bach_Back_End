package com.example.project.student;

import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicService;
import com.example.project.topicprovider.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
