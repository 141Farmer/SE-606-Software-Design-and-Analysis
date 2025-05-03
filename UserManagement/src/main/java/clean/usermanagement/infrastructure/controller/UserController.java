package clean.usermanagement.infrastructure.controller;

import clean.usermanagement.application.UserService;
import clean.usermanagement.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, UUID>> createUser(@RequestBody CreateUserRequest request) {
        UUID userId = userService.createUser(request.getName(), request.getEmail());
        return ResponseEntity.ok(Map.of("userId", userId));
    }

    @PostMapping("/{userId}/assign-role/{roleId}")
    public ResponseEntity<Void> assignRole(
            @PathVariable UUID userId,
            @PathVariable UUID roleId) {
        userService.assignRoleToUser(userId, roleId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID userId) {
        User user = userService.getUserDetails(userId);
        return ResponseEntity.ok(UserResponse.fromDomain(user));
    }

    // DTOs
    public static class CreateUserRequest {
        private String name;
        private String email;

        public String getName() { return name; }
        public String getEmail() { return email; }

        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }
    }

    public static class UserResponse {
        private UUID id;
        private String name;
        private String email;
        private List<String> roles;

        public static UserResponse fromDomain(User user) {
            UserResponse response = new UserResponse();
            response.id = user.getId();
            response.name = user.getName();
            response.email = user.getEmail();
            response.roles = user.getRoles().stream()
                    .map(role -> role.getRoleName())
                    .toList();
            return response;
        }

        // Getters
        public UUID getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public List<String> getRoles() { return roles; }
    }
}
