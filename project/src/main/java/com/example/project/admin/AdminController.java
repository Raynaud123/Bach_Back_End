package com.example.project.admin;


import com.example.project.phase.Phase;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topicprovider.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping(path = "/update/phase/{pid}")
    @ResponseBody
    public void updatePhase(@PathVariable long pid,@RequestBody Phase phaseBody) throws ParseException {service.updatePhaseWithBody(pid,phaseBody);}

    @PostMapping(path = "/create/phase")
    @ResponseBody
    public void createNewPhase(@RequestBody Phase phaseBody) throws ParseException {service.createPhase(phaseBody);}

    @PostMapping(path = "/delete/phase")
    @ResponseBody
    public void deleteOldPhase(@RequestBody Phase phaseBody) throws ParseException {service.deletePhase(phaseBody);}

}
