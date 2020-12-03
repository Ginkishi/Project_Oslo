/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Role;
import edu.uha.miage.core.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "role/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "role/edit";
    }


    @PostMapping("/create")
    public String created(@Valid Role role, BindingResult br) {

        if (br.hasErrors()) {
            return "role/edit";
        }
        roleService.save(role);
        return "redirect:/role";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("role", roleService.findById(id).get());
        return "role/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Role role, BindingResult br) {
        if (br.hasErrors()) {
            return "role/edit";
        }

        roleService.save(role);
        return "redirect:/role";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return "redirect:/role";
    }
}
