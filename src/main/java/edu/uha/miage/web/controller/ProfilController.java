package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Psyrkoz
 */
@Controller
@RequestMapping("/profil")
public class ProfilController {    
    @Autowired
    CompteService compteService;
    
    @Autowired
    PersonneService personneService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String profil(Model model) {
        Compte cpt = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("compte", cpt);

        return "profil/index";

    }
}
