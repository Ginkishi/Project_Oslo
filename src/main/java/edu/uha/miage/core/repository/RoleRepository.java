package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByLibelle(String libelle);
    Optional<Role> findById(Long id);
}
