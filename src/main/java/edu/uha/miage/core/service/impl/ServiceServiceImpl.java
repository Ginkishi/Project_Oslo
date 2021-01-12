/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Categorie;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.repository.ServiceRepository;
import edu.uha.miage.core.service.ServiceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository fonctionRepository;

    @Override
    public Services save(Services entity) {
        return fonctionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        fonctionRepository.deleteById(id);
    }

    @Override
    public List<Services> findAll() {
        return (List<Services>) fonctionRepository.findAllByOrderByLibelle();
    }

    @Override
    public Optional<Services> findById(Long id) {
        return fonctionRepository.findById(id);
    }

    @Override
    public Services findByLibelle(String libelle) {
        return fonctionRepository.findByLibelle(libelle);
    }

    @Override
    public Services getOne(Long id) {
        return fonctionRepository.getOne(id);
    }
    @Override
    public List<Services> findByCategorie(Categorie categorie) {
        return fonctionRepository.findByCategorieOrderByLibelle(categorie);

    }
}
