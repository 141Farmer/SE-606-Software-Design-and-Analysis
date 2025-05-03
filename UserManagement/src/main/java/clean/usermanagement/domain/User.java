package clean.usermanagement.domain;
import  java.util.ArrayList;
import  java.util.List;
import  java.util.Collections;
import  java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private List<Role> roles;

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = new ArrayList<>();
    }

    // Business Logic: Add Role
    public void addRole(Role role) {
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }

    // Getters (Setters only if necessary)
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return Collections.unmodifiableList(roles);
    }

}
