package com.example.project.topic;

import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.exceptions.NietApprovedRequestException;
import com.example.project.exceptions.NietTop3TopicExceptionRequest;
import com.example.project.student.Student;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "topic")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PutMapping(path = "/putApprove")
    public String updateApprove(@RequestBody UpdateTopicApproveRequest request) {
        return topicService.updateApprove(request);
    }

    @PutMapping(path = "/{topic_id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> updateTopicAssignment(@PathVariable Long topic_id, @Valid @RequestBody UpdateTopicStudentsRequest request) throws NietTop3TopicExceptionRequest, NietApprovedRequestException, IdNotFoundRequestException {
        return topicService.updateTopicAssignment(topic_id, request);
    }
    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable Long id) throws NietApprovedRequestException, IdNotFoundRequestException {
        return topicService.getTopic(id);
    }
    @GetMapping("/master/{id}")
    public Topic getTopicForMaster(@PathVariable Long id) throws IdNotFoundRequestException {
        return topicService.getTopicForMaster(id);
    }
    @GetMapping("/assigned/{studentid}")
    public Topic getAssignTopic(@PathVariable Long studentid) throws NietApprovedRequestException, IdNotFoundRequestException {
        return topicService.getAssignedTopic(studentid);
    }

    @GetMapping("/all")
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @GetMapping("/info/{topicId}")
    public Topic getTopicForInfo(@PathVariable Long topicId) throws NietApprovedRequestException, IdNotFoundRequestException { return topicService.getTopic(topicId); }

    @GetMapping("/promotor/{id}")
    public List<Topic> getTopicsFromPromotor(@PathVariable int id){
        return topicService.getTopicPromotorId(id);
    }

    @PutMapping("/boost/{id}")
    public Topic boostStudent(@PathVariable int id, @NotNull @Valid @RequestBody BoostStudentRequest request) throws IdNotFoundRequestException {
        return topicService.boostStudent(id, request);
    }
    @PutMapping("/assing/{prom_id}/{topic_id}")
    public Topic assign(@PathVariable long prom_id,@PathVariable long topic_id) throws IdNotFoundRequestException {
        return topicService.assingProm(prom_id,topic_id);
    }

    @GetMapping(path = "/approved")
    public List<Topic> getAllApprovedTopics() { //System.out.println(topicService.findAllApprovedTopics());
        return topicService.findAllApprovedTopics();  }

    @GetMapping(path = "/hided/{id}")
    public List<Topic> getAllMasterTopics(@PathVariable long id) throws IdNotFoundRequestException {return topicService.getTopicsByMasterWithoutStudents(id);}

    @GetMapping(path = "/hided/promotor/{id}")
    public List<Topic> getAllMasterTopicsWithoutProm(@PathVariable long id) throws IdNotFoundRequestException {return topicService.getTopicsByMasterWithPromotor(id);}


    @PostMapping
    public void registerNewTopic( @RequestBody TopicPostRequest topic) {
        topicService.addNewTopic(topic); }


}
