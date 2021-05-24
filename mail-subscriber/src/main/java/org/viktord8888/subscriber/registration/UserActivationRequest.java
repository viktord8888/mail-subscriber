package org.viktord8888.subscriber.registration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
class UserActivationRequest {

    @Email
    private final String userId;

    @JsonCreator
    UserActivationRequest(@JsonProperty String userId) {
        this.userId = userId;
    }

}
