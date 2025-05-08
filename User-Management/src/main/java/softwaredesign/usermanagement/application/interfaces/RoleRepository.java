package softwaredesign.usermanagement.application.interfaces;

import softwaredesign.usermanagement.domain.Role;
import java.util.UUID;
import java.util.Optional;

public interface RoleRepository {
    UUID save(Role role);
    Optional<Role> findById(UUID roleId);
}
