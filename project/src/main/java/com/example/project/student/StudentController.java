package com.example.project.student;

import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(path = "/topics/approved")
    public List<Topic> getAllApprovedTopics() { return service.findAllApprovedTopics(); }
}
