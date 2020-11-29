/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    Role findByLibelle(String nom);
    Role getOne(Long id);
}
