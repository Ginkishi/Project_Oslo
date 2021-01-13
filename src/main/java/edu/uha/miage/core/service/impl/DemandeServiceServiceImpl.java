package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.repository.DemandeServiceRepository;
import edu.uha.miage.core.service.DemandeServiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Psyrkoz
 */
@Service
public class DemandeServiceServiceImpl implements DemandeServiceService {

    @Autowired
    DemandeServiceRepository repo;
    
    @Override
    public DemandeServices save(DemandeServices entity) {
        return repo.save(entity);
    }

    @Override
    public List<DemandeServices> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<DemandeServices> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<DemandeServices> findByCreateur(Personne p) {
        return this.repo.findByCreateur(p);
    }
    
}
