package com.example.project.subjectprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/subjectprovider")
public class SubjectProviderController {

    @Autowired
    private SubjectProviderService Service;


}
