package com.example.project.phase;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PhaseService {
    private final PhaseRepository phaseRepository;

    public PhaseService(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    public Phase getPhase() {
        List<Phase> all = phaseRepository.findAll();
        Date today = new Date();

        for(Phase p: all){
            if(today.compareTo(p.getEnd_deadline()) <= 0){
                return p;
            }
        }

        return null;
    }

    public List<Phase> findAllPhases(){
        return phaseRepository.findAll();
    }

    public List<Phase> findAllNotHidePhases() {
        List<Phase> allPhase = phaseRepository.findAll();
        List<Phase> returnList = new ArrayList<>();
        for (Phase p : allPhase){
            if(Boolean.FALSE.equals(p.getHide())){
                returnList.add(p);
            }
        }
        return returnList;
    }
}
