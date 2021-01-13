package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Domaine;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface DomaineService {

    Domaine save(Domaine entity);

    void delete(Long id);

    List<Domaine> findAll();

    Optional<Domaine> findById(Long id);

    Domaine findByLibelle(String libelle);

    Domaine getOne(Long id);
    
}
