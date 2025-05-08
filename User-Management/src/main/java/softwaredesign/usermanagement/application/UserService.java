package softwaredesign.usermanagement.application;


import softwaredesign.usermanagement.domain.User;
import softwaredesign.usermanagement.domain.Role;
import softwaredesign.usermanagement.application.interfaces.UserRepository;
import softwaredesign.usermanagement.application.interfaces.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // FR1: Create a new user
    public UUID createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }

    // FR3: Assign a role to a user
    public void assignRoleToUser(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        user.assignRole(role);
        userRepository.save(user);
    }

    public void removeRoleFromUser(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.getRoles().removeIf(role -> role.getId().equals(roleId));
        userRepository.save(user);
    }

    // FR4: Fetch user details with roles
    public User getUserWithRoles(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }


}