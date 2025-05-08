package softwaredesign.usermanagement.application;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import softwaredesign.usermanagement.application.interfaces.RoleRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void createRole_BlankName_ThrowsException() {
        assertThrows(ConstraintViolationException.class, () -> {
            roleService.createRole("");
        });
    }
}