package com.example.project.topic;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "topics")
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


/*
    @PutMapping
    public String updatePromotor(@RequestBody UpdateTopicPromotorRequest request) {
        return topicService.updatePromotor(request);
    }*/



 //   @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/approved")
    public List<Topic> getAllApprovedTopics() { return topicService.findAllApprovedTopics(); }

//     werkt nog niet -> geblokt door CORS
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewTopic(@RequestBody Topic topic) { topicService.addNewTopic(topic); }



}
