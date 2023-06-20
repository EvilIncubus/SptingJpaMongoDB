package org.aviasales.entity;

import java.time.LocalDateTime;

public class Notification {
    private int notificationId;
    private NotificationType notificationType;
    private int userId;
    private String description;
    private LocalDateTime notificationTime;
}
