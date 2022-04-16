package com.example.project.phase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "phase")
@CrossOrigin(origins = "http://localhost:3000")
public class PhaseController {
    @Autowired
    private PhaseService phaseService;

    @GetMapping(path = "/now")
    public Phase getPhase() {
        return phaseService.getPhase();
    }

    @GetMapping(path = "/all")
    public List<Phase> getAllPhase() {
        return phaseService.findAllPhases();
    }
}
