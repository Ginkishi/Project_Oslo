package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.DemandeIncident;
import edu.uha.miage.core.repository.DemandeIncidentRepository;
import edu.uha.miage.core.service.DemandeIncidentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kalictong
 */
@Service
public class DemandeIncidentServiceImpl implements DemandeIncidentService{

    @Autowired
    DemandeIncidentRepository demandeIncidentRepository;
            
    @Override
    public DemandeIncident save(DemandeIncident entity) {
        return demandeIncidentRepository.save(entity);
    }

    @Override
    public List<DemandeIncident> findAll() {
        return demandeIncidentRepository.findAll();
    }

    @Override
    public Optional<DemandeIncident> findByLocalisation(String localisation) {
        return demandeIncidentRepository.findByLocalisation(localisation);
    }

    @Override
    public Optional<DemandeIncident> findById(Long id) {
        return demandeIncidentRepository.findById(id);
    }

    
    
}
