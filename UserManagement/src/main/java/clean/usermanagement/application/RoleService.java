package clean.usermanagement.application;

import clean.usermanagement.domain.Role;
import clean.usermanagement.application.interfaces.RoleRepository;

import java.util.UUID;

public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UUID createRole(String roleName) {
        UUID id = UUID.randomUUID();
        Role role = new Role(id, roleName);
        roleRepository.save(role);
        return id;
    }
}
