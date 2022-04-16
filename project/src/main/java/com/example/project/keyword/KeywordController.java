package com.example.project.keyword;

import com.example.project.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "keyword")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;


    @GetMapping("/all")
    public List<Keyword> getKeywords() {
        return keywordService.getAll();
    }

    public Keyword getKeyword(long l) { return keywordService.findById(l); }
}
