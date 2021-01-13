/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.PersonneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private final Logger LOGGER = LoggerFactory.getLogger(InscriptionController.class);
    
    @Autowired
    CompteService compteService;
    
    @Autowired
    PersonneService personneService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String profil(Model model) {
        Compte cpt = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("compte", cpt);
        return "/profil/index.html";
    }
}
