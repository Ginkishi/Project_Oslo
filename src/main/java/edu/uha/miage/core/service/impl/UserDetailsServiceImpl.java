/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.web.controller.RootController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Psyrkoz
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    CompteService compteService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("Username is empty");
        }
        
        Compte compte = compteService.findByUsername(username);
        if(compte != null) {
            LOGGER.error("Compte " + username + " trouver");
            return compte.currentDetails();
        }
        
        throw new UsernameNotFoundException("Aucun compte avec se nom de compte");
    }
    
}
