package edu.uha.miage.web.controller;

import edu.uha.miage.core.entity.Categorie;
import edu.uha.miage.core.entity.Services;
import edu.uha.miage.core.service.CategorieService;
import edu.uha.miage.core.service.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author quentin
 */
@Controller
public class CatalogueService {

    @Autowired
    ServiceService serviceService;

    @Autowired
    CategorieService categorieSvc;

    @GetMapping("/catalogue")
    public String viewListCategory(@RequestParam(required = false, name = "category") List<String> categories, Model model) {
        if (categories != null) {
            model.addAttribute("parent", explode(categories));

            List<Categorie> nextCategories = categorieSvc.findByLibelle(categories.get(categories.size() - 1)).getEnfants();
            if (!nextCategories.isEmpty()) {
                model.addAttribute("categories", nextCategories);
            } else {
                model.addAttribute("services", serviceService.findByCategorie(categorieSvc.findByLibelle(categories.get(categories.size() - 1))));
            }
        } else {
            model.addAttribute("parent", "null");
            model.addAttribute("categories", categorieSvc.findByParent(null));
        }

        return "catalogue/list";
    }

    @GetMapping("/catalogue2")
    public String viewListCategory2(Model model) {

        model.addAttribute("categories", categorieSvc.findByParent(null));

        return "catalogue/list2";
    }

    @GetMapping("/child/{id}")
    @ResponseBody
    public String viewListChild(@PathVariable("id") Long id) {
        List<Categorie> list = categorieSvc.findById(id).get().getEnfants();
        return explodeListOfCategory(list);
    }

    @GetMapping("/catalogue/services/{id}")
    @ResponseBody
    public String viewListServices(@PathVariable("id") Long id) {
        List<Services> list = serviceService.findByCategorie(categorieSvc.findById(id).get());
        return explodeListOfService(list);
    }

    // Passe de ["Categorie1", "Categorie2"] a "Categorie1,Categorie2"
    private String explode(List<String> arr) {
        String result = "";
        for (int i = 0; i < arr.size() - 1; i++) {
            result += arr.get(i) + ",";
        }

        return result + arr.get(arr.size() - 1);
    }

    private String explodeListOfCategory(List<Categorie> arr) {
        if (arr.size() > 0) {
            String result = "[";
            for (int i = 0; i < arr.size() - 1; i++) //result += "{id:"+arr.get(i).getId()+ ", libelle : "+arr.get(i).getLibelle()+"}," ;
            {
                result += arr.get(i).toJson() + ",";
            }
            //return result + "{id:"+arr.get(arr.size()-1).getId()+ ", libelle : "+arr.get(arr.size()-1).getLibelle()+"}]" ;
            return result + arr.get(arr.size() - 1).toJson() + "]";
        } else {
            return "[]";
        }
    }

    private String explodeListOfService(List<Services> arr) {
        if (arr.size() > 0) {
            String result = "[";
            for (int i = 0; i < arr.size() - 1; i++) {
                result += arr.get(i).toJson() + ",";
            }

            return result + arr.get(arr.size() - 1).toJson() + "]";
        } else {
            return "[]";
        }

    }
}
