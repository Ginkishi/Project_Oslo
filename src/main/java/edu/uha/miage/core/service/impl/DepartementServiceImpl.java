/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.repository.DepartementRepository;
import edu.uha.miage.core.service.DepartementService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    DepartementRepository departementRepository;

    @Override
    public Departement save(Departement entity) {
        return departementRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departementRepository.deleteById(id);
    }

    @Override
    public List<Departement> findAll() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Optional<Departement> findById(Long id) {
        return departementRepository.findById(id);
    }

    @Override
    public Departement findByLibelle(String libelle) {
        return departementRepository.findByLibelle(libelle);
    }

    @Override
    public Departement getOne(Long id) {
        return departementRepository.getOne(id);
    }

}
