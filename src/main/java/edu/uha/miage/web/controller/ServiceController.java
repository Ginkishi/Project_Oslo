/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.service.CategorieService;
import edu.uha.miage.core.service.ServiceService;
import edu.uha.miage.core.service.StorageService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author victo
 */
@Controller
@RequestMapping("/service")
public class ServiceController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);
    @Autowired
    ServiceService serviceService;

    @Autowired
    CategorieService categorieService;
    
    private final StorageService storageService;
    
    @Autowired
    public ServiceController(StorageService storageService) {
            this.storageService = storageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("services", serviceService.findAll());
        return "service/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Services service = new Services();
        model.addAttribute("service", service);
        model.addAttribute("categories", categorieService.findByEnfantsIsNull());
        return "service/edit";
    }

    @PostMapping("/create")
    public String created(@RequestParam(name = "file", required=false) MultipartFile file, @Valid Services service, BindingResult br, Model model) {        
        if (br.hasErrors()) {
            model.addAttribute("categories", categorieService.findAll());
            return "service/edit";
        }
        else
        {
            if(file != null) {
                LOGGER.error("Got a file - File:");
                LOGGER.error(file.getOriginalFilename());
                storageService.store(file);
                service.setImage(file.getOriginalFilename());
            }
            else
            {
                service.setImage(null);
            }
        }
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("service", serviceService.findById(id).get());
        model.addAttribute("categories", categorieService.findAll());
        return "service/edit";
    }

    @PostMapping("/edit")
    public String edited(@RequestParam(name = "file", required=false) MultipartFile file, @Valid Services service, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("categories", categorieService.findAll());
            return "service/edit";
        }
        else {
            // Si on a recu une image
            if(!file.isEmpty()) {
                storageService.store(file);
                service.setImage(file.getOriginalFilename());
            }
            else {
                Services s = serviceService.findById(service.getId()).get();
                service.setImage(s.getImage());
            }
             
            serviceService.save(service);
            return "redirect:/service";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        serviceService.delete(id);
        return "redirect:/service";
    }
    
    @GetMapping("/deleteIMG/{id}")
    public String deleteIMG(@PathVariable("id") Long id) {
        Services s = serviceService.findById(id).get();
        s.setImage(null);
        serviceService.save(s);
        
        return "redirect:/service/edit?id=" + id;
    }
}
