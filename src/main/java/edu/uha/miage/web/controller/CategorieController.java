/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Categorie;
import edu.uha.miage.core.service.CategorieService;
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
@RequestMapping("/categorie")
public class CategorieController {
     @Autowired
    CategorieService categorieService;
     
     @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("categories", categorieService.findAll());
        return "categorie/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Categorie categorie = new Categorie();
        model.addAttribute("categorie", categorie);
        model.addAttribute("categories", categorieService.findAll());
        return "categorie/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Categorie categorie, BindingResult br, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("categories", categorieService.findAll());
            return "categorie/edit";
        }
        categorieService.save(categorie);
        return "redirect:/categorie";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("categorie", categorieService.findById(id).get());
        model.addAttribute("categories", categorieService.findAll());
        return "categorie/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Categorie categorie, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("categories", categorieService.findAll());
            return "categorie/edit";
        }

        categorieService.save(categorie);
        return "redirect:/categorie";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categorieService.delete(id);
        return "redirect:/categorie";
    }
}
