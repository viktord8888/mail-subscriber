package org.viktord8888.subscriber.registration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
class UserActivationEndpoint {

    private final UserService userService;

    @PostMapping(path = "/activate", consumes = "application/json", produces = "application/json")
    UserActivationResponse register(@RequestBody UserActivationRequest request) {
        log.info("Received user activation request for userId= {}", request.getUserId());
        var user = userService.activateUser(request.getUserId());
        return UserActivationResponse.of(user.getEmail(), user.isActive());
    }

}
