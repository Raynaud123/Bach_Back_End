package com.example.project.admin;


import com.example.project.keyword.Keyword;
import com.example.project.phase.Phase;
import com.example.project.student.Student;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topicprovider.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService service;


    @GetMapping(path = "/{id}")
    public Optional<Admin> getAdminById(@PathVariable long id) {
        return service.findAdmin(id);
    }

    @GetMapping(path = "/topicprovider")
    public List<TopicProvider> getAllTopicProviders() {
        return service.findAllTopicProviders();
    }

    @GetMapping(path = "/topicprovider/approved")
    public List<TopicProvider> getAllApprovedTopicProviders() {
        return service.findAllApprovedTopicProviders();
    }


    @GetMapping(path = "/phase")
    public List<Phase> getAllPhases(){
        return service.getAllPhases();
    }

    @PutMapping(path = "/phase/{id}")
    @ResponseBody
    public void updatePhaseDeadlines(@PathVariable long id,@RequestBody Map<String,String> test) throws ParseException {service.updatePhase(id,test);}

    @GetMapping(path = "/targetAudience")
    public List<TargetAudience> getAllTargetAudiences() {
        return service.findAllTargetAudience();
    }

    @PostMapping(path = "/update/phase/{pid}")
    @ResponseBody
    public void updatePhase(@PathVariable long pid,@RequestBody Phase phaseBody) throws ParseException {service.updatePhaseWithBody(pid,phaseBody);}

    @PostMapping(path = "/create/phase")
    @ResponseBody
    public void createNewPhase(@RequestBody Phase phaseBody) throws ParseException {service.createPhase(phaseBody);}

    @PostMapping(path = "/delete/phase")
    @ResponseBody
    public void deleteOldPhase(@RequestBody Phase phaseBody) throws ParseException {service.deletePhase(phaseBody);}

    @PostMapping(path = "/update/targetaudience/{taid}")
    @ResponseBody
    public void updateTargetAudience(@PathVariable long taid,@RequestBody TargetAudience TABody) throws ParseException {service.updateTargetAudienceWithBody(taid,TABody);}

    @PostMapping(path = "/create/targetaudience")
    @ResponseBody
    public void createNewTargetAudience(@RequestBody TargetAudience TABody) throws ParseException {service.createTargetAudience(TABody);}

    @PostMapping(path = "/delete/targetaudience")
    @ResponseBody
    public void deleteOldTargetAudience(@RequestBody TargetAudience TABody) throws ParseException {service.deleteTargetAudience(TABody);}

    @PostMapping(path = "/update/keywprd/{kid}")
    @ResponseBody
    public void updateKeyword(@PathVariable long kid,@RequestBody Keyword keywordBody) throws ParseException {service.updateKeywordWithBody(kid,keywordBody);}

    @PostMapping(path = "/create/keyword")
    @ResponseBody
    public void createNewKeyword(@RequestBody Keyword KBody) throws ParseException {service.createKeyword(KBody);}

    @PostMapping(path = "/delete/keyword")
    @ResponseBody
    public void deleteOldKeyword(@RequestBody Keyword KBody) throws ParseException {service.deleteKeyword(KBody);}

}
