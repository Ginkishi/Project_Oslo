/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Demande;
import edu.uha.miage.core.entity.DemandeIncident;
import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.entity.Fonction;
import edu.uha.miage.core.entity.Incident;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.DemandeIncidentService;
import edu.uha.miage.core.service.DemandeService;
import edu.uha.miage.core.service.DemandeServiceService;
import edu.uha.miage.core.service.DomaineService;
import edu.uha.miage.core.service.FonctionService;
import edu.uha.miage.core.service.IncidentService;
import edu.uha.miage.core.service.StatutDemandeService;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kalictong
 */
@Controller
public class DemandeController {

    @Autowired
    DemandeIncidentService demandeIncidentService;

    @Autowired
    DemandeServiceService demandeServiceService;

    @Autowired
    DemandeService demandeService;
    
    @Autowired
    FonctionService fonctionService;

    @Autowired
    CompteService compteService;

    @GetMapping("/viewDemandes")
    public String findAll(Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();
        Set<DemandeServices> demandesServiceses = new LinkedHashSet<>();
        Set<DemandeIncident> demandesIncidents = new LinkedHashSet<>();
        
        for (Fonction f : userPersonne.getOccupations()) {
            for (Services s : f.getOccupeServices()) {
                for (DemandeServices ds : s.getDemande_service()) {
                    demandesServiceses.add(ds);
                }
            }
            for (Incident i : f.getOccupeIncident()) {
                for (DemandeIncident di : i.getDemandeIncidents()) {
                    demandesIncidents.add(di);
                }
            }
        }
        
        model.addAttribute("demandesServiceses", demandesServiceses);
        model.addAttribute("demandesIncidents", demandesIncidents);
        return "demande/viewDemandes";
    }

    @GetMapping("/demande/{id}/intervient")
    public String PersonneIntervientPour(@PathVariable("id") Long id, Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();
        Demande d = demandeService.findById(id).get();
        List<Personne> l = d.getIntervenants();
        l.add(userPersonne);
        d.setIntervenants(l);
        demandeService.save(d);
        
        //TODO : Mettre un truc logique
        return findAll(model);
    }
    
    @GetMapping("/demande/{id}/cloture")
    public String Cloture(@PathVariable("id") Long id, Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();
        Demande d = demandeService.findById(id).get();
        List<Personne> l = d.getIntervenants();
        l.add(userPersonne);
        d.setIntervenants(l);
        demandeService.save(d);
        
        //TODO : Mettre un truc logique
        return findAll(model);
    }
}
