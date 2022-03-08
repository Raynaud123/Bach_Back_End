package com.example.project.admin;

import com.example.project.phase.Phase;
import com.example.project.phase.PhaseRepository;
import com.example.project.topicprovider.Company;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;
    @Autowired
    private TopicProviderRepository topicProviderRepository;
    @Autowired
    private PhaseRepository phaseRepository;

    public List<TopicProvider> findAllTopicProviders() {

        return topicProviderRepository.findAll();

    }

    public List<TopicProvider> findAllApprovedTopicProviders() {

        List<TopicProvider> appr = new ArrayList<>();
        List<TopicProvider> all = topicProviderRepository.findAll();

        for(TopicProvider top: all){
            if(top.isApproved()){
                appr.add(top);
            }
        }

        return appr;

    }

    public List<Phase> getAllPhases() {
        return phaseRepository.findAll();
    }
}
