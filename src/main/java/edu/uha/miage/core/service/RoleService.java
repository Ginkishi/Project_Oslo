package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Role;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface RoleService {
    Role save(Role entity);
    void delete(Long id);
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role findByLibelle(String libelle);
    Role getOne(Long id);
}
