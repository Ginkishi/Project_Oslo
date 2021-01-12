/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.repository;

import edu.uha.miage.core.entity.DemandeIncident;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kalictong
 */
public interface DemandeIncidentRepository extends JpaRepository<DemandeIncident, Long>{
    Optional<DemandeIncident> findByLocalisation(String Localisation);
    Optional<DemandeIncident> findById(Long id);
}
