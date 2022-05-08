package com.example.project.master;

import com.example.project.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    @GetMapping("/all")
    public List<Master> getAllMasters(){
        return masterService.findAll();
    }

    @GetMapping("/{id}")
    public Master getMasterById(@PathVariable Long id) {
        return masterService.findById(id);
    }

//    public void addAwaitApprovedTopic(Long id,Topic topic){
//        masterService.addAwaitApprovedTopicToList(id, topic);
//    }

    @GetMapping("/{id}/notifications")
    public List<Notification> getNotifications(@PathVariable Long id) {
        return masterService.getNotifications(id);
    }

    @PutMapping(path = "/{masterid}/approve/{approve}/topic/{topicid}")
    @ResponseBody
    public void approveTopic(@PathVariable Long masterid,@PathVariable Long topicid, @PathVariable Boolean approve){masterService.approveTopicById(masterid,topicid,approve);}

}
