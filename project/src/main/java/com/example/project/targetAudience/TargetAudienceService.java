package com.example.project.targetAudience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetAudienceService {

    @Autowired
    private TargetAudienceRepository TargetAudienceRepository;


    public List<TargetAudience> findAll() { return TargetAudienceRepository.findAll(); }
}
