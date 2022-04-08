package com.example.project.promotor;

import com.example.project.topic.Topic;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/withtopic")
    public List<Promotor> getPromotorsWithTopic() {
        return promotorService.findPromotorsWithTopic();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Promotor getPromotorById(@PathVariable Long id) {
        return promotorService.findById(id);
    }

}
