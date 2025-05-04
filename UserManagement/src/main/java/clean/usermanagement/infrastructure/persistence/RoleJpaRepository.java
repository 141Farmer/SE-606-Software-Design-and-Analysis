package clean.usermanagement.infrastructure.persistence;

import clean.usermanagement.domain.Role;
import clean.usermanagement.application.interfaces.RoleRepository;
import clean.usermanagement.infrastructure.persistence.RoleJpaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

interface RoleJpaRepositoryInterface {
    Role save(Role role);
    Optional<Role> findById(UUID id);
    Optional<Role> findByRoleName(String roleName);
}

// ✅ Concrete class that implements the interface and handles persistence
@Repository
public class RoleJpaRepository implements RoleJpaRepositoryInterface, RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role save(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public Optional<Role> findById(UUID id) {
        Role role = entityManager.find(Role.class, id);
        return Optional.ofNullable(role);
    }

    @Override
    public Optional<Role> findByRoleName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT r FROM Role r WHERE r.roleName = :roleName", Role.class
        );
        query.setParameter("roleName", roleName);
        return query.getResultStream().findFirst();
    }
}

