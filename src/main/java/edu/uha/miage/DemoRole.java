/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage;

import edu.uha.miage.core.entity.Role;
import edu.uha.miage.core.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author victo
 */
@Order(1)
@Component
public class DemoRole implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoRole.class);

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {
        createRole("ROLE_ADMIN");
        createRole("ROLE_COLLABORATEUR");
        createRole("ROLE_INTERVENANT");
    }

    private void createRole(String libelle) {
        Role c = roleService.findByLibelle(libelle);
        if (c == null) {
            c = new Role(libelle);
            roleService.save(c);
            // #### V1.1 Log pour indiquer que le département a été créée
            LOGGER.info("BDD DEMO - Création du role {}", libelle);
        } else {
            LOGGER.info("BDD DEMO - Le role {} existait déjà", libelle);
            // #### V1.1 Remarque : {} est remplacé par libelle dans la chaîne.
            // #### V1.1 C'est une façon de formater.
        }
    }
}
