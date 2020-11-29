/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Departement;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author victo
 */
public interface DepartementService {

    Departement save(Departement entity);

    void delete(Long id);

    List<Departement> findAll();

    Optional<Departement> findById(Long id);

    Departement findByLibelle(String Libelle);

    Departement getOne(Long id);
}
