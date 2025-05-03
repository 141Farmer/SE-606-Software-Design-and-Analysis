package clean.usermanagement.config;

import clean.usermanagement.application.UserService;
import clean.usermanagement.application.RoleService;
import clean.usermanagement.application.interfaces.UserRepository;
import clean.usermanagement.application.interfaces.RoleRepository;
import clean.usermanagement.infrastructure.persistence.UserRepositoryImpl;
import clean.usermanagement.infrastructure.persistence.RoleRepositoryImpl;
import clean.usermanagement.infrastructure.persistence.UserJpaRepository;
import clean.usermanagement.infrastructure.persistence.RoleJpaRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository) {
        return new UserService(userRepository, roleRepository);
    }

    @Bean
    public RoleService roleService(RoleRepository roleRepository) {
        return new RoleService(roleRepository);
    }

    @Bean
    public UserRepository userRepository(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        return new UserRepositoryImpl(userJpaRepository, roleJpaRepository);
    }

    @Bean
    public RoleRepository roleRepository(RoleJpaRepository roleJpaRepository) {
        return new RoleRepositoryImpl(roleJpaRepository);
    }
}