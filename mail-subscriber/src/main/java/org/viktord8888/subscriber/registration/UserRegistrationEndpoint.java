package org.viktord8888.subscriber.registration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@Slf4j
class UserRegistrationEndpoint {

    private final UserService userService;

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    UserRegistrationResponse register(@Validated final @RequestBody UserRegistrationRequest request) {
        log.info("Received user registration request: {}", request);
        var user = userService.register(request);
        return UserRegistrationResponse.of(user.getEmail(), user.getUserId().toString());
    }

    @GetMapping("/users")
    Set<ActiveSubscriber> listUsers() {
        return userService.getAll();
    }

}
