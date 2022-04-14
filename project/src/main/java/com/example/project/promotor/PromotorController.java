package com.example.project.promotor;

import com.example.project.appuser.AppUser;
import com.example.project.topic.Topic;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "promotor")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class PromotorController {

    @Autowired
    private PromotorService promotorService;

    @GetMapping(path = "/all")
    public List<Promotor> getAllPromotors() { return promotorService.findAllPromotors(); }

    @GetMapping(path = "/withtopic")
    public List<Promotor> getPromotorsWithTopic() {
        return promotorService.findPromotorsWithTopic();
    }

    @GetMapping("/{id}")
    public Promotor getPromotorById(@PathVariable long id) {
        return promotorService.findById(id);
    }

//    @GetMapping("/topics/{id}")
//    public List<Topic> getPromotorTopics(@PathVariable Long id){
//        return promotorService.findPromotorTopics(id);
//    }

}
