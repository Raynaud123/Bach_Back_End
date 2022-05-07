package com.example.project.topicprovider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TopicProviderService {

    private final TopicProviderRepository topicProviderRepository;

    @Autowired
    public TopicProviderService(TopicProviderRepository repository) {
        this.topicProviderRepository = repository;
    }


    public Optional<TopicProvider> findById(long id) {
        return topicProviderRepository.findById(id);
    }

    public List<TopicProvider> findAll() {
        return topicProviderRepository.findAll();
    }

    public void addNewTopicProvider(TopicProvider topicProvider) {

        Optional<TopicProvider> topicProviderEmail = topicProviderRepository.findTopicProviderByEmail(topicProvider.getEmail());
        if(topicProviderEmail.isPresent()){
            throw new IllegalStateException("Email is Taken");
        }
        topicProviderRepository.saveAndFlush(topicProvider);
    }

    public void findTopicsFromTopicProviderById(long id) {

    }

    public TopicProvider getTopicProvider(Long id) {
        List<TopicProvider> all = topicProviderRepository.findAll();
        for(TopicProvider tp: all){
            if(Objects.equals(tp.getId(), id)){
                return tp;
            }
        }
        return null;
    }

//    public void addTopic(long id, Topic topic) {
//        topicProviderRepository.getById(id).getTopic_list().add(topic);
//    }
}
