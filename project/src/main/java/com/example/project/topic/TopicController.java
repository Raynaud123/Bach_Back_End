package com.example.project.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping
public class TopicController {

    @Autowired
    private TopicService topicService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/topics/approved")
    public List<Topic> getAllApprovedTopics() { return topicService.findAllApprovedTopics(); }

    /* werkt nog niet -> geblokt door CORS
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewTopic(@RequestBody Topic topic) { topicService.addNewTopic(topic); }
    */
}
