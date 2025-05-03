package clean.usermanagement.infrastructure.controller;

import clean.usermanagement.application.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Map<String, UUID>> createRole(@RequestBody CreateRoleRequest request) {
        UUID roleId = roleService.createRole(request.getRoleName());
        return ResponseEntity.ok(Map.of("roleId", roleId));
    }

    // DTO
    public static class CreateRoleRequest {
        private String roleName;

        public String getRoleName() {
            return roleName;
        }
        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }
}
