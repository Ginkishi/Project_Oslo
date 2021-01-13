package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.entity.Categorie;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface ServiceService {
    Services save(Services entity);

    void delete(Long id);

    List<Services> findAll();

    Optional<Services> findById(Long id);

    Services findByLibelle(String libelle);

    Services getOne(Long id);
    
    public List<Services> findByCategorie(Categorie categorie);
}
