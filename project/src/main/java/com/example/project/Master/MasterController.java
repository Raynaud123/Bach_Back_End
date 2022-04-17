package com.example.project.Master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
