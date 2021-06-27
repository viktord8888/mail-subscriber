package org.viktord8888.subscriber.registration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.viktord8888.subscriber.notification.Notification;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ActiveSubscriber {

    private final String email;
    private final Notification nextNotification;

}
