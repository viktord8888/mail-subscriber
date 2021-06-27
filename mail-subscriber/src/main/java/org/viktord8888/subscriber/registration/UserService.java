package org.viktord8888.subscriber.registration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.viktord8888.subscriber.mail.ActivationMessage;
import org.viktord8888.subscriber.mail.MailSenderFacade;
import org.viktord8888.subscriber.notification.Notification;
import org.viktord8888.subscriber.notification.NotificationRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
class UserService implements SubscriberFacade {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;
    private final MailSenderFacade mailSenderFacade;


    User register(final UserRegistrationRequest request) {
        Optional<User> maybeUser = userRepository.findByEmail(request.getEmail());
        maybeUser.ifPresent(user -> {
            log.info("User registration failed. User with given email = {} already exists with id = {}.", user.getEmail(), user.getUserId());
            throw new UserAlreadyExistsException();
        });
        var user = userRepository.save(User.of(request.getEmail()));
        mailSenderFacade.sendActivationMessage(ActivationMessage.of(user.getEmail(), user.getUserId()));
        return user;
    }

    User activateUser(final String userId) {
        var user = userRepository.findByUserId(UUID.fromString(userId))
                .orElseThrow(UserNotFoundException::new);
        return userRepository.save(user.activate());
    }

    public Set<ActiveSubscriber> getAll() {
        Iterable<Notification> notifications = notificationRepository.findAll();
        return userRepository.findAllByActive(true)
                .stream()
                .map(user -> toActiveSubscriber(user, notifications))
                .collect(Collectors.toSet());
    }

    private ActiveSubscriber toActiveSubscriber(final User user, Iterable<Notification> notifications) {
        for (Notification notification : notifications) {
            for (Notification userNotification : user.getNotifications()) {
                if (!notification.equals(userNotification)) {
                    return ActiveSubscriber.of(user.getEmail(), notification);
                }
            }
        }

        return ActiveSubscriber.of(user.getEmail(), null);
    }
}
