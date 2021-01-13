/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.entity.Fonction;
import edu.uha.miage.core.repository.FonctionRepository;
import edu.uha.miage.core.service.FonctionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    FonctionRepository fonctionRepository;

    @Override
    public Fonction save(Fonction entity) {
        return fonctionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        fonctionRepository.deleteById(id);
    }

    @Override
    public List<Fonction> findAll() {
        return (List<Fonction>) fonctionRepository.findAllByOrderByDepartementAscLibelleAsc();
    }

    @Override
    public Optional<Fonction> findById(Long id) {
        return fonctionRepository.findById(id);
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        return fonctionRepository.findByLibelle(libelle);
    }

    @Override
    public Fonction getOne(Long id) {
        return fonctionRepository.getOne(id);
    }
    @Override
    public List<Fonction> findByDepartement(Departement departement) {
        return fonctionRepository.findByDepartementOrderByLibelle(departement);

    }
    
}
