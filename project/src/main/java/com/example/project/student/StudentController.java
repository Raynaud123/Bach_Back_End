package com.example.project.student;

import com.example.project.topic.Topic;
import com.example.project.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TopicService topicService;

    }
