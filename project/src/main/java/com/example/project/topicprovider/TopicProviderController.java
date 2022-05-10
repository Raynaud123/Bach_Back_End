package com.example.project.topicprovider;

import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.exceptions.NietApprovedRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "topicprovider")
public class TopicProviderController {

    @Autowired
    private TopicProviderService topicProviderService;

    public TopicProviderController(TopicProviderService service) {
        this.topicProviderService = service;
    }

    @GetMapping(path = "/all")
    public List<TopicProvider> getAllTopicProviders(){
        return topicProviderService.findAll();
    }


    @GetMapping(path = "/{id}")
    public TopicProvider getById(@PathVariable long id) throws IdNotFoundRequestException {
        return topicProviderService.findById(id);
    }

    @GetMapping(path = "/approved/{id}")
    public TopicProvider getByHidedId(@PathVariable long id) throws NietApprovedRequestException, IdNotFoundRequestException {
        return topicProviderService.findByNotHidedId(id).get();
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
