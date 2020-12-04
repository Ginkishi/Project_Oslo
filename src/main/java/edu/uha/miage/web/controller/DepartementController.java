/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Departement;
import edu.uha.miage.core.service.DepartementService;
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
 * @author victo
 */
@Controller
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    DepartementService departementService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("departements", departementService.findAll());
        return "departement/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Departement departement = new Departement();
        model.addAttribute("departement", departement);
        return "departement/edit";
    }


    @PostMapping("/create")
    public String created(@Valid Departement departement, BindingResult br) {

        if (br.hasErrors()) {
            return "departement/edit";
        }
        departementService.save(departement);
        return "redirect:/departement";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("departement", departementService.findById(id).get());
        return "departement/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Departement departement, BindingResult br) {
        if (br.hasErrors()) {
            return "departement/edit";
        }

        departementService.save(departement);
        return "redirect:/departement";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        departementService.delete(id);
        return "redirect:/departement";
    }
}
