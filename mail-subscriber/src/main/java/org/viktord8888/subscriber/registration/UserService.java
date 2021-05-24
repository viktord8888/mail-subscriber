package org.viktord8888.subscriber.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.viktord8888.subscriber.mail.ActivationMessage;
import org.viktord8888.subscriber.mail.MailSenderFacade;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class UserService implements SubscriberFacade {

    private final UserRepository userRepository;
    private final MailSenderFacade mailSenderFacade;


    User register(final UserRegistrationRequest request) {
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
        return userRepository.findAllByActive(true)
                .stream()
                .map(user -> ActiveSubscriber.of(user.getEmail()))
                .collect(Collectors.toSet());
    }
}
