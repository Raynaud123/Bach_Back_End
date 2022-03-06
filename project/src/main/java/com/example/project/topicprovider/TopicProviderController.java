package com.example.project.topicprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "topicprovider")
public class TopicProviderController {

    @Autowired
    private TopicProviderService service;

    public TopicProviderController(TopicProviderService service) {
        this.service = service;
    }

    @GetMapping
    public List<TopicProvider> getAllTopicProviders(){
        return service.findAll();
    }


    @GetMapping(path = "/{id}")
    public List<TopicProvider> getById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping
    public void registerNewTopicProvider(@RequestBody TopicProvider TopicProvider) {
        service.addNewTopicProvider(TopicProvider);
    }


}
