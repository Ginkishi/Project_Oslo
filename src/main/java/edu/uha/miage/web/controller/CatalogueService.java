/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Domaine;
import edu.uha.miage.core.service.DomaineService;
import edu.uha.miage.core.service.ServiceService;
import javax.annotation.Generated;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author quentin
 */
@Controller
public class CatalogueService {
    
    @Autowired
    ServiceService serviceService;
    
    @GetMapping("/catalogue")
    public String viewList(Model model) {
        model.addAttribute("services", serviceService.findAll());
        return "catalogue/list";
    }
}
