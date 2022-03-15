package com.example.project.topic;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "topics")
@AllArgsConstructor
public class TopicController {

    //private final TopicService topicService;

    @Autowired
    private TopicService topicService;

    @PutMapping
    public String updateApprove(@RequestBody ApproveRequest request) {
        return topicService.updateApprove(request);
    }
/*
    @PutMapping
    public String updatePromotor(@RequestBody PromotorRequest request) {
        return topicService.updatePromotor(request);
    }*/

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/approved")
    public List<Topic> getAllApprovedTopics() { return topicService.findAllApprovedTopics(); }

    /* werkt nog niet -> geblokt door CORS
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewTopic(@RequestBody Topic topic) { topicService.addNewTopic(topic); }
    */



}
