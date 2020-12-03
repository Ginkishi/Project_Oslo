package edu.uha.miage;

import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.service.PersonneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Quentin
 */
@Order(2)
@Component
public class DemoPersonne implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDepartement.class);

    @Autowired
    private PersonneService personneService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {
        createPersonne("Stratholme", "arthas@admin.com", "Menethil", "Arthas");
    }

    private void createPersonne(String adresse, String email, String nom, String prenom) {
        Personne p = personneService.findByNomAndPrenomAndEmailAndAdresse(nom, prenom, email, adresse);
        if (p == null) {
            p = new Personne(nom, prenom, adresse, email);
            personneService.save(p);
            LOGGER.info("BDD DEMO - Création de la personne {} {} {} {}", nom, prenom, email, adresse);
        } else {
            LOGGER.info("BDD DEMO - La personne {} {} {} {} existait déjà", nom, prenom, email, adresse);
        }
    }
}
