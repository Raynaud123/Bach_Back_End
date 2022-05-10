package com.example.project.targetAudience;

import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class TargetAudienceService {

    @Autowired
    private TargetAudienceRepository targetAudienceRepository;
    @Autowired
    private CampusRepository campusRepository;


    public List<TargetAudience> findAll() { return targetAudienceRepository.findAll(); }

    public TargetAudience findById(long i) {
        List<TargetAudience> all = targetAudienceRepository.findAll();
        for(TargetAudience t: all){
            if(Objects.equals(t.getTargetAudience_id(), i)){
                return t;
            }
        }
        return null;
    }

    public List<Campus> getAllCampus() {
        return campusRepository.findAll();
    }


    public List<TargetAudience> findAllNotHided() {
        List<TargetAudience> all = targetAudienceRepository.findAll();
        List<TargetAudience> returnTa = new ArrayList<>();

        for (TargetAudience t: all){
            if(Boolean.FALSE.equals(t.getHide())){
                returnTa.add(t);
            }
        }
        return returnTa;

    }
}
