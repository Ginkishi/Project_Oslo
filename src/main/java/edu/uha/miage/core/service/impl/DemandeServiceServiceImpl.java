/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.repository.DemandeServiceRepository;
import edu.uha.miage.core.service.DemandeServiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Quentin
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
    public void cloture(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
