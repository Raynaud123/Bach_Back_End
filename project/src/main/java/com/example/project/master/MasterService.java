package com.example.project.master;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterService {

    private final MasterRepository masterRepository;

    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    public Optional<Master> findById(Long id) {
        return masterRepository.findById(id);
    }
}
