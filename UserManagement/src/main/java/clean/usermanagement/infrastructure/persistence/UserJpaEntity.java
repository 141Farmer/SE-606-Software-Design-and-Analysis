package clean.usermanagement.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class UserJpaEntity {

    @Id
    private UUID id;

    private String name;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleJpaEntity> roles = new ArrayList<>();

    public UserJpaEntity() {
    }

    public UserJpaEntity(UUID id, String name, String email, List<RoleJpaEntity> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleJpaEntity> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleJpaEntity> roles) {
        this.roles = roles;
    }
}