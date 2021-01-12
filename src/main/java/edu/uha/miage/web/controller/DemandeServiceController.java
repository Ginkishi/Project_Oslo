/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.DemandeServices;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.DemandeServiceService;
import edu.uha.miage.core.service.PersonneService;
import edu.uha.miage.core.service.ServiceService;
import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author quentin
 */
@Controller
@RequestMapping("/demandeService")
public class DemandeServiceController {
    private final Logger LOGGER = LoggerFactory.getLogger(DemandeServiceController.class);
    
    @Autowired
    DemandeServiceService demandeServiceService;
    
    @Autowired
    ServiceService serviceService;
    
    @Autowired
    PersonneService personneService;
    
    @Autowired
    CompteService compteService;

    @GetMapping("/createDemandeServiceFromCatalogue")
    public String createFromCatalogue(@RequestParam(required = true) String serviceName, Model model) {
        DemandeServices demande = new DemandeServices();
        Services svc = serviceService.findByLibelle(serviceName);
        demande.setService(svc);
        demande.setPriorite(svc.getPriorite());
        
        demande.setDate_creation(new Date());        
        model.addAttribute("demandeService", demande);
        return "demandeService/create.html";
    }
    
    @PostMapping("/create")
    public String create(@Valid DemandeServices ds, BindingResult br, Model model)
    {
        if(br.hasErrors()) {
            return "catalogue/list.html";
        }
        else {
            Optional<Services> svc = serviceService.findById(ds.getService().getId());
            ds.setService(svc.get());
            demandeServiceService.save(ds);
        }
        return "home.html";
    }
}
