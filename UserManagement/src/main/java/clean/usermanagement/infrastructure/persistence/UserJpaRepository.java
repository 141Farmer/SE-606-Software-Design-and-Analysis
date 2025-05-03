package clean.usermanagement.infrastructure.persistence;

import clean.usermanagement.infrastructure.persistence.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {
}