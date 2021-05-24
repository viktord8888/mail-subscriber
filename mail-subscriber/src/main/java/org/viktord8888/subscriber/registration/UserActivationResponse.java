package org.viktord8888.subscriber.registration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
class UserActivationResponse {

    private final String email;
    private final boolean active;

}
