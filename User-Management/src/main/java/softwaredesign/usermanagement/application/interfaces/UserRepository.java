package softwaredesign.usermanagement.application.interfaces;



import softwaredesign.usermanagement.domain.User;
import java.util.UUID;
import java.util.Optional;

public interface UserRepository {
    UUID save(User user);
    Optional<User> findById(UUID userId);
}
