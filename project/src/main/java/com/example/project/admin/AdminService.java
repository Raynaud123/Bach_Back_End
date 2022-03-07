package com.example.project.admin;

import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;
    @Autowired
    private TopicProviderRepository topicProviderRepository;

    public List<TopicProvider> findAllTopicProviders() {

        return topicProviderRepository.findAll();

    }
}
