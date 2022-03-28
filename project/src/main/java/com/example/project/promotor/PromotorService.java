package com.example.project.promotor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PromotorService {

    private PromotorRepository promotorRepository;

    public PromotorService(PromotorRepository promotorRepository) { this.promotorRepository = promotorRepository; }

    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }
}
