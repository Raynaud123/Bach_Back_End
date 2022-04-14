package com.example.project.promotor;

import com.example.project.topic.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PromotorService {

    private PromotorRepository promotorRepository;

    public PromotorService(PromotorRepository promotorRepository) { this.promotorRepository = promotorRepository; }

//    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }

    public List<Promotor> findPromotorsWithTopic() {
        List<Promotor> all = promotorRepository.findAll();
        ArrayList<Promotor> pwt = new ArrayList<>();

        for(Promotor p: all){
            if(p.getApproved() != null && p.getTopic() != null && p.getEnabled()){
                pwt.add(p);
            }
        }
        return pwt;
    }

    public Promotor findById(Long id) {
        List<Promotor> all = promotorRepository.findAll();
        for(Promotor p: all){
            if(p.getApproved() != null && Objects.equals(p.getId(), id)){
                return p;
            }
        }
        return null;
    }

    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }
//
//    public List<Topic> findPromotorTopics(Long id) {
//
//    }
}
