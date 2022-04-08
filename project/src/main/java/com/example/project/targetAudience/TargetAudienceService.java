package com.example.project.targetAudience;

import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class TargetAudienceService {

    @Autowired
    private TargetAudienceRepository targetAudienceRepository;


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
}
