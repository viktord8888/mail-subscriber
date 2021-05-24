package org.viktord8888.subscriber.registration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ActiveSubscriber {

    private final String email;

}
