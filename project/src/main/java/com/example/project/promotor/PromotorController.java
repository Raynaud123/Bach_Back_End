package com.example.project.promotor;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Promotor> getPromotorByIdFromFrontend(@PathVariable Long id) {
        return promotorService.findByIdFromFrontend(id);
    }

    public Promotor getPromotorById(Long id) {
        return promotorService.findById(id);
    }
//    @GetMapping("/topics/{id}")
//    public List<Topic> getPromotorTopics(@PathVariable Long id){
//        return promotorService.findPromotorTopics(id);
//    }

}
