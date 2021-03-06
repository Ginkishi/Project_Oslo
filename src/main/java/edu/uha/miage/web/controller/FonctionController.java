package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Fonction;
import edu.uha.miage.core.service.DepartementService;
import edu.uha.miage.core.service.FonctionService;
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
@RequestMapping("/fonction")
public class FonctionController {

    @Autowired
    FonctionService fonctionService;

    @Autowired
    DepartementService departementService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("fonctions", fonctionService.findAll());
        return "fonction/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Fonction fonction = new Fonction();
        model.addAttribute("fonction", fonction);
        model.addAttribute("departements", departementService.findAll());
        return "fonction/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Fonction fonction, BindingResult br, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("departements", departementService.findAll());
            return "fonction/edit";
        }
        fonctionService.save(fonction);
        return "redirect:/fonction";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("fonction", fonctionService.findById(id).get());
        model.addAttribute("departements", departementService.findAll());
        return "fonction/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Fonction fonction, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("departements", departementService.findAll());
            return "fonction/edit";
        }

        fonctionService.save(fonction);
        return "redirect:/fonction";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        fonctionService.delete(id);
        return "redirect:/fonction";
    }
}
