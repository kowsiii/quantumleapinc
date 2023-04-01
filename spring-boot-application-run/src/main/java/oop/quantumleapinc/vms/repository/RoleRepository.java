package oop.quantumleapinc.vms.repository;

import oop.quantumleapinc.vms.model.ERole;
import oop.quantumleapinc.vms.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    boolean existsByName(ERole name);
}
