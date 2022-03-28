package com.example.project.admin;


import com.example.project.phase.Phase;
import com.example.project.promotor.Promotor;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topicprovider.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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


    @GetMapping(path = "/phase")
    public List<Phase> getAllPhases(){
        return service.getAllPhases();
    }

    @PutMapping(path = "/phase/{id}")
    @ResponseBody
    public void updatePhaseDeadlines(@PathVariable long id,@RequestBody Map<String,String> test) throws ParseException {service.updatePhase(id,test);}

    @GetMapping(path = "/targetAudience")
    public List<TargetAudience> getAllTargetAudiences() {
        return service.findAllTargetAudience();
    }

}
