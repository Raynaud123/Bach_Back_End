package com.example.project.student;

import com.example.project.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TopicService topicService;

    }
