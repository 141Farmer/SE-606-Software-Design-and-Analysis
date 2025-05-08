package softwaredesign.usermanagement.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface JpaUserRepository extends JpaRepository<UserJpaEntity, UUID> {

}
