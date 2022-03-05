package com.example.project.topicprovider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
}
