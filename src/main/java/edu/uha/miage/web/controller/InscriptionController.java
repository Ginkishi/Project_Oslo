package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.entity.Fonction;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.DepartementService;
import edu.uha.miage.core.service.FonctionService;

import edu.uha.miage.core.service.PersonneService;
import edu.uha.miage.core.service.RoleService;

import edu.uha.miage.model.Inscription;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author victo
 */
@Controller
@RequestMapping("/inscription")
public class InscriptionController {

    

    @Autowired
    PersonneService personneService;

    @Autowired
    DepartementService departementService;

    @Autowired
    FonctionService fonctiontService;

    @Autowired
    CompteService compteService;

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String inscription(Model model) {
        model.addAttribute("inscription", new Inscription());

        model.addAttribute("fonctions", fonctiontService.findAll());
        //LOGGER.warn("ATTENTION GET FAIT SUR INSCRIPTION");

        return "inscription2";
    }

    @RequestMapping(method = RequestMethod.POST)

    public String inscrit(@Valid Inscription inscription, BindingResult br, Model model) {
        //LOGGER.warn("J'ai mis recu un post");

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //Users user = new Users(inscription.getUsername(), "{noop}"+inscription.getPassword());

        if (br.hasErrors()) {
            model.addAttribute("fonctions", fonctiontService.findAll());
            return "inscription2";
        }


        //LOGGER.warn("Je suis la!!!");
        Personne user = new Personne(inscription.getNom(), inscription.getPrenom(), inscription.getAdresse(), inscription.getEmail());

        user.setOccupations(inscription.getFonctions());

        for (Fonction f : inscription.getFonctions()) {
            f.getOccupationDePersonne().add(user);
        }
        personneService.save(user);
        //LOGGER.warn("BB JAI SAVE LA PERSONNE");
        Compte compte = new Compte(inscription.getUsername(), encoder.encode(inscription.getPassword()), user, roleService.findByLibelle("ROLE_COLLABORATEUR"));
        compteService.save(compte);

        //LOGGER.warn("Super j'ai bien fini l'inscription");

        

        return "redirect:/login";
    }
}
