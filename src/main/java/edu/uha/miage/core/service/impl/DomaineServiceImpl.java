/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Domaine;
import edu.uha.miage.core.repository.DomaineRepository;
import edu.uha.miage.core.service.DomaineService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class DomaineServiceImpl implements DomaineService {

    @Autowired
    DomaineRepository domaineRepository;

    @Override
    public Domaine save(Domaine entity) {
        return domaineRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        domaineRepository.deleteById(id);
    }

    @Override
    public List<Domaine> findAll() {
        return (List<Domaine>) domaineRepository.findAll();
    }

    @Override
    public Optional<Domaine> findById(Long id) {
        return domaineRepository.findById(id);
    }

    @Override
    public Domaine findByLibelle(String libelle) {
        return domaineRepository.findByLibelle(libelle);
    }

    @Override
    public Domaine getOne(Long id) {
        return domaineRepository.getOne(id);
    }
    
}
