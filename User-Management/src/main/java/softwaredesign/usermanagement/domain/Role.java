package softwaredesign.usermanagement.domain;



import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Role {
    private UUID id;
    private String roleName;

    public Role(String roleName) {
        this.id = UUID.randomUUID();
        this.roleName = roleName;
    }


}
