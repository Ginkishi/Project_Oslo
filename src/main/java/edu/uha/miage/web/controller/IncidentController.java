package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Incident;
import edu.uha.miage.core.service.DomaineService;
import edu.uha.miage.core.service.FonctionService;
import edu.uha.miage.core.service.IncidentService;
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
 * @author Psyrkoz
 */
@Controller
@RequestMapping("/incident")
public class IncidentController {

    @Autowired
    IncidentService incidentService;

    @Autowired
    DomaineService domaineService;

    @Autowired
    FonctionService fonctionService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("incidents", incidentService.findAll());
        return "incident/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Incident incident = new Incident();
        model.addAttribute("incident", incident);
        model.addAttribute("domaines", domaineService.findAll());
        model.addAttribute("fonctions", fonctionService.findAll());
        return "incident/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Incident incident, BindingResult br, Model model) {

        if (br.hasErrors()) {
            model.addAttribute("categories", domaineService.findAll());
            return "incident/edit";
        }
        incidentService.save(incident);
        return "redirect:/incident";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("incident", incidentService.findById(id).get());
        model.addAttribute("domaines", domaineService.findAll());
        model.addAttribute("fonctions", fonctionService.findAll());
        return "incident/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Incident incident, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("categories", domaineService.findAll());
            model.addAttribute("fonctions", fonctionService.findAll());
            return "service/edit";
        }

        incidentService.save(incident);
        return "redirect:/incident";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        incidentService.delete(id);
        return "redirect:/incident";
    }
}
