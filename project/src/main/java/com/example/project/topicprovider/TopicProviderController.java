package com.example.project.topicprovider;

import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@RequestMapping(path = "topicprovider")
public class TopicProviderController {

    @Autowired
    private TopicProviderService topicProviderService;

    public TopicProviderController(TopicProviderService service) {
        this.topicProviderService = service;
    }

    @GetMapping
    public List<TopicProvider> getAllTopicProviders(){
        return topicProviderService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{id}")
    public List<TopicProvider> getById(@PathVariable long id) {
        return topicProviderService.findById(id);
    }

    @PostMapping
    public void registerNewTopicProvider(@RequestBody TopicProvider TopicProvider) {
        topicProviderService.addNewTopicProvider(TopicProvider);
    }

    @GetMapping(path= "topics/{id}")
    public void getTopicsSubmittedByTopicProvider(@PathVariable long id){
            //return service.findTopicsFromTopicProviderById(id);
    }

    public TopicProvider getTopicProviderById(@PathVariable long id) {
        return topicProviderService.getTopicProvider(id);
    }

}
