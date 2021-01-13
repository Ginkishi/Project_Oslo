package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Personne;
import edu.uha.miage.core.service.CompteService;
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
import edu.uha.miage.core.service.PersonneService;


@Controller
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    PersonneService personneService;
    
    @Autowired
    CompteService compteService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("personnes", personneService.findAll());
        return "personne/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("personne", personneService.findById(id).get());
        return "personne/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Personne personne, BindingResult br) {
        if (br.hasErrors()) {
            return "personne/edit";
        }

        personneService.save(personne);
        return "redirect:/personne";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        personneService.delete(id);
        return "redirect:/personne";
    }
}
