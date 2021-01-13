package edu.uha.miage.core.service.impl;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.service.CompteService;
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
    @Autowired
    CompteService compteService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("Username is empty");
        }
        
        Compte compte = compteService.findByUsername(username);
        if(compte != null) {
            return compte.currentDetails();
        }
        
        throw new UsernameNotFoundException("Aucun compte avec se nom de compte");
    }
    
}
