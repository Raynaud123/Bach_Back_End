package com.example.project.topicprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/topicprovider")
public class TopicProviderController {

    @Autowired
    private TopicProviderService Service;


}
