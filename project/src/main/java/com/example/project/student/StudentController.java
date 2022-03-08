package com.example.project.student;

import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/topics/approved")
    public List<Topic> getAllApprovedTopics() { return service.findAllApprovedTopics(); }
}
