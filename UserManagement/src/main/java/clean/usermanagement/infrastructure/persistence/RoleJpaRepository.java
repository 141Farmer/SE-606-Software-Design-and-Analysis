package clean.usermanagement.infrastructure.persistence;

import clean.usermanagement.infrastructure.persistence.RoleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleJpaRepository extends JpaRepository<RoleJpaEntity, UUID> {
}
