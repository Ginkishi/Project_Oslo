package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Role;
import edu.uha.miage.core.repository.RoleRepository;
import edu.uha.miage.core.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class RoleServiceImpl implements RoleService{
        @Autowired
    RoleRepository roleRepository;

@Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role findByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    @Override
    public Role getOne(Long id) {
        return roleRepository.getOne(id);
    }

}
