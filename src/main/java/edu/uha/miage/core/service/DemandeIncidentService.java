/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.DemandeIncident;
import edu.uha.miage.core.entity.Incident;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Kalictong
 */
public interface DemandeIncidentService {
    DemandeIncident save(DemandeIncident entity);
    List<DemandeIncident> findAll();
    Optional<DemandeIncident> findByLocalisation(String localisation);
    Optional<DemandeIncident> findById(Long id);
}
