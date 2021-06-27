package org.viktord8888.subscriber.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.viktord8888.subscriber.notification.Notification;
import org.viktord8888.subscriber.notification.NotificationRepository;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final NotificationRepository notificationRepository;

    Notification addNotification(final String content) {
        Notification notification = Notification.of(content);
        return notificationRepository.save(notification);
    }

}
