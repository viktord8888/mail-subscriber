package org.viktord8888.subscriber.registration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.viktord8888.subscriber.mail.ActivationMessage;
import org.viktord8888.subscriber.mail.MailSenderFacade;
import org.viktord8888.subscriber.notification.NotificationRepository;

import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private MailSenderFacade mailSenderFacade;

    private UserService tested;

    @Before
    public void createMocks() {
        MockitoAnnotations.initMocks(this);
        tested = new UserService(userRepository, notificationRepository, mailSenderFacade);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void should_throw_exception_when_user_already_exists() {
        User user = new User();

        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(user));

        tested.register(new UserRegistrationRequest("testing123@gmail.com"));
    }

    @Test
    public void should_register_user() {
        // given
        User user = User.of("test@gmail.com");

        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        // when
        User result = tested.register(new UserRegistrationRequest("test@gmail.com"));

        // then
        Assert.assertNotNull(result.getEmail());
        Mockito.verify(mailSenderFacade).sendActivationMessage(Mockito.any(ActivationMessage.class));
    }

}
