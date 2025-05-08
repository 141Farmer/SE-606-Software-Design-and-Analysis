package softwaredesign.usermanagement.config;

import softwaredesign.usermanagement.application.UserService;
import softwaredesign.usermanagement.application.RoleService;
import softwaredesign.usermanagement.application.interfaces.UserRepository;
import softwaredesign.usermanagement.application.interfaces.RoleRepository;
import softwaredesign.usermanagement.infrastructure.persistence.JpaRoleRepository;
import softwaredesign.usermanagement.infrastructure.persistence.JpaUserRepository;
import softwaredesign.usermanagement.infrastructure.persistence.UserJpaRepository;
import softwaredesign.usermanagement.infrastructure.persistence.RoleJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    @Bean
    public UserRepository userRepository(JpaUserRepository jpaUserRepository) {
        return new UserJpaRepository(jpaUserRepository);
    }

    @Bean
    public RoleRepository roleRepository(JpaRoleRepository jpaRoleRepository) {
        return new RoleJpaRepository(jpaRoleRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository) {
        return new UserService(userRepository, roleRepository);
    }

    @Bean
    public RoleService roleService(RoleRepository roleRepository) {
        return new RoleService(roleRepository);
    }
}