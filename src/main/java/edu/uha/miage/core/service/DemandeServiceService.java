package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.DemandeServices;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Quentin
 */
public interface DemandeServiceService {
    DemandeServices save(DemandeServices entity);
    List<DemandeServices> findAll();
    Optional<DemandeServices> findById(Long id);
    void cloture(Long id);
}