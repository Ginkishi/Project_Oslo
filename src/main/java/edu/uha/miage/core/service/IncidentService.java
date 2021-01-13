package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Incident;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Psyrkoz
 */
public interface IncidentService {
    Incident save(Incident entity);
    List<Incident> findAll();
    Optional<Incident> findByLibelle(String libelle);
    Optional<Incident> findById(Long id);
    void delete(Long id);
}
