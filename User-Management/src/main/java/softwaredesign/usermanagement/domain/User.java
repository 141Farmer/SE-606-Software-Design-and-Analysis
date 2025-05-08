package softwaredesign.usermanagement.domain;


import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private String email;
    private List<Role> roles = new ArrayList<>();

    public User(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    public void assignRole(Role role) {

        this.roles.add(role);
    }
}
