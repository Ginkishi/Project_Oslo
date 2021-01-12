package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Categorie;
import edu.uha.miage.core.service.CategorieService;
import edu.uha.miage.core.service.ServiceService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author quentin
 */
@Controller
public class CatalogueService {
    private final Logger LOGGER = LoggerFactory.getLogger(InscriptionController.class);
    
    @Autowired
    ServiceService serviceService;
    
    @Autowired
    CategorieService categorieSvc;
    
    @GetMapping("/catalogue")
    public String viewListCategory(@RequestParam(required = false, name = "category") List<String> categories, Model model) {
        if(categories != null) {
            LOGGER.error(categories.toString());
            model.addAttribute("parent", explode(categories));
            
            List<Categorie> nextCategories = categorieSvc.findByLibelle(categories.get(categories.size() - 1)).getEnfants();
            if(!nextCategories.isEmpty())
                model.addAttribute("categories", nextCategories);
            else
                model.addAttribute("services", serviceService.findByCategorie(categorieSvc.findByLibelle(categories.get(categories.size() - 1))));
        }
        else
        {
            model.addAttribute("parent", "null");
            model.addAttribute("categories", categorieSvc.findByParent(null));
        }
        
        return "catalogue/list";
    }
    
    // Passe de ["Categorie1", "Categorie2"] a "Categorie1,Categorie2"
    private String explode(List<String> arr) {
        String result = "";
        for(int i = 0; i < arr.size() - 1; i++)
            result += arr.get(i) + ",";
        
        return result + arr.get(arr.size()-1);
    }
}
