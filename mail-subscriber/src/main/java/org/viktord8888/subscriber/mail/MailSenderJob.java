package org.viktord8888.subscriber.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.viktord8888.subscriber.registration.ActiveSubscriber;
import org.viktord8888.subscriber.registration.SubscriberFacade;

import java.util.Set;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
class MailSenderJob {

    private final MailSenderFacade mailSenderFacade;
    private final SubscriberFacade subscriberFacade;

//    @Scheduled(cron = "${mail.sender.cron}")
    @Scheduled(fixedDelay = 30000)
    void sendEmails() {
        Set<ActiveSubscriber> all = subscriberFacade.getAll();
        log.info("Sending notifications to {} active subscribers.", all.size());
        all.
                forEach(this::process);
    }

    private void process(ActiveSubscriber activeSubscriber) {
        mailSenderFacade.sendEmail(activeSubscriber);
        subscriberFacade.saveActiveSubscriber(activeSubscriber);
    }

}
