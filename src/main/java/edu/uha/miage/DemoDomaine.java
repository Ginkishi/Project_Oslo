package edu.uha.miage;

import edu.uha.miage.core.entity.Domaine;
import edu.uha.miage.core.service.DomaineService;
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
public class DemoDomaine implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDepartement.class);

    @Autowired
    private DomaineService domaineService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {

        createStatut("Informatique");

    }

    private void createStatut(String name) {
        Domaine cpt = domaineService.findByLibelle(name);
        if (cpt == null) {

            Domaine c = new Domaine(name);

            domaineService.save(c);
            LOGGER.info("BDD DEMO - Création du domaine " + name);
        } else {
            LOGGER.info("BDD DEMO - Le domaine " + name + " existait déjà");
        }
    }
}
