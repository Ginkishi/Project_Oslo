package edu.uha.miage;

import edu.uha.miage.core.entity.StatutDemande;
import edu.uha.miage.core.service.StatutDemandeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Psyrkoz
 */
@Order(3)
@Component
public class DemoStatut implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDepartement.class);

    @Autowired
    private StatutDemandeService statutDemandeService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {

        createStatut("Ouvert");
        createStatut("En cours");
        createStatut("Clôturée");
    }

    private void createStatut(String name) {
        StatutDemande cpt = statutDemandeService.findByLibelle(name);
        if (cpt == null) {

            StatutDemande c = new StatutDemande(name);

            statutDemandeService.save(c);
            LOGGER.info("BDD DEMO - Création du statut " + name);
        } else {
            LOGGER.info("BDD DEMO - Le statut " + name + " existait déjà");
        }
    }
}
