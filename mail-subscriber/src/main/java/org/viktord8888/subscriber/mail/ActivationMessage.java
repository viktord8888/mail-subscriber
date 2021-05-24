package org.viktord8888.subscriber.mail;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class ActivationMessage {

    private final String email;
    private final UUID userId;

}
