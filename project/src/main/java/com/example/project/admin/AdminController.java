package com.example.project.admin;


import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.keyword.Keyword;
import com.example.project.master.Master;
import com.example.project.phase.Phase;
import com.example.project.promotor.Promotor;
import com.example.project.student.Student;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
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

    @PostMapping(path = "/update/keyword/{kid}")
    @ResponseBody
    public void updateKeyword(@PathVariable long kid,@RequestBody Keyword keywordBody) throws ParseException {service.updateKeywordWithBody(kid,keywordBody);}
    @PostMapping(path = "/create/keyword")
    @ResponseBody
    public void createNewKeyword(@RequestBody Keyword KBody) throws ParseException {service.createKeyword(KBody);}
    @PostMapping(path = "/delete/keyword")
    @ResponseBody
    public void deleteOldKeyword(@RequestBody Keyword KBody) {service.deleteKeyword(KBody);}

    @PostMapping(path = "/update/topic/{kid}")
    @ResponseBody
    public void updateTopic(@PathVariable long kid,@RequestBody UpdateTopicRequest updateTopicRequest) throws ParseException {service.updateTopicWithBody(kid,updateTopicRequest);}
    @PostMapping(path = "/create/topic")
    @ResponseBody
    public void createNewTopic(@RequestBody UpdateTopicRequest updateTopicRequest) throws ParseException {service.createTopic(updateTopicRequest);}
    @PostMapping(path = "/delete/topic")
    @ResponseBody
    public void deleteOldTopic(@RequestBody Topic Body) {service.deleteTopic(Body);}

    @PostMapping(path = "/update/student/{sid}")
    @ResponseBody
    public void updateStudent(@PathVariable long sid,@RequestBody UpdateStudentRequest updateStudentRequest) throws ParseException {service.updateStudentWithBody(sid,updateStudentRequest);}
    @PostMapping(path = "/create/student")
    @ResponseBody
    public void createNewStudent(@RequestBody UpdateStudentRequest updateStudentRequest) throws ParseException {service.createStudent(updateStudentRequest);}
    @PostMapping(path = "/delete/student")
    @ResponseBody
    public void deleteOldStudent(@RequestBody Student Body) {service.deleteStudent(Body);}

    @PostMapping(path = "/update/master/{mid}")
    @ResponseBody
    public void updateMaster(@PathVariable long mid, @RequestBody UpdateMasterRequest updateMasterRequest) throws ParseException {service.updateMasterWithBody(mid,updateMasterRequest);}
    @PostMapping(path = "/create/master")
    @ResponseBody
    public void createNewMaster(@RequestBody UpdateMasterRequest updateMasterRequest) throws ParseException {service.createMaster(updateMasterRequest);}
    @PostMapping(path = "/delete/master")
    @ResponseBody
    public void deleteOldMaster(@RequestBody Master Body) {service.deleteMaster(Body);}

    @PostMapping(path = "/update/promotor/{pid}")
    @ResponseBody
    public void updatePromotor(@PathVariable long pid, @RequestBody UpdatePromotorRequest r) throws ParseException {service.updatePromotorWithBody(pid,r);}
    @PostMapping(path = "/create/promotor")
    @ResponseBody
    public void createNewPromotor(@RequestBody UpdatePromotorRequest updateMasterRequest) throws ParseException {service.createPromotor(updateMasterRequest);}
    @PostMapping(path = "/delete/promotor")
    @ResponseBody
    public void deleteOldPromotor(@RequestBody Promotor Body) {service.deletePromotor(Body);}

    @PostMapping(path = "/update/topicprovider/{pid}")
    @ResponseBody
    public void updateProvider(@PathVariable long pid, @RequestBody UpdateProviderRequest r) throws ParseException {service.updateProviderWithBody(pid,r);}
    @PostMapping(path = "/create/topicprovider")
    @ResponseBody
    public void createNewProvider(@RequestBody UpdateProviderRequest r) throws ParseException {service.createProvider(r);}
    @PostMapping(path = "/delete/topicprovider")
    @ResponseBody
    public void deleteOldProvider(@RequestBody TopicProvider Body) {service.deleteProvider(Body);}

    @PostMapping(path = "/help/{masterid}")
    @ResponseBody
    public void approveCompany(@PathVariable Long masterid) throws IdNotFoundRequestException {service.askHelpFromAdmin(masterid);}

}
