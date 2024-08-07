package rs.ac.bg.fon.notificationservice.service;

import rs.ac.bg.fon.notificationservice.model.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);
    List<Notification> findByUserId(Long userId);
    Notification findById(Long id);
    void markAsRead(Long id);
    Notification createNotification(Long taskId);
    List<Notification> findUnreadNotificationsByUserId(Long userId);
}
