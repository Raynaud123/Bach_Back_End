package com.example.project.topicprovider;


import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.exceptions.NietApprovedRequestException;
import com.example.project.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class TopicProviderService {

    private final TopicProviderRepository topicProviderRepository;

    @Autowired
    public TopicProviderService(TopicProviderRepository repository) {
        this.topicProviderRepository = repository;
    }


    public TopicProvider findById(long id) throws IdNotFoundRequestException {
        if(topicProviderRepository.findById(id).isPresent()){
            return topicProviderRepository.findById(id).get();
        }else  {
            throw new IdNotFoundRequestException("Id is niet gevonden");
        }

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


    public TopicProvider getTopicProvider(Long id) {
        List<TopicProvider> all = topicProviderRepository.findAll();
        for(TopicProvider tp: all){
            if(Objects.equals(tp.getId(), id)){
                return tp;
            }
        }
        return null;
    }

    public TopicProvider findByNotHidedId(long id) throws NietApprovedRequestException, IdNotFoundRequestException {
        Optional<TopicProvider> topic = topicProviderRepository.findById(id);
        if(topic.isPresent()){
            if(topic.get().isApproved()){
                return topic.get();
            }else{
                throw new NietApprovedRequestException("Topicprovider met " + id + " is niet approved");
            }
        }
        throw new IdNotFoundRequestException("Topicprovider met " + id + " niet gevonden");
    }

//    public void addTopic(long id, Topic topic) {
//        topicProviderRepository.getById(id).getTopic_list().add(topic);
//    }
}
