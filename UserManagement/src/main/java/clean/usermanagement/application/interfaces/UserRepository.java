package clean.usermanagement.application.interfaces;

import clean.usermanagement.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(UUID id);
}
