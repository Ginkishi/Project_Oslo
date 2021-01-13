package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.entity.Fonction;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface FonctionService {
        Fonction save(Fonction entity);

    void delete(Long id);

    List<Fonction> findAll();

    Optional<Fonction> findById(Long id);

    Fonction findByLibelle(String libelle);

    Fonction getOne(Long id);
    
        public List<Fonction> findByDepartement(Departement departement);
}
