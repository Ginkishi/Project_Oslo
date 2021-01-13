package edu.uha.miage;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.service.DepartementService;
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
@Order(2)
@Component
public class DemoDepartement implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDepartement.class);

    @Autowired
    private DepartementService departementService;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {
        createDepartement("Ressources Humaines");
        createDepartement("Comptabilité");
        createDepartement("Informatique");
        createDepartement("Sécurité");
    }

    private void createDepartement(String libelle) {
        Departement c = departementService.findByLibelle(libelle);
        if (c == null) {
            c = new Departement(libelle);
            departementService.save(c);
            LOGGER.info("BDD DEMO - Création du département {}", libelle);
        } else {
            LOGGER.info("BDD DEMO - Le département {} existait déjà", libelle);
        }
    }
}
