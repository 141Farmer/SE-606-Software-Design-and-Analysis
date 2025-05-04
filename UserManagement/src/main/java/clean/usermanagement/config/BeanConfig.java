package clean.usermanagement.config;

import clean.usermanagement.application.UserService;
import clean.usermanagement.application.RoleService;
import clean.usermanagement.application.interfaces.UserRepository;
import clean.usermanagement.application.interfaces.RoleRepository;


import clean.usermanagement.infrastructure.persistence.RoleJpaRepository;
import clean.usermanagement.infrastructure.persistence.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserService userService(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        return new UserService(userJpaRepository, roleJpaRepository);
    }

    @Bean
    public RoleService roleService(RoleJpaRepository roleJpaRepository) {
        return new RoleService(roleJpaRepository);
    }


}