package softwaredesign.usermanagement.infrastructure.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import softwaredesign.usermanagement.application.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import lombok.Getter;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public UUID createRole(@Valid @RequestBody CreateRoleRequest request) {
        return roleService.createRole(request.getRoleName());
    }


    @Getter
    @Setter
    public static class CreateRoleRequest {
        @NotBlank(message = "Role name cannot be blank")
        private String roleName;
    }
}
