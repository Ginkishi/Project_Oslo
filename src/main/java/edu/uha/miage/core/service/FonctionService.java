/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Fonction;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface FonctionService {
        Fonction save(Fonction entity);

    void delete(Long id);

    List<Fonction> findAll();

    Optional<Fonction> findById(Long id);

    Fonction findByLibelle(String libelle);

    Fonction getOne(Long id);
}
