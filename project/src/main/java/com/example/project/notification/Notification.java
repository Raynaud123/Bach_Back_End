package com.example.project.notification;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Notification {
    @SequenceGenerator(
            name = "notification_sequence",
            sequenceName = "notification_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_sequence"
    )
    private Long notification_id;
    private NotificationSort notification_msg;
    private NotificationObjectSort object_name;
    private Long object_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date addedDate;


    public Notification(Long notification_id, NotificationSort notification_msg, NotificationObjectSort object_name, Long object_id, Date addedDate) {
        this.notification_id = notification_id;
        this.notification_msg = notification_msg;
        this.object_name = object_name;
        this.object_id = object_id;
        this.addedDate = addedDate;
    }

    public Long getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Long notification_id) {
        this.notification_id = notification_id;
    }

    public NotificationSort getNotification_msg() {
        return notification_msg;
    }

    public void setNotification_msg(NotificationSort notification_msg) {
        this.notification_msg = notification_msg;
    }

    public NotificationObjectSort getObject_name() {
        return object_name;
    }

    public void setObject_name(NotificationObjectSort object_name) {
        this.object_name = object_name;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
