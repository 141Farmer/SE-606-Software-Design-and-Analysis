package clean.usermanagement.application;

import clean.usermanagement.domain.User;
import clean.usermanagement.domain.Role;
import clean.usermanagement.application.interfaces.UserRepository;
import clean.usermanagement.application.interfaces.RoleRepository;

import java.util.UUID;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UUID createUser(String name, String email) {
        UUID id = UUID.randomUUID();
        User user = new User(id, name, email);
        userRepository.save(user);
        return id;
    }

    public void assignRoleToUser(UUID userId, UUID roleId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Role> optionalRole = roleRepository.findById(roleId);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        if (optionalRole.isEmpty()) {
            throw new RuntimeException("Role not found");
        }

        User user = optionalUser.get();
        Role role = optionalRole.get();
        user.addRole(role);
        userRepository.save(user); // persist changes
    }

    public User getUserDetails(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}