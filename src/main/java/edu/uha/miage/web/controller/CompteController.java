package edu.uha.miage.web.controller;

import edu.uha.miage.DemoDepartement;
import edu.uha.miage.core.entity.Categorie;
import edu.uha.miage.core.entity.Compte;
import edu.uha.miage.core.service.CompteService;
import edu.uha.miage.core.service.RoleService;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Psyrkoz
 */
@Controller
@RequestMapping("/compte")
public class CompteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompteController.class);
    
    @Autowired
    CompteService compteService;
    
    @Autowired
    RoleService roleService;
     
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("comptes", compteService.findAll());
        return "compte/list";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("compte", compteService.findById(id).get());
        model.addAttribute("roles", roleService.findAll());
        return "compte/edit";
    }
    
    @PostMapping("/edit")
    public String edited(@Valid Compte compte, BindingResult br, Model model) {
        if (br.hasErrors()) {
            LOGGER.error("C'est bugged");
            LOGGER.error(br.getAllErrors().toString());
            model.addAttribute("roles", roleService.findAll());
            return "compte/edit";
        }

        compteService.save(compte);
        return "redirect:/compte";
    }
}
