package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Demande;
import edu.uha.miage.core.entity.DemandeIncident;
import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.entity.Fonction;
import edu.uha.miage.core.entity.Incident;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.entity.StatutDemande;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.DemandeIncidentService;
import edu.uha.miage.core.service.DemandeService;
import edu.uha.miage.core.service.DemandeServiceService;
import edu.uha.miage.core.service.FonctionService;
import edu.uha.miage.core.service.StatutDemandeService;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Autowired
    StatutDemandeService statusDemandeService;
    
    // ("/demandes")
    @GetMapping("/viewDemandes")
    public String findAll(Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();
        Set<DemandeServices> demandesServiceses = new LinkedHashSet<>();
        Set<DemandeIncident> demandesIncidents = new LinkedHashSet<>();
        
        for (Fonction f : userPersonne.getOccupations()) {
            for (Services s : f.getOccupeServices()) {
                for (DemandeServices ds : s.getDemande_service()) {
                    if (ds.getDate_cloture() == null)
                        demandesServiceses.add(ds);
                }
            }
            for (Incident i : f.getOccupeIncident()) {
                for (DemandeIncident di : i.getDemandeIncidents()) {
                    if (di.getDate_cloture() == null)
                        demandesIncidents.add(di);
                }
            }
        }
        
        model.addAttribute("demandesServiceses", demandesServiceses);
        model.addAttribute("demandesIncidents", demandesIncidents);
        return "demande/viewDemandes";
    }

    @GetMapping("/demandes/{id}/intervient")
    public String PersonneIntervientPour(@PathVariable("id") Long id, Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();
        Demande d = demandeService.findById(id).get();
        if (d.getDate_cloture() == null) {
            StatutDemande sd = statusDemandeService.findByLibelle("En cours");
            d.setStatut_demande(sd);
            List<Personne> l = d.getIntervenants();
            l.add(userPersonne);
            d.setIntervenants(l);
            demandeService.save(d);
        }
        return findAll(model);
    }
    
    @GetMapping("/demandes/{id}/cloture")
    public String Cloture(@PathVariable("id") Long id, Model model) {
        //TODO Check si le mec est intervenant sur la demande
        Optional<DemandeServices> ds = demandeServiceService.findById(id);
        Demande d = demandeService.findById(id).get();
        StatutDemande sd = statusDemandeService.findByLibelle("Clôturée");
        d.setStatut_demande(sd);
        d.setDate_cloture(new Date());
        demandeService.save(d);
        if (ds.isPresent())
            return "redirect:/demandeService";        
        return "redirect:/demande/incident";
    }
}
