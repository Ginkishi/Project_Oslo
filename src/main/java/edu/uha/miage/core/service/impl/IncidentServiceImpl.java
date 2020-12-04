package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Incident;
import edu.uha.miage.core.repository.IncidentRepository;
import edu.uha.miage.core.service.IncidentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quentin
 */
@Service
public class IncidentServiceImpl implements IncidentService {
    
    @Autowired
    IncidentRepository incidentRepository;

    @Override
    public Incident save(Incident entity) {
        return incidentRepository.save(entity);
    }
    
    @Override
    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }
    
    @Override
    public Optional<Incident> findByLibelle(String libelle) {
        return incidentRepository.findByLibelle(libelle);
    }

    @Override
    public Optional<Incident> findById(Long id) {
        return incidentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        incidentRepository.deleteById(id);
    }
}
