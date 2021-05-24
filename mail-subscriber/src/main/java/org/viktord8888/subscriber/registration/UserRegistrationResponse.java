package org.viktord8888.subscriber.registration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
class UserRegistrationResponse {

    private final String userId;
    private final String email;

}
