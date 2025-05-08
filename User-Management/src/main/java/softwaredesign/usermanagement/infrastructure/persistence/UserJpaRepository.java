package softwaredesign.usermanagement.infrastructure.persistence;

import org.springframework.stereotype.Component;
import softwaredesign.usermanagement.application.interfaces.UserRepository;
import softwaredesign.usermanagement.domain.User;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserJpaRepository implements UserRepository {

    private final JpaUserRepository jpaRepo;

    public UserJpaRepository(JpaUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public UUID save(User user) {
        UserJpaEntity entity = new UserJpaEntity(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        jpaRepo.save(entity);
        return entity.getId();
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return jpaRepo.findById(userId)
                .map(entity -> {
                    User user = new User(entity.getName(), entity.getEmail());
                    user.setId(entity.getId());
                    return user;
                });
    }
}

