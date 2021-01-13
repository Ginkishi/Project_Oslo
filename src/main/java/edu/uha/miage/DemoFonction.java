/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.entity.Fonction;
import edu.uha.miage.core.service.DepartementService;
import edu.uha.miage.core.service.FonctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author victo
 */
@Order(5)
@Component
public class DemoFonction implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoFonction.class);

    @Autowired
    private FonctionService fonctionService;
    @Autowired
    private DepartementService departementService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {
        createFonction("Secrétaire", "Ressources Humaines");
        createFonction("Comptable", "Comptabilité");
        createFonction("Développeur", "Informatique");
        createFonction("Administrateur réseau", "Informatique");
        createFonction("Agent de sécurité", "Sécurité");
    }

    private void createFonction(String libelle, String departement) {

        Fonction c = fonctionService.findByLibelle(libelle);
        if (c == null) {
            Departement d = departementService.findByLibelle(departement);
            c = new Fonction(libelle, d);
            fonctionService.save(c);
            // #### V1.1 Log pour indiquer que le département a été créée
            LOGGER.info("BDD DEMO - Création de la fonction {}", libelle);
        } else {
            LOGGER.info("BDD DEMO - La fonction {} existait déjà", libelle);
            // #### V1.1 Remarque : {} est remplacé par libelle dans la chaîne.
            // #### V1.1 C'est une façon de formater.
        }
    }
}
