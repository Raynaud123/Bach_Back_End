package com.example.project.admin;


import com.example.project.topicprovider.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "admin")
public class AdminController {

    @Autowired
    private AdminService service;


    @GetMapping(path = "/topicprovider")
    public List<TopicProvider> getAllTopicProviders() {
        return service.findAllTopicProviders();
    }

    @GetMapping(path = "/topicprovider/approved")
    public List<TopicProvider> getAllApprovedTopicProviders() {
        return service.findAllApprovedTopicProviders();
    }

}
