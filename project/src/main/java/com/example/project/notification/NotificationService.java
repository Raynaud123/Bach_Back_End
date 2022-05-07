package com.example.project.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;


    public Notification findById(long id) {
        List<Notification> alln = notificationRepository.findAll();
        for (Notification n : alln){
            if (n.getNotification_id() == id) {
                return n;
            }
        }
        return null;
    }

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
}
