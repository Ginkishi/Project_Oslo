package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Compte;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface CompteService {
    Compte save(Compte entity);
    Compte findByUsername(String username);
    List<Compte> findAll();
    Optional<Compte> findById(Long id);
    void delete(Long id);
}
