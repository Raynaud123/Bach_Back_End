package com.example.project.topicprovider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicProviderService {

    private final TopicProviderRepository repository;

    @Autowired
    public TopicProviderService(TopicProviderRepository repository) {
        this.repository = repository;
    }


    public List<TopicProvider> findById(long id) {
        return repository.findAllById(Collections.singleton(id));
    }

    public List<TopicProvider> findAll() {
        return repository.findAll();
    }

    public void addNewTopicProvider(TopicProvider topicProvider) {

        Optional<TopicProvider> topicProviderEmail = repository.findTopicProviderByEmail(topicProvider.getEmail());
        if(topicProviderEmail.isPresent()){
            throw new IllegalStateException("Email is Taken");
        }
        repository.saveAndFlush(topicProvider);
    }

}
