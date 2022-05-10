package com.example.project.targetAudience;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "targetaudience")
@AllArgsConstructor
public class TargetAudienceController {

    @Autowired
    private TargetAudienceService targetAudienceService;


    @GetMapping(path="/campus")
    public List<Campus> findAllCampus(){
            return  targetAudienceService.getAllCampus();
    }

    @GetMapping(path = "/courses")
    public List<Course> findAllCoursesByCampus(){
            return null;
    }


    @GetMapping(path = "/all")
    public List<TargetAudience> findAllTargetAudiences() { return targetAudienceService.findAll(); }

    @GetMapping(path = "/hided/all")
    public List<TargetAudience> findAllNotHidedTargetAudiences() { return targetAudienceService.findAllNotHided(); }


    public TargetAudience getTargetAudience(long i) { return targetAudienceService.findById(i); }
}
