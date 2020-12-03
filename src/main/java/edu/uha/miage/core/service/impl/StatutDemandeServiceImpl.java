/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.StatutDemande;
import edu.uha.miage.core.repository.StatutDemandeRepository;
import edu.uha.miage.core.service.StatutDemandeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class StatutDemandeServiceImpl implements StatutDemandeService {

    @Autowired
    StatutDemandeRepository statutDemandeRepository;

    @Override
    public StatutDemande save(StatutDemande entity) {
        return statutDemandeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        statutDemandeRepository.deleteById(id);
    }

    @Override
    public List<StatutDemande> findAll() {
        return (List<StatutDemande>) statutDemandeRepository.findAll();
    }

    @Override
    public Optional<StatutDemande> findById(Long id) {
        return statutDemandeRepository.findById(id);
    }

    @Override
    public StatutDemande findByLibelle(String libelle) {
        return statutDemandeRepository.findByLibelle(libelle);
    }

    @Override
    public StatutDemande getOne(Long id) {
        return statutDemandeRepository.getOne(id);
    }
    
}
