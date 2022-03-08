package com.example.project.topic;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) { this.topicRepository = topicRepository; }

    public void addNewTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
