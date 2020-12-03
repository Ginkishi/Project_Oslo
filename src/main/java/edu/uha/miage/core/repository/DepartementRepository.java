/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.Departement;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface DepartementRepository extends JpaRepository<Departement, Long> {

    Departement findByLibelle(String libelle);

    Optional<Departement> findById(Long id);

}
