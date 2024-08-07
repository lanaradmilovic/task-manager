package rs.ac.bg.fon.notificationservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.notificationservice.exception.NotificationNotFoundException;
import rs.ac.bg.fon.notificationservice.model.Notification;
import rs.ac.bg.fon.notificationservice.model.Task;
import rs.ac.bg.fon.notificationservice.model.User;
import rs.ac.bg.fon.notificationservice.proxy.TaskServiceClient;
import rs.ac.bg.fon.notificationservice.proxy.UserServiceClient;
import rs.ac.bg.fon.notificationservice.repository.NotificationRepository;
import rs.ac.bg.fon.notificationservice.service.NotificationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private TaskServiceClient taskServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findByUserId(Long userId) {
        return notificationRepository.findAll()
                .stream().filter(notification -> notification.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Notification findById(Long id) {
        Optional<Notification> result = notificationRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotificationNotFoundException("Notification with id = " + id + " does not exist.");
        }
        return result.get();
    }

    @Override
    public void markAsRead(Long id) {
        Notification notification = findById(id);
        notification.setRead(true);
        notificationRepository.save(notification);
    }

    @Override
    public Notification createNotification(Long taskId) {
        Task task = taskServiceClient.getTaskById(taskId);
        User user = userServiceClient.getUserById(task.getUser().getId());

        Notification notification = new Notification();
        notification.setMessage(String.format("Dear %s, you have an upcoming task: '%s' at %s on %s.",
                user.getName(),
                task.getTitle(),
                task.getLocation(),
                task.getStartTime()
        ));
        notification.setTaskId(taskId);
        notification.setRead(false);

        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findUnreadNotificationsByUserId(Long userId) {
        return notificationRepository.findAll()
                .stream()
                .filter(notification -> !notification.isRead() && userId.equals(notification.getUserId()))
                .collect(Collectors.toList());
    }


}
