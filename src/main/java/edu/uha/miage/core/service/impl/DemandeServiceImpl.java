package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Demande;
import edu.uha.miage.core.repository.DemandeRepository;
import edu.uha.miage.core.service.DemandeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kalictong
 */
@Service
public class DemandeServiceImpl implements DemandeService{

    @Autowired
    DemandeRepository demandeRepository;
            
    @Override
    public Demande save(Demande entity) {
        return demandeRepository.save(entity);
    }

    @Override
    public Optional<Demande> findById(Long id) {
        return demandeRepository.findById(id);
    }
}
