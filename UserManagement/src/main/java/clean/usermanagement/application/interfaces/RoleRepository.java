package clean.usermanagement.application.interfaces;

import clean.usermanagement.domain.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository {
    Role save(Role role);
    Optional<Role> findById(UUID id);
}
