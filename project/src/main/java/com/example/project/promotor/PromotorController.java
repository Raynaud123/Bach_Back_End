package com.example.project.promotor;

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

//    @GetMapping(path = "/all")
//    public List<Promotor> getAllPromotors() {
//        return promotorService.findAllPromotors();
//    }

    @GetMapping(path = "/withtopic")
    public List<Promotor> getPromotorsWithTopic() {
        return promotorService.findPromotorsWithTopic();
    }
}
