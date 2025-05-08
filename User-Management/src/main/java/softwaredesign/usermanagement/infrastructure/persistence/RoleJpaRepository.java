package softwaredesign.usermanagement.infrastructure.persistence;

import org.springframework.stereotype.Component;
import softwaredesign.usermanagement.application.interfaces.RoleRepository;
import softwaredesign.usermanagement.domain.Role;
import java.util.Optional;
import java.util.UUID;

@Component
public class RoleJpaRepository implements RoleRepository {

    private final JpaRoleRepository jpaRepo;

    public RoleJpaRepository(JpaRoleRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public UUID save(Role role) {
        RoleJpaEntity entity = new RoleJpaEntity(role.getId(), role.getRoleName());
        jpaRepo.save(entity);
        return entity.getId();
    }

    @Override
    public Optional<Role> findById(UUID roleId) {
        return jpaRepo.findById(roleId)
                .map(entity -> new Role(entity.getId(), entity.getRoleName()));
    }
}

