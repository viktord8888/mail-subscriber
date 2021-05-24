package org.viktord8888.subscriber.registration;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserId(UUID userId);

    Set<User> findAllByActive(boolean active);

}
