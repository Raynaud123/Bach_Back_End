package com.example.project.topic;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "topic")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PutMapping(path = "/putApprove")
    public String updateApprove(@RequestBody UpdateTopicApproveRequest request) {
        return topicService.updateApprove(request);
    }

    @PutMapping(path = "/{topic_id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Topic updateTopicAssignment(@PathVariable Long topic_id, @Valid @RequestBody UpdateTopicStudentsRequest request) {
        return topicService.updateTopicAssignment(topic_id, request);
    }
    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable Long id) {
        return topicService.getTopic(id);
    }

    @GetMapping("/all")
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @GetMapping("/info/{topicId}")
    public Topic getTopicForInfo(@PathVariable Long topicId) { return topicService.getTopic(topicId); }

    @GetMapping("/promotor/{id}")
    public List<Topic> getTopicsFromPromotor(@PathVariable int id){
        return topicService.getTopicPromotorId(id);
    }

    @PutMapping("/boost/{id}")
    public Topic boostStudent(@PathVariable int id, @Valid @RequestBody BoostStudentRequest request){
        return topicService.boostStudent(id, request);
    }



/*
    @PutMapping
    public String updatePromotor(@RequestBody UpdateTopicPromotorRequest request) {
        return topicService.updatePromotor(request);
    }*/


    @GetMapping(path = "/approved")
    public List<Topic> getAllApprovedTopics() { System.out.println(topicService.findAllApprovedTopics());
        return topicService.findAllApprovedTopics();  }


    @PostMapping
    public void registerNewTopic( @RequestBody TopicPostRequest topic) { topicService.addNewTopic(topic); }



}
