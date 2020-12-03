/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service;

import edu.uha.miage.core.entity.Compte;

/**
 *
 * @author victo
 */
public interface CompteService {
    Compte save(Compte entity);
    Compte findByUsername(String username);
}
