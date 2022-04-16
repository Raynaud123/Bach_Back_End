package com.example.project.phase;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhaseService {
    private PhaseRepository phaseRepository;

    public PhaseService(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    public Phase getPhase() {
        List<Phase> all = phaseRepository.findAll();
        Date today = new Date();

        for(Phase p: all){
            if(today.getTime() <= p.getEnd_deadline().getTime()){
                return p;
            }
        }
        return null;
    }

    public List<Phase> findAllPhases() {
        return phaseRepository.findAll();
    }
}
