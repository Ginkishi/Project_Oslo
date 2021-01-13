package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.StatutDemande;
import edu.uha.miage.core.service.StatutDemandeService;
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
@RequestMapping("/statutDemande")
public class StatutDemandeController {
         @Autowired
    StatutDemandeService statutDemandeService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("statutDemandes", statutDemandeService.findAll());
        return "statutDemande/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        StatutDemande statutDemande = new StatutDemande();
        model.addAttribute("statutDemande", statutDemande);
        return "statutDemande/edit";
    }


    @PostMapping("/create")
    public String created(@Valid StatutDemande statutDemande, BindingResult br) {

        if (br.hasErrors()) {
            return "statutDemande/edit";
        }
        statutDemandeService.save(statutDemande);
        return "redirect:/statutDemande";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("statutDemande", statutDemandeService.findById(id).get());
        return "statutDemande/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid StatutDemande statutDemande, BindingResult br) {
        if (br.hasErrors()) {
            return "statutDemande/edit";
        }

        statutDemandeService.save(statutDemande);
        return "redirect:/statutDemande";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        statutDemandeService.delete(id);
        return "redirect:/statutDemande";
    }
}
