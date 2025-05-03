package clean.usermanagement.domain;

import java.util.Objects;
import java.util.UUID;

public class Role {
    private UUID id;
    private String roleName;

    public Role(UUID id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public UUID getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    // Override equals and hashCode so Role comparison works in lists
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
