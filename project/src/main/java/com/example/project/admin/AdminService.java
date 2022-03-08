package com.example.project.admin;

import com.example.project.phase.Phase;
import com.example.project.phase.PhaseRepository;
import com.example.project.topicprovider.Company;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


    public void updatePhase(long id, Map<String,String> test) throws ParseException {
        Optional<Phase> faseResponse = phaseRepository.findById(id);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        java.util.Date bDate = format.parse(test.get("test"));
        java.util.Date eDate = format.parse(test.get("eindDatum"));

        if(faseResponse.isPresent()){
            Phase fase = faseResponse.get();
            fase.setBegin_deadline(bDate);
            fase.setEnd_deadline(eDate);
            phaseRepository.save(fase);
        }else {
            throw new IllegalStateException();
        }
    }
}
