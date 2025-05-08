package softwaredesign.usermanagement.infrastructure.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import softwaredesign.usermanagement.application.UserService;
import softwaredesign.usermanagement.domain.Role;
import softwaredesign.usermanagement.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UUID createUser(@Valid @RequestBody CreateUserRequest request) {
        return userService.createUser(request.getName(), request.getEmail());
    }


    @PostMapping("/{userId}/assign-role/{roleId}")
    public String assignRoleToUser(
            @PathVariable UUID userId,
            @PathVariable UUID roleId
    )
    {
        userService.assignRoleToUser(userId, roleId);
        return "Role assigned successfully";
    }


    @GetMapping("/{id}")
    public UserResponse getUserDetails(@PathVariable UUID id) {
        User user = userService.getUserWithRoles(id);
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRoles()
        );
    }

    @DeleteMapping("/{userId}/remove-role/{roleId}")
    public String removeRoleFromUser(
            @PathVariable UUID userId,
            @PathVariable UUID roleId
    ) {
        userService.removeRoleFromUser(userId, roleId);
        return "Role removed successfully";
    }


    @AllArgsConstructor
    @Getter
    @Setter
    public static class CreateUserRequest {
        @NotBlank(message = "Name cannot be blank")
        private String name;

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email must be valid")
        private String email;

    }

    @Getter
    @AllArgsConstructor
    public static class UserResponse {
        private UUID id;
        private String name;
        private String email;
        private List<Role> roles;

    }


}