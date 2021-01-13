package edu.uha.miage;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.entity.Role;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.PersonneService;
import edu.uha.miage.core.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Psyrkoz
 */
@Order(5)
@Component
public class DemoCompte implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDepartement.class);

    @Autowired
    private PersonneService personneService;
    
    @Autowired
    private CompteService compteService;
    
    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {
        Personne p = personneService.findByNomAndPrenomAndEmailAndAdresse("Menethil", "Arthas", "arthas@admin.com", "Stratholme");
        createCompte("admin", "admin123", p);
    }

    private void createCompte(String username, String password, Personne p) {
        Compte cpt = compteService.findByUsername("admin");
        if (cpt == null) {
            Role r = roleService.findByLibelle("ROLE_ADMIN");
            Compte c = new Compte(username, PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password), p, r);
            
            compteService.save(c);
            LOGGER.info("BDD DEMO - Création du compte admin");
        } else {
            LOGGER.info("BDD DEMO - Le compte admin existait déjà");
        }
    }
}
