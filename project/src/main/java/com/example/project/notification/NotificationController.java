package com.example.project.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(path = "notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping("/all")
    public List<Notification> getNotifications() {
        return notificationService.getAll();
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable long id) { return notificationService.findById(id); }
}
