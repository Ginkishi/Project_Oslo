package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.DemandeIncident;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Kalictong
 */
public interface DemandeIncidentService {
    DemandeIncident save(DemandeIncident entity);
    List<DemandeIncident> findAll();
    Optional<DemandeIncident> findByLocalisation(String localisation);
    Optional<DemandeIncident> findById(Long id);
}
