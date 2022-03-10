package com.example.project.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) { this.topicRepository = topicRepository; }

    public void addNewTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public List<Topic> findAllApprovedTopics() {

        List<Topic> appr = new ArrayList<Topic>();
        List<Topic> all = topicRepository.findAll();
        for(Topic top: all){
            if(top.getApproved_topic()){
                appr.add(top);
            }
        }
        return appr;
    }
}
