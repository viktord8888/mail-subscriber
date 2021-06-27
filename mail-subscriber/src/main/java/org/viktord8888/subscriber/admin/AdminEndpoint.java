package org.viktord8888.subscriber.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
@RequiredArgsConstructor
public class AdminEndpoint {

    private final AdminService adminService;

    @PostMapping(value = "/notification", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addNotification(@RequestBody NotificationRequest notificationRequest) {
        adminService.addNotification(notificationRequest.getContent());
        return ResponseEntity.ok("Notification successfully created");
    }
}
