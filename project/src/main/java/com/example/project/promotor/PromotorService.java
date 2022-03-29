package com.example.project.promotor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotorService {

    private final PromotorRepository promotorRepository;

    public PromotorService(PromotorRepository promotorRepository) { this.promotorRepository = promotorRepository; }

    public List<Promotor> findAllPromotors() {
        List<Promotor> all = promotorRepository.findAll();
        return all;
    }


}
