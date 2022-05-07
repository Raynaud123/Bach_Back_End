package com.example.project.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;


    public Optional<Notification> findById(long id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
}
