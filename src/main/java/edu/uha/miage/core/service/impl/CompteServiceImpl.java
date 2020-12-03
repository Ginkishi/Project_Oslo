/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.repository.CompteRepository;
import edu.uha.miage.core.service.CompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class CompteServiceImpl implements CompteService{
    @Autowired
    CompteRepository compteRepository;

    @Override
    public Compte save(Compte entity) {
        return compteRepository.save(entity);
    }
    
    @Override
    public Compte findByUsername(String username) {
        return compteRepository.findByUsername(username);
    }
}
