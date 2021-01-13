/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
