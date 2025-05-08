package softwaredesign.usermanagement.application;


import softwaredesign.usermanagement.domain.Role;
import softwaredesign.usermanagement.application.interfaces.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // FR2: Create a new role
    public UUID createRole(String roleName) {
        Role role = new Role(roleName);
        return roleRepository.save(role);
    }
}