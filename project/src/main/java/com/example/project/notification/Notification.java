package com.example.project.notification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String notification_msg;
    private NotificationSort object_name;
    private Long object_id;

    public Long getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Long notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_msg() {
        return notification_msg;
    }

    public void setNotification_msg(String notification_msg) {
        this.notification_msg = notification_msg;
    }

    public NotificationSort getObject_name() {
        return object_name;
    }

    public void setObject_name(NotificationSort object_name) {
        this.object_name = object_name;
    }

    public Long getObject_id() {
        return object_id;
    }

    public void setObject_id(Long object_id) {
        this.object_id = object_id;
    }
}
