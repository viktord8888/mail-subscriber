package org.viktord8888.subscriber.mail;

import org.viktord8888.subscriber.registration.ActiveSubscriber;

import java.util.Set;

public interface MailSenderFacade {

    void sendEmail(final Set<ActiveSubscriber> subscribers);

    void sendActivationMessage(ActivationMessage message);

}
