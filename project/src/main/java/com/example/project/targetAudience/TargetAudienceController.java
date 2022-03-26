package com.example.project.targetAudience;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "targetaudience")
@AllArgsConstructor
public class TargetAudienceController {

    @Autowired
    private TargetAudienceService targetAudienceService;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/all")
    public List<TargetAudience> findAllTargetAudiences() { return targetAudienceService.findAll(); }

}
