package com.example.project.promotor;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "promotor")
@AllArgsConstructor
public class PromotorController {

    @Autowired
    private PromotorService promotorService;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "")
    public List<Promotor> getAllPromotors() {
        return promotorService.findAllPromotors();
    }
}
