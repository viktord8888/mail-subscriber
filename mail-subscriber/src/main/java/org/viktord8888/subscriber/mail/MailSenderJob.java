package org.viktord8888.subscriber.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.viktord8888.subscriber.registration.SubscriberFacade;

@Component
@RequiredArgsConstructor
class MailSenderJob {

    private final MailSenderFacade mailSenderFacade;
    private final SubscriberFacade subscriberFacade;

    @Scheduled(cron = "${mail.sender.cron}")
    void sendEmails() {
        var subscribers = subscriberFacade.getAll();
        mailSenderFacade.sendEmail(subscribers);
    }

}
