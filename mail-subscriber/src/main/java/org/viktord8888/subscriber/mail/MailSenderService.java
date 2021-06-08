package org.viktord8888.subscriber.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.viktord8888.subscriber.registration.ActiveSubscriber;

@Service
@RequiredArgsConstructor
class MailSenderService implements MailSenderFacade {

    private final JavaMailSender emailSender;

    @Override
    @Async("mailSenderTaskExecutor")
    public void sendEmail(final ActiveSubscriber subscriber) {
        var emailMessage = createEmailMessage(subscriber);
        emailSender.send(emailMessage);
    }

    private SimpleMailMessage createEmailMessage(final ActiveSubscriber activeSubscriber) {
        var message = new SimpleMailMessage();
        message.setFrom("wiktormailsender@gmail.com");
        message.setTo(activeSubscriber.getEmail());
        message.setSubject("Java mail sender test");
        message.setText("dd");
        return message;
    }

    @Override
    public void sendActivationMessage(ActivationMessage message) {
        var mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("wiktormailsender@gmail.com");
        mailMessage.setTo(message.getEmail());
        mailMessage.setSubject("IT daily notifications activation link");
        mailMessage.setText(createActivationMessageContent(message));
        emailSender.send(mailMessage);
    }

    private String createActivationMessageContent(final ActivationMessage message) {
        var activationLink = String.format("http://localhost:4200/activate?user=%s", message.getUserId().toString());
        return "Please find below an activation link: " + System.lineSeparator() + activationLink;
    }
}
