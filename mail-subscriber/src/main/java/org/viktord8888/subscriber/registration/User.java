package org.viktord8888.subscriber.registration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    static User of(final String email) {
        var user = new User();
        user.email = email;
        user.userId = UUID.randomUUID();
        user.active = false;
        return user;
    }

    User activate() {
        this.active = true;
        return this;
    }

}
