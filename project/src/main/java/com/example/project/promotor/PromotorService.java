package com.example.project.promotor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Promotor> findById(Long id) {
        return promotorRepository.findById(id);
    }

    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }

}
