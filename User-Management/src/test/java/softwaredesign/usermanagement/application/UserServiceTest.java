package softwaredesign.usermanagement.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import softwaredesign.usermanagement.application.interfaces.RoleRepository;
import softwaredesign.usermanagement.application.interfaces.UserRepository;
import softwaredesign.usermanagement.domain.User;

import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_ValidInput_ReturnsUserId() {
        String name = "John Doe";
        String email = "john@example.com";
        User expectedUser = new User(name, email);
        when(userRepository.save(any(User.class))).thenReturn(expectedUser.getId());

        UUID userId = userService.createUser(name, email);

        assertNotNull(userId);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void getUserWithRoles_NotFound_ThrowsException() {
        UUID userId = UUID.randomUUID();
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            userService.getUserWithRoles(userId);
        });
    }
}