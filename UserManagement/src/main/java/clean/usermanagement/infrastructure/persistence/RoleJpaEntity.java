package clean.usermanagement.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class RoleJpaEntity {

    @Id
    private UUID id;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<UserJpaEntity> users = new ArrayList<>();

    public RoleJpaEntity() {
    }

    public RoleJpaEntity(UUID id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserJpaEntity> getUsers() {
        return users;
    }
    public void setUsers(List<UserJpaEntity> users) {
        this.users = users;
    }
}
