package org.viktord8888.subscriber.notification;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.viktord8888.subscriber.registration.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notification {

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @ManyToMany(mappedBy = "notifications")
    private Set<User> users = new HashSet<>();

    public static Notification of(String content) {
        return new Notification(null, content, null, null);
    }

}
