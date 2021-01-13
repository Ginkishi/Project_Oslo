package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.DemandeIncident;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.DemandeIncidentService;
import edu.uha.miage.core.service.DomaineService;
import edu.uha.miage.core.service.FonctionService;
import edu.uha.miage.core.service.IncidentService;
import edu.uha.miage.core.service.StatutDemandeService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/demande/incident")
public class DemandeIncidentController {

    @Autowired
    DemandeIncidentService demandeIncidentService;

    @Autowired
    IncidentService incidentService;

    @Autowired
    StatutDemandeService statutDemandeService;

    @Autowired
    DomaineService domaineService;

    @Autowired
    FonctionService fonctionService;

    @Autowired
    CompteService compteService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        List<DemandeIncident> d = demandeIncidentService.findAll();
        model.addAttribute("demandeIncidents", demandeIncidentService.findAll());
        return "demande/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        DemandeIncident demandeIncident = new DemandeIncident();
        demandeIncident.setDate_creation(new Date());
        model.addAttribute("demandeIncident", demandeIncident);
        model.addAttribute("incidents", incidentService.findAll());
        model.addAttribute("domaines", domaineService.findAll());
        model.addAttribute("fonctions", fonctionService.findAll());
        return "demande/edit";
    }

    @PostMapping("/create")
    public String created(@Valid DemandeIncident demandeIncident, BindingResult br, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("incidents", incidentService.findAll());
            model.addAttribute("domaines", domaineService.findAll());
            model.addAttribute("fonctions", fonctionService.findAll());
            return "demande/edit";
        }
        demandeIncident.setStatut_demande(statutDemandeService.findByLibelle("Ouvert"));
        demandeIncident.setCreateur(compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne());
        demandeIncidentService.save(demandeIncident);
        return "redirect:/demande/incident";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        DemandeIncident d = demandeIncidentService.findById(id).get();
        if (d.getDate_cloture() == null) {
            model.addAttribute("demandeIncident", demandeIncidentService.findById(id).get());
            model.addAttribute("incidents", incidentService.findAll());
            model.addAttribute("domaines", domaineService.findAll());
            model.addAttribute("fonctions", fonctionService.findAll());
            return "demande/edit";
        }
        return "redirect:/home";
    }

    @PostMapping("/edit")
    public String edited(@Valid DemandeIncident demandeIncident, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("incidents", incidentService.findAll());
            model.addAttribute("domaines", domaineService.findAll());
            model.addAttribute("fonctions", fonctionService.findAll());
            return "demande/edit";
        }
        
        if (demandeIncident.getDate_cloture() == null) 
            demandeIncidentService.save(demandeIncident);
        return "redirect:/demande/incident";
    }

}
