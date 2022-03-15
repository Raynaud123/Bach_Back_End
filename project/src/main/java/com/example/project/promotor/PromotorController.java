package com.example.project.promotor;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "promotor")
@AllArgsConstructor
public class PromotorController {

    @Autowired
    private PromotorService promotorService;

    @GetMapping(path = "/list")
    public List<Promotor> getAllPromotors() {
        return promotorService.findAllPromotors();
    }
}
