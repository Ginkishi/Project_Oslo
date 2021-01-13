package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.DemandeServiceService;
import edu.uha.miage.core.service.PersonneService;
import edu.uha.miage.core.service.ServiceService;
import edu.uha.miage.core.service.StatutDemandeService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Psyrkoz
 */
@Controller
@RequestMapping("/demande/service")
public class DemandeServiceController {
    @Autowired
    DemandeServiceService demandeServiceService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    StatutDemandeService statutDemandeService;

    @Autowired
    PersonneService personneService;

    @Autowired
    CompteService compteService;

    @GetMapping("/create")
    public String createFromCatalogue(@RequestParam(required = true) String serviceName, Model model) {
        DemandeServices demande = new DemandeServices();
        Services svc = serviceService.findByLibelle(serviceName);
        demande.setService(svc);
        demande.setImportance(svc.getPriorite());

        demande.setDate_creation(new Date());
        model.addAttribute("demandeService", demande);
        return "demandeService/create.html";
    }

    @PostMapping("/create")
    public String create(@Valid DemandeServices ds, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "redirect:catalogue/list.html";
        } else {
            Optional<Services> svc = serviceService.findById(ds.getService().getId());
            ds.setService(svc.get());
            ds.setCreateur(compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne());
            ds.setStatut_demande(statutDemandeService.findByLibelle("Ouvert"));
            demandeServiceService.save(ds);
        }
        return "redirect:/demande/service";
    }

   
    
    @GetMapping
    public String mesDemandes(Model model) {
        Personne userPersonne = compteService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPersonne();
        List<DemandeServices> demandes = demandeServiceService.findByCreateur(userPersonne);

        model.addAttribute("demandes", demandes);
        return "demandeService/list.html";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        DemandeServices d = demandeServiceService.findById(id).get();
        if (d.getDate_cloture() == null) {
            model.addAttribute("demandeService", demandeServiceService.findById(id));
            return "demandeService/edit";
        }
        return "redirect:/home";
    }
    
    @PostMapping("/edit")
    public String edited(@Valid DemandeServices ds, BindingResult br, Model model) {
        DemandeServices deman = demandeServiceService.findById(ds.getId()).get();
        if (deman.getDate_cloture() == null) {
            // One trick little pony
            if(ds.getSujet().length() >= 2 && ds.getSujet().length() <= 50)     
                deman.setSujet(ds.getSujet());
            deman.setDescription(ds.getDescription());
            demandeServiceService.save(deman);
        }
        return "redirect:/demande/service";
    }
}
