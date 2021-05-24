package org.viktord8888.subscriber.registration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;

@ToString
@Getter
class UserRegistrationRequest {

    @Email
    private final String email;

    @JsonCreator
    UserRegistrationRequest(@JsonProperty String email) {
        this.email = email;
    }
}
