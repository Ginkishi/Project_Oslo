/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.StatutDemande;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface StatutDemandeService {

    StatutDemande save(StatutDemande entity);

    void delete(Long id);

    List<StatutDemande> findAll();

    Optional<StatutDemande> findById(Long id);

    StatutDemande findByLibelle(String libelle);

    StatutDemande getOne(Long id);
}
