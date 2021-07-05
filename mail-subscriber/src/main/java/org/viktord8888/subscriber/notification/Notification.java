package org.viktord8888.subscriber.notification;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.viktord8888.subscriber.registration.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notification {

    @Id
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
