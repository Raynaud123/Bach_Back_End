package com.example.project.keyword;

import com.example.project.targetAudience.TargetAudience;
import com.example.project.targetAudience.TargetAudienceRepository;
import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;


    public Keyword findById(long l) {
        List<Keyword> all = keywordRepository.findAll();
        for(Keyword k: all){
            if(Objects.equals(k.getKeyword_id(), l)){
                return k;
            }
        }
        return null;
    }

    public List<Keyword> getAll() {
            return keywordRepository.findAll();
    }
}
