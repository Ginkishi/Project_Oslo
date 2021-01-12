/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Categorie;

import edu.uha.miage.core.repository.CategorieRepository;
import edu.uha.miage.core.service.CategorieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author victo
 */
@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie save(Categorie entity) {
        return categorieRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<Categorie> findAll() {
        return (List<Categorie>) categorieRepository.findAllByOrderByParentAscLibelleAsc();
    }

    @Override
    public Optional<Categorie> findById(Long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public Categorie findByLibelle(String libelle) {
        return categorieRepository.findByLibelle(libelle);
    }

    @Override
    public Categorie getOne(Long id) {
        return categorieRepository.getOne(id);
    }
    @Override
    public List<Categorie> findByParent(Categorie parent) {
        return categorieRepository.findByParentOrderByLibelle(parent);
    }    

    @Override
    public List<Categorie> findByEnfantsIsNull() {
        return categorieRepository.findByEnfantsIsNull();
    }
}
