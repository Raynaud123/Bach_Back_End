package com.example.project.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping(path = "keyword")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/all")
    public List<Notification> getKeywords() {
        return notificationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Notification> getKeyword(@PathVariable long id) { return notificationService.findById(id); }
}
