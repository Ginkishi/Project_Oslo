/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Domaine;
import edu.uha.miage.core.service.DomaineService;
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
@RequestMapping("/domaine")
public class DomaineController {
     @Autowired
    DomaineService domaineService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("domaines", domaineService.findAll());
        return "domaine/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Domaine domaine = new Domaine();
        model.addAttribute("domaine", domaine);
        return "domaine/edit";
    }


    @PostMapping("/create")
    public String created(@Valid Domaine domaine, BindingResult br) {

        if (br.hasErrors()) {
            return "domaine/edit";
        }
        domaineService.save(domaine);
        return "redirect:/domaine";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("domaine", domaineService.findById(id).get());
        return "domaine/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Domaine domaine, BindingResult br) {
        if (br.hasErrors()) {
            return "domaine/edit";
        }

        domaineService.save(domaine);
        return "redirect:/domaine";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        domaineService.delete(id);
        return "redirect:/domaine";
    }
}
