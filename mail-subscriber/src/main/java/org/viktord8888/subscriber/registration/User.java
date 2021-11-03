package org.viktord8888.subscriber.registration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.viktord8888.subscriber.notification.Notification;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private boolean active;
    private UUID userId;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_notification",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "notification_id")}
    )
    Set<Notification> notifications = new HashSet<>();

    public static User of(final String email) {
        var user = new User();
        user.email = email;
        user.userId = UUID.randomUUID();
        user.active = false;
        return user;
    }

    User setActive() {
        this.active = true;
        return this;
    }

}
