/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Demande;
import java.util.Optional;
/**
 *
 * @author Kalictong
 */
public interface DemandeService {
    Demande save(Demande entity);
    Optional<Demande> findById(Long id);
}
